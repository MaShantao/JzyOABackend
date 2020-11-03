package com.jzyoa.service.impl;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.policy.PictureRenderPolicy;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzyoa.entity.PageResult;
import com.jzyoa.entity.Result;
import com.jzyoa.mapper.TbDictionaryMapper;
import com.jzyoa.mapper.TbManagerMapper;
import com.jzyoa.mapper.TbReportMapper;
import com.jzyoa.pojo.TbDictionary;
import com.jzyoa.pojo.TbManager;
import com.jzyoa.pojo.TbReport;
import com.jzyoa.pojo.TbReportExample;
import com.jzyoa.pojo.TbSpecimen;
import com.jzyoa.service.DictionaryService;
import com.jzyoa.service.ReportService;
import com.jzyoa.service.SpecimenService;
import com.jzyoa.util.FileUtil;
import com.jzyoa.util.PDFUtil;
import com.jzyoa.util.StringUtil;
import com.jzyoa.util.UUIDUtil;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	TbReportMapper reportMapper;

	@Autowired
	SpecimenService specimenService;

	@Autowired
	private TbDictionaryMapper dictionMapper;

	@Autowired
	private TbManagerMapper managerMapper;

	@Autowired
	private DictionaryService dictionaryService;

	@Override
	public void downWord(Map<String, Object> data, String templatePath, String saveName, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PDFUtil.pdfout(data, templatePath, saveName);
		FileUtil.downFile(request, response, saveName);
		FileUtil.deleteDir(saveName);
	}

	@Override
	public Result save(TbReport saveReport, HttpServletRequest request, HttpServletResponse response) {
		try {
			createReport(saveReport, request, response);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "报告生成失败");
		}
		/// 将样本设置成已经生成报告
		saveReport.getSpecimen().setSpecimenStatusId(1);
		if (!specimenService.update(saveReport.getSpecimen()).isSuccess()) {
			return new Result(false, "报告生成失败+++++++++");
		}
		return reportMapper.insert(saveReport) > 0 ? new Result(true, "报告生成成功") : new Result(false, "报告生成失败");
	}

	@Override
	public TbReport getBySpecimenId(Integer specimenId) {
		TbReportExample reportExample = new TbReportExample();
		TbReportExample.Criteria createCriteria = reportExample.createCriteria();
		if (specimenId != null && !specimenId.equals(0)) {
			createCriteria.andSpecimenIdEqualTo(specimenId);
		}
		List<TbReport> reportList = reportMapper.selectByExample(reportExample);
		return reportList != null && reportList.size() != 0 ? reportList.get(0) : null;
	}

	@Override
	public TbReport getById(Integer reportId) {
		return reportMapper.selectByPrimaryKey(reportId);
	}

	@Override
	public Result update(TbReport updateReport, HttpServletRequest request, HttpServletResponse response) {
		try {
			createReport(updateReport, request, response);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "报告更新失败");
		}
		return reportMapper.updateByPrimaryKey(updateReport) > 0 ? new Result(true, "报告更新成功")
				: new Result(false, "报告更新失败");
	}

	@Override
	public void createReport(TbReport saveReport, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Map<String, Object> reportPara = wrapReportPara(saveReport);
		/// 生成模板的文件名
		String templateFile = System.getProperty("user.dir") + "\\"
				+ saveReport.getSpecimen().getTestType().getDictMark() + "_template.pdf";
		/// 生成+下载文件
		downWord(reportPara, templateFile, UUIDUtil.getCode() + ".pdf", request, response);
	}

	@Override
	public PageResult listRoughly(TbReport searchReport, int pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TbReportExample reportExample = new TbReportExample();
		TbReportExample.Criteria createCriteria = reportExample.createCriteria();
		if (searchReport != null) {
			if (searchReport.getReportId() != null && !searchReport.getReportId().equals(0)) {
				createCriteria.andReportIdEqualTo(searchReport.getReportId());
			}
			if (searchReport.getCreateTime() != null && searchReport.getCreateTime().split("--").length == 2) {
				createCriteria.andCreateTimeBetween(searchReport.getCreateTime().split("--")[0],
						searchReport.getCreateTime().split("--")[1]);
			}
		}
		Page<TbReport> pages = (Page<TbReport>) reportMapper.selectByExample(reportExample);
		return new PageResult(pages.getTotal(), pages.getResult());
	}

	@Override
	public PageResult listByCreateTimeSpan(String startTime, String endTime, Integer pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TbReportExample reportExample = new TbReportExample();
		TbReportExample.Criteria createCriteria = reportExample.createCriteria();
		if (startTime != null && endTime != null && !startTime.equals("") && !endTime.equals(""))
			createCriteria.andCreateTimeBetween(startTime, endTime);
		Page<TbReport> pages = (Page<TbReport>) reportMapper.selectByExample(reportExample);
		return new PageResult(pages.getTotal(), pages.getResult());
	}

	@Override
	public List<TbReport> listAll(TbReport searchReport) {
		TbReportExample reportExample = new TbReportExample();
		TbReportExample.Criteria createCriteria = reportExample.createCriteria();
		if (searchReport != null) {
			if (searchReport.getReportId() != null && !searchReport.getReportId().equals(0)) {
				createCriteria.andReportIdEqualTo(searchReport.getReportId());
			}
			if (searchReport.getCreateTime() != null && searchReport.getCreateTime().split("--").length == 2) {
				createCriteria.andCreateTimeBetween(searchReport.getCreateTime().split("--")[0],
						searchReport.getCreateTime().split("--")[1]);
			}
		}
		return reportMapper.selectByExample(reportExample);
	}

	@Override
	public Result batchSaveAsNegative(HttpServletRequest request, HttpServletResponse response,
			List<TbSpecimen> specimenList, int reporterId, int reviewerId, String hosName, String deptName,
			String createTime) {
		TbReport report = new TbReport();
		report.setReporterId(reporterId);
		report.setReviewerId(reviewerId);

		report.setReporter(managerMapper.selectByPrimaryKey(reporterId));
		report.setReviewer(managerMapper.selectByPrimaryKey(reviewerId));
		// 查询所有的阴性结果
		Map<Integer, TbDictionary> resultMap = new HashMap<Integer, TbDictionary>();
		resultMap.put(6, dictionMapper.selectByPrimaryKey(4));
		resultMap.put(7, dictionMapper.selectByPrimaryKey(10));
		resultMap.put(20, dictionMapper.selectByPrimaryKey(21));
		// 查询所有的检测类型
		Map<Integer, TbDictionary> testTypeMap = new HashMap<Integer, TbDictionary>();
		List<TbDictionary> listByDictName = dictionaryService.listByDictName("test_types");
		for (TbDictionary tbDictionary : listByDictName) {
			testTypeMap.put(tbDictionary.getDictId(), tbDictionary);
		}

		// 查询所有的检测类型
		Map<Integer, TbDictionary> sampleTypeMap = new HashMap<Integer, TbDictionary>();
		List<TbDictionary> vagueListByDictName = dictionaryService.vagueListByDictName("_specimen_type");
		for (TbDictionary tbDictionary : vagueListByDictName) {
			sampleTypeMap.put(tbDictionary.getDictId(), tbDictionary);
		}
		List<String> fileNameList = new ArrayList<String>();
		String newPDFPath = null;
		for (TbSpecimen specimen : specimenList) {
			report.setSpecimen(specimen);
			report.setSpecimenId(specimen.getSpecimenId());
			report.setCreateTime(StringUtil.fixInvalidTime(createTime));
			if (specimen.getTestTypeId() != null) {
				report.getSpecimen().setTestType(testTypeMap.get(specimen.getTestTypeId()));
				report.setSpecimenResult(resultMap.get(specimen.getTestTypeId()));
				report.setSpecimenResultId(
						report.getSpecimenResult() == null ? 0 : report.getSpecimenResult().getDictId());
				report.setReferenceValue(resultMap.get(specimen.getTestTypeId()));
				report.setReferenceValueId(
						report.getReferenceValue() == null ? 0 : report.getReferenceValue().getDictId());
			}
			if (specimen.getSpecimenTypeId() != null) {
				report.getSpecimen().setSpecimenType(sampleTypeMap.get(specimen.getSpecimenTypeId()));
			}
			Map<String, Object> reportPara = wrapReportPara(report);
			///// C008623-李淑哲-抗体检测.pdf
			newPDFPath = specimen.getSpecimenCode() + "-" + specimen.getPatientName() + "-"
					+ specimen.getTestType().getDictValue() + ".pdf";
			specimen.setSpecimenStatusId(1);
			if (PDFUtil.generateReport(reportPara, specimen.getTestTypeId(), newPDFPath)
					&& reportMapper.insert(report) > 0 && specimenService.update(specimen).isSuccess()) {
				fileNameList.add(newPDFPath);
			}
		}
		String zipFileName = hosName + "-";
		if (deptName != null)
			zipFileName += deptName + "-";
		/// 大显身手用Java8的流
		Map<Integer, Long> collect = specimenList.stream()
				.collect(Collectors.groupingBy(TbSpecimen::getTestTypeId, Collectors.counting()));
		/// 查询指定id的
		for (Map.Entry<Integer, Long> entry : collect.entrySet()) {
			TbDictionary dictionary = dictionMapper.selectByPrimaryKey(entry.getKey());
			zipFileName += dictionary.getDictValue() + "-" + entry.getValue() + "-";
		}
		zipFileName = zipFileName.substring(0, zipFileName.length() - 1);
		try {
			zipFileName += ".zip";
			FileUtil.generateZip(fileNameList, zipFileName);
			FileUtil.downFile(request, response, zipFileName);
			FileUtil.deleteDir(zipFileName);
			for (String string : fileNameList) {
				FileUtil.deleteDir(string);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "压缩包生成失败，出现未知错误");
		}
		return new Result(true, "成功导入" + fileNameList.size() + "条数据");
	}

	@Override
	public Map<String, Object> wrapReportPara(TbReport saveReport) {
		Map<String, Object> reportPara = new HashMap<String, Object>();
		List<String> pictureTag = new ArrayList<>();
		Map<String, String> textMap = new HashMap<>();
		// 需要填充的数据，key为模板中的变量
		textMap.put("specimen_code", saveReport.getSpecimen().getSpecimenCode());
		textMap.put("hos_name", saveReport.getSpecimen().getHospital() == null ? ""
				: saveReport.getSpecimen().getHospital().getHosName());
		textMap.put("patient_name", saveReport.getSpecimen().getPatientName());
		textMap.put("dept_name", saveReport.getSpecimen().getDepartment() == null ? ""
				: saveReport.getSpecimen().getDepartment().getDeptName());
		textMap.put("specimen_type", saveReport.getSpecimen().getSpecimenType() == null ? ""
				: saveReport.getSpecimen().getSpecimenType().getDictMark());
		textMap.put("patient_gender", saveReport.getSpecimen().getPatientGender());
		textMap.put("door_num", saveReport.getSpecimen().getDoorNum());
		textMap.put("specimen_situation", saveReport.getSpecimen().getSpecimenSituation() == null ? ""
				: saveReport.getSpecimen().getSpecimenSituation().getDictValue());
		textMap.put("patient_age", saveReport.getSpecimen().getPatientAge() == null ? ""
				: saveReport.getSpecimen().getPatientAge().toString());
		textMap.put("bed_num", saveReport.getSpecimen().getBedNum());
		textMap.put("create_time", StringUtil.fixInvalidTime(saveReport.getSpecimen().getCreateTime()));
		textMap.put("patient_tellphone", saveReport.getSpecimen().getPatientTellphone());
		textMap.put("doc_name",
				saveReport.getSpecimen().getDoctor() == null ? "" : saveReport.getSpecimen().getDoctor().getDocName());
		textMap.put("patient_type", saveReport.getSpecimen().getPatientType() == null ? ""
				: saveReport.getSpecimen().getPatientType().getDictValue());
		textMap.put("recv_time", StringUtil.fixInvalidTime(saveReport.getSpecimen().getRecvTime()));
		textMap.put("report_createtime", StringUtil.fixInvalidTime(saveReport.getCreateTime()));

		Map<String, String> imgMap = new HashMap();
		if (new File(saveReport.getReviewer().getAutograph()).exists()) {
			imgMap.put("reviewer", saveReport.getReviewer().getAutograph());
		}
		if (new File(saveReport.getReporter().getAutograph()).exists()) {
			imgMap.put("reporter", saveReport.getReporter().getAutograph());
		}
		/// 这里是有区别的

		if ("ncov".equals(saveReport.getSpecimen().getTestType().getDictMark())) {
			textMap.put("reference_value", saveReport.getReferenceValue().getDictMark());
			textMap.put("specimen_result", saveReport.getSpecimenResult().getDictMark());
		} else if ("antibody".equals(saveReport.getSpecimen().getTestType().getDictMark())) {
			if (saveReport.getReferenceValue() != null && saveReport.getReferenceValue().getDictMark() != null) {
				String[] referenceValues = saveReport.getReferenceValue().getDictMark().split(",");
				if (referenceValues.length == 2) {
					textMap.put("lgm_refvalue", referenceValues[0]);
					textMap.put("lgg_refvalue", referenceValues[1]);
				}
			}
			if (saveReport.getSpecimenResult() != null && saveReport.getSpecimenResult().getDictMark() != null) {
				String[] specimenResults = saveReport.getSpecimenResult().getDictMark().split(",");
				if (specimenResults.length == 2) {
					textMap.put("lgm_result", specimenResults[0]);
					textMap.put("lgg_result", specimenResults[1]);
				}
			}
		} else if ("ncov&antibody".equals(saveReport.getSpecimen().getTestType().getDictMark())) {
			if (saveReport.getReferenceValue() != null && saveReport.getReferenceValue().getDictMark() != null) {
				String[] referenceValues = saveReport.getReferenceValue().getDictMark().split(",");
				if (referenceValues.length == 3) {
					textMap.put("reference_value", referenceValues[0]);
					textMap.put("lgm_refvalue", referenceValues[1]);
					textMap.put("lgg_refvalue", referenceValues[2]);
				}
			}
			if (saveReport.getSpecimenResult() != null && saveReport.getSpecimenResult().getDictMark() != null) {
				String[] specimenResults = saveReport.getSpecimenResult().getDictMark().split(",");
				if (specimenResults.length == 3) {
					textMap.put("specimen_result", specimenResults[0]);
					textMap.put("lgm_result", specimenResults[1]);
					textMap.put("lgg_result", specimenResults[2]);
				}
			}
			if (saveReport.getSpecimen().getSpecimenType() != null
					&& saveReport.getSpecimen().getSpecimenType().getDictMark() != null) {
				String[] specimenType = saveReport.getSpecimen().getSpecimenType().getDictMark().split(",");
				if (specimenType.length == 2) {
					textMap.remove("specimen_type");
					textMap.put("specimen_type_ncov", specimenType[0]);
					textMap.put("specimen_type_antibody", specimenType[1]);
				}
			}
		}
		reportPara.put("textmap", textMap);
		reportPara.put("imgmap", imgMap);
		return reportPara;
	}
}
