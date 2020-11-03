package com.marico.ncovreportsystem.pojo;

import java.util.List;

public class TbDepartment {
    @Override
	public String toString() {
		return "TbDepartment [deptId=" + deptId + ", hosId=" + hosId + ", deptName=" + deptName + ", hospital="
				+ hospital + "]";
	}

	private Integer deptId;

    private Integer hosId;

    public List<TbDoctor> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(List<TbDoctor> doctorList) {
		this.doctorList = doctorList;
	}

	private String deptName;
    
    private TbHospital hospital;
    
    private List<TbDoctor> doctorList;

    public TbHospital getHospital() {
		return hospital;
	}

	public void setHospital(TbHospital hospital) {
		this.hospital = hospital;
	}

	public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getHosId() {
        return hosId;
    }

    public void setHosId(Integer hosId) {
        this.hosId = hosId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }
}