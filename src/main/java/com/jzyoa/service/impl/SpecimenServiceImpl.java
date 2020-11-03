package com.jzyoa.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzyoa.entity.PageResult;
import com.jzyoa.entity.Result;
import com.jzyoa.mapper.TbReportMapper;
import com.jzyoa.mapper.TbSpecimenMapper;
import com.jzyoa.pojo.TbDepartment;
import com.jzyoa.pojo.TbDictionary;
import com.jzyoa.pojo.TbDoctor;
import com.jzyoa.pojo.TbHospital;
import com.jzyoa.pojo.TbReport;
import com.jzyoa.pojo.TbSpecimen;
import com.jzyoa.pojo.TbSpecimenExample;
import com.jzyoa.service.DepartmentService;
import com.jzyoa.service.DictionaryService;
import com.jzyoa.service.DoctorService;
import com.jzyoa.service.HospitalService;
import com.jzyoa.service.SpecimenService;
import com.jzyoa.util.ExcelUtil;
import com.jzyoa.util.FileUtil;
import com.jzyoa.util.NumberUtil;

@Service
public class SpecimenServiceImpl implements SpecimenService {

	@Autowired
	TbSpecimenMapper specimenMapper;

	@Autowired
	TbReportMapper reportMapper;

	@Autowired
	HospitalService hospitalService;

	@Autowired
	DepartmentService departmentService;

	@Autowired
	DictionaryService dictionaryService;

	@Autowired
	DoctorService doctorService;

	@Override
	public Result save(TbSpecimen addSpecimen) {
//		if(addSpecimen!=null&&addSpecimen.getSpecimenCode()!=null) {
//			 TbSpecimenExample specimenExample = new TbSpecimenExample();
//		     TbSpecimenExample.Criteria createCriteria = specimenExample.createCriteria();
//		     createCriteria.andSpecimenCodeEqualTo(addSpecimen.getSpecimenCode());
//			List<TbSpecimen> selectByExample = specimenMapper.selectByExample(specimenExample);
//			if(selectByExample!=null||selectByExample.size()>0) return new Result(false, "该标本码已经存在，不允许重复");
//		}
		return specimenMapper.insert(addSpecimen) > 0 ? new Result(true, "标本添加成功") : new Result(false, "标本添加失败");
	}

