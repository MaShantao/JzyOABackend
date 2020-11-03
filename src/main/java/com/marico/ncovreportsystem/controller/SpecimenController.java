package com.marico.ncovreportsystem.controller;

import com.marico.ncovreportsystem.entity.PageResult;
import com.marico.ncovreportsystem.entity.Result;
import com.marico.ncovreportsystem.pojo.TbReport;
import com.marico.ncovreportsystem.pojo.TbSpecimen;
import com.marico.ncovreportsystem.service.DepartmentService;
import com.marico.ncovreportsystem.service.DictionaryService;
import com.marico.ncovreportsystem.service.DoctorService;
import com.marico.ncovreportsystem.service.HospitalService;
import com.marico.ncovreportsystem.service.ReportService;
import com.marico.ncovreportsystem.service.SpecimenService;
import com.marico.ncovreportsystem.util.UUIDUtil;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeType.SpecificityComparator;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/specimen")
public class SpecimenController {

	@Autowired
	private SpecimenService specimenService;

	@Autowired
	private DictionaryService dictionaryService;

	@Autowired
	private HospitalService hospitalService;

	@Autowired
	private DepartmentService departService;

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private ReportController reportController;

	@RequestMapping("/save")
	public Result save(@RequestBody TbSpecimen addSpecimen) {
		addSpecimen.setSpecimenStatusId(0);
		return specimenService.save(addSpecimen);
	}

	@RequestMapping("/list")
	public PageResult list(@RequestBody TbSpecimen searchSpecimen, Integer pageNum, Integer pageSize,Integer sortRule) {
		/// 如果报告时间不为空的话，得先根据报告时间去查报告
		try {
			PageResult pageResult = specimenService.list(searchSpecimen, pageNum, pageSize,sortRule);
			return pageResult;
		} catch (Exception e) {
			e.printStackTrace();
			return new PageResult(0, null);
		}
	}

	@RequestMapping("/listAll")
	public List<TbSpecimen> listAll(@RequestBody TbSpecimen searchSpecimen) {
		return specimenService.listAll(searchSpecimen);
	}
	
	@RequestMapping("/getDetailsById")
	public TbSpecimen getDetailsById(Integer specimenId) {
		TbSpecimen specimen = getById(specimenId);
		specimen.setSpecimenSituation(dictionaryService.getById(specimen.getSpecimenSituationId()));
		specimen.setSpecimenType(dictionaryService.getById(specimen.getSpecimenTypeId()));
		specimen.setHospital(hospitalService.getById(specimen.getHosId()));
		specimen.setDepartment(departService.getById(specimen.getDeptId()));
		specimen.setDoctor(doctorService.getById(specimen.getDocId()));
		specimen.setTestType(dictionaryService.getById(specimen.getTestTypeId()));
		specimen.setPatientType(dictionaryService.getById(specimen.getPatientTypeId()));
		return specimen;
	}

	@RequestMapping("/getById")
	public TbSpecimen getById(Integer specimenId) {
		return specimenService.getById(specimenId);
	}

	@RequestMapping("/update")
	public Result update(@RequestBody TbSpecimen searchSpecimen) {
		return specimenService.update(searchSpecimen);
	}

	@RequestMapping("/delete")
	public Result delete(Integer specimenId) {
		return specimenService.delete(specimenId);
	}

	@RequestMapping("/uploadFromFile")
	public Result uploadFile(@RequestParam("uploadFile") MultipartFile uploadFile) {
		HashMap map = new HashMap();
		if (uploadFile == null || uploadFile.isEmpty()) {
			return new Result(false, "上传错误：文件为空");
		}
		try {
			// 获得上传文件的文件名:
			String fileName = uploadFile.getOriginalFilename();
			// 获得文件的扩展名:
			String extName = fileName.substring(fileName.lastIndexOf(".") + 1);
			// 设置下载文件的文件名
			String projectPath = System.getProperty("user.dir");
			String fileSaveName = UUIDUtil.getId() + "." + extName;
			String fileSaveRoute = projectPath + "/" + fileSaveName;
			System.out.println("上传的文件保存在" + fileSaveRoute);
			// 下载文件
			FileUtils.copyInputStreamToFile(uploadFile.getInputStream(), new File(fileSaveRoute));
			return specimenService.uploadFromCsvFile(fileSaveRoute);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			return new Result(false, "上传错误：上传过程中发生未知错误");
		}
	}
}
