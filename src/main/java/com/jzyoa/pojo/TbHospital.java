package com.jzyoa.pojo;

import java.util.List;

public class TbHospital {
    private Integer hosId;

    private String hosName;

    private String hosAddress;
    
    private List<TbDepartment> departmentList;
    

    public List<TbDepartment> getDepartmentList() {
		return departmentList;
	}

	public void setDepartmentList(List<TbDepartment> departmentList) {
		this.departmentList = departmentList;
	}

	public Integer getHosId() {
        return hosId;
    }

    @Override
	public String toString() {
		return "TbHospital [hosId=" + hosId + ", hosName=" + hosName + ", hosAddress=" + hosAddress
				+ ", departmentList=" + departmentList + "]";
	}

	public void setHosId(Integer hosId) {
        this.hosId = hosId;
    }

	public String getHosName() {
        return hosName;
    }

    public void setHosName(String hosName) {
        this.hosName = hosName == null ? null : hosName.trim();
    }

    public String getHosAddress() {
        return hosAddress;
    }

    public void setHosAddress(String hosAddress) {
        this.hosAddress = hosAddress == null ? null : hosAddress.trim();
    }
}