	private void wrapCriteria(TbSpecimenExample.Criteria createCriteria, TbSpecimen searchSpecimen) {
		if (searchSpecimen != null) {
			if (searchSpecimen.getSpecimenId() != null && !searchSpecimen.getSpecimenId().equals(0)) {
				createCriteria.andSpecimenIdEqualTo(searchSpecimen.getSpecimenId());
			}
			if (searchSpecimen.getSpecimenCode() != null && !searchSpecimen.getSpecimenCode().equals("")) {
				createCriteria.andSpecimenCodeLike("%" + searchSpecimen.getSpecimenCode() + "%");
			}
			if (searchSpecimen.getPatientName() != null && !searchSpecimen.getPatientName().equals("")) {
				createCriteria.andPatientNameLike("%" + searchSpecimen.getPatientName() + "%");
			}
			if (searchSpecimen.getHosId() != null && searchSpecimen.getHosId() != 0) {
				createCriteria.andHosIdEqualTo(searchSpecimen.getHosId());
			}
			if (searchSpecimen.getDeptId() != null && searchSpecimen.getDeptId() != 0) {
				createCriteria.andDeptIdEqualTo(searchSpecimen.getDeptId());
			}
			if (searchSpecimen.getTestTypeId() != null && searchSpecimen.getTestTypeId() != 0) {
				createCriteria.andTestTypeIdEqualTo(searchSpecimen.getTestTypeId());
			}
			if (searchSpecimen.getSpecimenStatusId() != null) {
				createCriteria.andSpecimenStatusIdEqualTo(searchSpecimen.getSpecimenStatusId());
			}
			if (searchSpecimen.getSpecimenSituationId() != null && searchSpecimen.getSpecimenSituationId() != 0) {
				createCriteria.andSpecimenSituationIdEqualTo(searchSpecimen.getSpecimenSituationId());
			}
			if (searchSpecimen.getSpecimenTypeId() != null && searchSpecimen.getSpecimenTypeId() != 0) {
				createCriteria.andSpecimenTypeIdEqualTo(searchSpecimen.getSpecimenTypeId());
			}
			// 关于时间段查询
			/// 查询样本生成的时间段
			if (searchSpecimen.getCreateTime() != null && !"".equals(searchSpecimen.getCreateTime())
					&& searchSpecimen.getCreateTime().split("--").length == 2) {
				String startTime = searchSpecimen.getCreateTime().split("--")[0];
				String endTime = searchSpecimen.getCreateTime().split("--")[1];
				if (startTime.equals(endTime)) {
					createCriteria.andCreateTimeEqualTo(startTime);
				} else {
					createCriteria.andCreateTimeBetween(startTime, endTime);
				}
			}
			/// 查询样本接收的时间段
			if (searchSpecimen.getRecvTime() != null && !"".equals(searchSpecimen.getRecvTime())
					&& searchSpecimen.getRecvTime().split("--").length == 2) {
				String startTime = searchSpecimen.getRecvTime().split("--")[0];
				String endTime = searchSpecimen.getRecvTime().split("--")[1];
				if (startTime.equals(endTime)) {
					createCriteria.andRecvTimeEqualTo(startTime);
				} else {
					createCriteria.andRecvTimeBetween(startTime, endTime);
				}
			}
			/// 查询报告接受的时间段
			if (searchSpecimen.getSpecimenStatusId() != null && searchSpecimen.getSpecimenStatusId() == 1
					&& searchSpecimen.getReport().getCreateTime() != null
					&& !searchSpecimen.getReport().getCreateTime().equals("")
					&& searchSpecimen.getReport().getCreateTime().split("--").length == 2) {
				String startTime = searchSpecimen.getReport().getCreateTime().split("--")[0];
				String endTime = searchSpecimen.getReport().getCreateTime().split("--")[1];
				if (startTime.equals(endTime)) {
					createCriteria.andReportCreateTimeEqualTo(startTime);
				} else {
					createCriteria.andReportCreateTimeBetween(startTime, endTime);
				}
			}
			/// 查询病人类型
			if (searchSpecimen.getPatientTypeId() != null && searchSpecimen.getPatientTypeId() != 0) {
				createCriteria.andPatientTypeIdEqualTo(searchSpecimen.getPatientTypeId());
			}
		}
	}

	@Override
	public PageResult list(TbSpecimen searchSpecimen, Integer pageNum, Integer pageSize, Integer sortRule) {
		PageHelper.startPage(pageNum, pageSize);
		TbSpecimenExample specimenExample = new TbSpecimenExample();
		TbSpecimenExample.Criteria createCriteria = specimenExample.createCriteria();
		wrapCriteria(createCriteria, searchSpecimen);
		if (sortRule != null) {
			if (sortRule.equals(1))
				specimenExample.setOrderByClause("door_num");
			if (sortRule.equals(2))
				specimenExample.setOrderByClause("recv_time");
			if (sortRule.equals(3))
				specimenExample.setOrderByClause("create_time");
			if (sortRule.equals(4))
				specimenExample.setOrderByClause("specimen_code");
			if (sortRule.equals(5))
				specimenExample.setOrderByClause("test_type_id");
			if (sortRule.equals(6))
				specimenExample.setOrderByClause("hos_id");
		}
		createCriteria.andSpecimenStatusIdBetween(0, 1);
		Page<TbSpecimen> pages = (Page<TbSpecimen>) specimenMapper.selectDetailsByExample(specimenExample);
		return new PageResult(pages.getTotal(), pages.getResult());
	}

	@Override
	public TbSpecimen getById(Integer specimenId) {
		return specimenMapper.selectByPrimaryKey(specimenId);
	}

