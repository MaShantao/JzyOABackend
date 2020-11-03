package com.jzyoa.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jzyoa.entity.PageResult;
import com.jzyoa.entity.Result;
import com.jzyoa.pojo.TbReport;
import com.jzyoa.pojo.TbSpecimen;

public interface ReportService {
	void downWord(Map<String, Object> data, String templatePath, String saveName, HttpServletRequest request,
			HttpServletResponse response) throws Exception;

	Result save(TbReport saveReport, HttpServletRequest request, HttpServletResponse response);

	TbReport getBySpecimenId(Integer specimenId);

	TbReport getById(Integer reportId);

	Result update(TbReport updateReport, HttpServletRequest request, HttpServletResponse response);

	void createReport(TbReport saveReport, HttpServletRequest request, HttpServletResponse response) throws Exception;

	PageResult listRoughly(TbReport searchReport, int pageNum, Integer pageSize);

	PageResult listByCreateTimeSpan(String startTime, String endTime, Integer pageNum, int pageSize);

	List<TbReport> listAll(TbReport searchReport);

	Result batchSaveAsNegative(HttpServletRequest request, HttpServletResponse response, List<TbSpecimen> specimenList,
			int reporterId, int reviewerId, String hosName, String deptName, String createTime);

	Map<String, Object> wrapReportPara(TbReport saveReport);
}
