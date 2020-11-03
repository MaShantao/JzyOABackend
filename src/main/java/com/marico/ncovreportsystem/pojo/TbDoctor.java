package com.marico.ncovreportsystem.pojo;

public class TbDoctor {
    private Integer docId;

    private Integer deptId;

    private String docName;

    private String mark;
    
    private TbDepartment department;
    
    public TbDepartment getDepartment() {
		return department;
	}

	public void setDepartment(TbDepartment department) {
		this.department = department;
	}

	public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName == null ? null : docName.trim();
    }

    public String getMark() {
        return mark;
    }

    @Override
	public String toString() {
		return "TbDoctor [docId=" + docId + ", deptId=" + deptId + ", docName=" + docName + ", mark=" + mark
				+ ", department=" + department + "]";
	}

	public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }
}