	@Override
	public Result update(TbSpecimen searchSpecimen) {
		return specimenMapper.updateByPrimaryKey(searchSpecimen) > 0 ? new Result(true, "更新成功")
				: new Result(false, "更新失败");
	}

	@Override
	public Result delete(Integer specimenId) {
		TbSpecimen specimen = getById(specimenId);
		if (specimen == null)
			return new Result(false, "删除失败,该样本不存在");
		specimen.setSpecimenStatusId(2);
		return specimenMapper.updateByPrimaryKey(specimen) > 0 ? new Result(true, "删除成功") : new Result(false, "删除失败");
	}

	@Override
	public List<TbSpecimen> listAll(TbSpecimen searchSpecimen) {
		TbSpecimenExample specimenExample = new TbSpecimenExample();
		TbSpecimenExample.Criteria createCriteria = specimenExample.createCriteria();
		wrapCriteria(createCriteria, searchSpecimen);
		return specimenMapper.selectDetailsByExample(specimenExample);
	}

	@Override
	public Result uploadFromCsvFile(String fileSaveRoute) {
		try {
			// 1.读取表格对象
			Workbook excel = ExcelUtil.getExcel(fileSaveRoute);
			// 2.操作表格，封装成对象，默认只处理第一个Sheet
			Sheet sheet = excel.getSheetAt(0);
			int rowNum = sheet.getLastRowNum();
			/// 2.1 拿到所有列名的索引
			List<String> colIndex = new ArrayList<String>();
			Row row = sheet.getRow(0);
			int colNum = row.getLastCellNum();
			for (int j = 0; j < row.getLastCellNum(); j++) {
				Cell cell = row.getCell(j);
				if (cell == null)
					return new Result(false, "文件格式错误，发现未知列");
				colIndex.add(cell.toString());
			}
			/// 2.2遍历所有行，封装对象
			List<TbSpecimen> specimenList = new ArrayList<TbSpecimen>();
			for (int i = 1; i <= rowNum; i++) {
				row = sheet.getRow(i);// 获得行
				if (row == null)
					continue;
				colNum = colIndex.size();// row.getLastCellNum();//获得当前行的列数
				TbSpecimen specimen = new TbSpecimen();
				int nullCount = 0;
				String cellValue;
				String colIndexValue;
				for (int j = 0; j < colNum; j++) {
					Cell cell = row.getCell(j);// 获取单元格
					if (cell == null) {
						nullCount++;
						cellValue = "";
					} else
						cellValue = cell.toString();
					// 2.2.1封装对象
					colIndexValue = colIndex.get(j);
					if ("送检单位".equals(colIndexValue)) {
						TbHospital hospital = new TbHospital();
						hospital.setHosName(cellValue);
						specimen.setHospital(hospital);
					} else if ("标本条码".equals(colIndexValue)) {
						specimen.setSpecimenCode(cellValue);
					} else if ("姓名".equals(colIndexValue)) {
						specimen.setPatientName(cellValue);
					} else if ("性别".equals(colIndexValue)) {
						specimen.setPatientGender(cellValue);
					} else if ("年龄".equals(colIndexValue) && NumberUtil.isNumeric(cellValue)) {
						specimen.setPatientAge((int) Double.parseDouble(cellValue));
					} else if ("电话".equals(colIndexValue)) {
						specimen.setPatientTellphone(cellValue);
					} else if ("报告类型".equals(colIndexValue)) {
						TbDictionary testType = new TbDictionary();
						testType.setDictName("test_types");
						testType.setDictValue(cellValue);
						specimen.setTestType(testType);
					} else if ("标本类型".equals(colIndexValue)) {
						TbDictionary specimenType = new TbDictionary();
						specimenType.setDictName("_specimen_type");
						specimenType.setDictValue(cellValue);
						specimen.setSpecimenType(specimenType);
					} else if ("采样时间".equals(colIndexValue)) {
						specimen.setCreateTime(cellValue);
					} else if ("接收时间".equals(colIndexValue)) {
						specimen.setRecvTime(cellValue);
					} else if ("标本状态".equals(colIndexValue)) {
						TbDictionary specimenSituation = new TbDictionary();
						specimenSituation.setDictName("specimen_situation");
						specimenSituation.setDictValue(cellValue);
						specimen.setSpecimenSituation(specimenSituation);
					} else if ("送检科室".equals(colIndexValue)) {
						TbDepartment department = new TbDepartment();
						department.setDeptName(cellValue);
						specimen.setDepartment(department);
					} else if ("送检医生".equals(colIndexValue)) {
						TbDoctor doctor = new TbDoctor();
						doctor.setDocName(cellValue);
						specimen.setDoctor(doctor);
					} else if ("门诊号".equals(colIndexValue)) {
						specimen.setDoorNum(cellValue);
					} else if ("床位号".equals(colIndexValue)) {
						specimen.setBedNum(cellValue);
					} else if ("人员类型".equals(colIndexValue)) {
						TbDictionary patientType = new TbDictionary();
						patientType.setDictName("patient_type");
						patientType.setDictValue(cellValue);
						specimen.setPatientType(patientType);
					}
				}
				if (nullCount < colNum)
					specimenList.add(specimen);
			}

			// 3.详细封装SpecimenList
			int successCount = 0;
			for (TbSpecimen tbSpecimen : specimenList) {
				// 3.1 查找医院id
				tbSpecimen.setHospital(hospitalService.getByName(tbSpecimen.getHospital().getHosName()));
				if (tbSpecimen.getHospital() != null) {
					tbSpecimen.setHosId(tbSpecimen.getHospital().getHosId());
					// 3.2查找科室的id
					tbSpecimen.getDepartment().setHosId(tbSpecimen.getHosId());
					tbSpecimen.setDepartment(departmentService.getBySearchEntity(tbSpecimen.getDepartment()));
					if (tbSpecimen.getDepartment() != null) {
						tbSpecimen.setDeptId(tbSpecimen.getDepartment().getDeptId());
						// 3.3查找送检医生
						tbSpecimen.getDoctor().setDeptId(tbSpecimen.getDeptId());
						tbSpecimen.setDoctor(doctorService.getBySearchEntity(tbSpecimen.getDoctor()));
						if (tbSpecimen.getDoctor() != null) {
							tbSpecimen.setDocId(tbSpecimen.getDoctor().getDocId());
						}
					}
				}
				// 3.4 查找报告类型，也就是检测类型
				tbSpecimen.setTestType(dictionaryService.getBySearchEntity(tbSpecimen.getTestType()));
				if (tbSpecimen.getTestType() != null) {
					tbSpecimen.setTestTypeId(tbSpecimen.getTestType().getDictId());
					// 3.5 查找标本类型
					tbSpecimen.getSpecimenType()
							.setDictName(tbSpecimen.getTestTypeId() + tbSpecimen.getSpecimenType().getDictName());
					tbSpecimen.setSpecimenType(dictionaryService.getBySearchEntity(tbSpecimen.getSpecimenType()));
					if (tbSpecimen.getSpecimenType() != null) {
						tbSpecimen.setSpecimenTypeId(tbSpecimen.getSpecimenType().getDictId());
					}
				}
				// 3.5 查找人员类型
				tbSpecimen.setPatientType(dictionaryService.getBySearchEntity(tbSpecimen.getPatientType()));
				if (tbSpecimen.getPatientType() != null) {
					tbSpecimen.setPatientTypeId(tbSpecimen.getPatientType().getDictId());
				}
				// 3.6查找标本情况
				tbSpecimen.setSpecimenSituation(dictionaryService.getBySearchEntity(tbSpecimen.getSpecimenSituation()));
				if (tbSpecimen.getSpecimenSituation() != null) {
					tbSpecimen.setSpecimenSituationId(tbSpecimen.getSpecimenSituation().getDictId());
				}
				tbSpecimen.setSpecimenStatusId(0);
				if (save(tbSpecimen).isSuccess())
					successCount++;
			}
			// 3.删除文件
			FileUtil.deleteDir(fileSaveRoute);
			return new Result(true, "成功录入" + successCount + "条数据");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "发生未知错误");
		} finally {
			FileUtil.deleteDir(fileSaveRoute);
		}
	}

	@Override
	public int countBySearchEntity(List<TbReport> reportList, TbSpecimen searchSpecimen) {
		int total = 0;
		if (reportList == null || reportList.size() == 0 || searchSpecimen == null)
			return 0;
		for (TbReport report : reportList) {
			TbSpecimenExample specimenExample = new TbSpecimenExample();
			TbSpecimenExample.Criteria createCriteria = specimenExample.createCriteria();
			searchSpecimen.setSpecimenId(report.getSpecimenId());
			if (searchSpecimen.getSpecimenId() != null && !searchSpecimen.getSpecimenId().equals(0)) {
				createCriteria.andSpecimenIdEqualTo(searchSpecimen.getSpecimenId());
			}
			if (searchSpecimen.getSpecimenCode() != null && !searchSpecimen.getSpecimenCode().equals("")) {
				createCriteria.andSpecimenCodeLike("%" + searchSpecimen.getSpecimenCode() + "%");
			}
			if (searchSpecimen.getPatientName() != null && !searchSpecimen.getPatientName().equals("")) {
				createCriteria.andPatientNameLike("%" + searchSpecimen.getPatientName() + "%");
			}
			if (searchSpecimen.getHosId() != null && searchSpecimen.getHosId() != 0) {
				createCriteria.andHosIdEqualTo(searchSpecimen.getHosId());
			}
			if (searchSpecimen.getDeptId() != null && searchSpecimen.getDeptId() != 0) {
				createCriteria.andDeptIdEqualTo(searchSpecimen.getDeptId());
			}
			if (searchSpecimen.getTestTypeId() != null && searchSpecimen.getTestTypeId() != 0) {
				createCriteria.andTestTypeIdEqualTo(searchSpecimen.getTestTypeId());
			}
			if (searchSpecimen.getSpecimenStatusId() != null) {
				createCriteria.andSpecimenStatusIdEqualTo(searchSpecimen.getSpecimenStatusId());
			}
			if (searchSpecimen.getSpecimenSituationId() != null && searchSpecimen.getSpecimenSituationId() != 0) {
				createCriteria.andSpecimenSituationIdEqualTo(searchSpecimen.getSpecimenSituationId());
			}
			if (searchSpecimen.getSpecimenTypeId() != null && searchSpecimen.getSpecimenTypeId() != 0) {
				createCriteria.andSpecimenTypeIdEqualTo(searchSpecimen.getSpecimenTypeId());
			}
			// 关于时间段查询
			/// 查询样本生成的时间段
			if (searchSpecimen.getCreateTime() != null && !"".equals(searchSpecimen.getCreateTime())
					&& searchSpecimen.getCreateTime().split("--").length == 2) {
				createCriteria.andCreateTimeBetween(searchSpecimen.getCreateTime().split("--")[0],
						searchSpecimen.getCreateTime().split("--")[1]);
			}
			/// 查询样本接收的时间段
			if (searchSpecimen.getRecvTime() != null && !"".equals(searchSpecimen.getRecvTime())
					&& searchSpecimen.getRecvTime().split("--").length == 2) {
				createCriteria.andRecvTimeBetween(searchSpecimen.getRecvTime().split("--")[0],
						searchSpecimen.getRecvTime().split("--")[1]);
			}
			total += specimenMapper.countByExample(specimenExample);
		}
		return total;
	}

	@Override
	public PageResult testList(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
//		List<TbReport> selectByExampleWithAllMessage = reportMapper.selectByExampleWithAllMessage(null);
//		System.out.println(selectByExampleWithAllMessage);
//		for (TbReport tbReport : selectByExampleWithAllMessage) {
//			System.out.println(tbReport);
//		}
		List<TbSpecimen> selectDetailsByExample = specimenMapper.selectDetailsByExample(null);
		for (TbSpecimen specimen : selectDetailsByExample) {
			System.out.println(specimen);
		}
		return null;
	}

}
