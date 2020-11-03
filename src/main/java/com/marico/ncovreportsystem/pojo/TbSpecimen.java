package com.marico.ncovreportsystem.pojo;

public class TbSpecimen {
    private Integer specimenId;

    private String specimenCode;

    private String bedNum;

    private Integer hosId;
    
    private TbHospital hospital;

    private Integer deptId;

    private TbDepartment department;
    
    private Integer docId;
    
    private TbDoctor doctor;
    
    private String doorNum;

    private String patientName;

    private Integer patientAge;

    private String patientTellphone;

    private String patientGender;

    private Integer specimenTypeId;
    
    private TbDictionary specimenType;
    
    private Integer specimenSituationId;

    private TbDictionary specimenSituation;
    
    private Integer specimenStatusId;

    private TbDictionary specimenStatus;
    
    private String createTime;
    
    private Integer testTypeId;
    
    private TbReport report;
    
    private Integer patientTypeId;
    
    private TbDictionary patientType;
    
    
    public Integer getPatientTypeId() {
		return patientTypeId;
	}

	public void setPatientTypeId(Integer patientTypeId) {
		this.patientTypeId = patientTypeId;
	}

	public TbDictionary getPatientType() {
		return patientType;
	}

	public void setPatientType(TbDictionary patientType) {
		this.patientType = patientType;
	}

	public TbReport getReport() {
		return report;
	}

	public void setReport(TbReport report) {
		this.report = report;
	}

    
    public Integer getTestTypeId() {
		return testTypeId;
	}

	public void setTestTypeId(Integer testTypeId) {
		this.testTypeId = testTypeId;
	}

	public TbDictionary getTestType() {
		return testType;
	}

	public void setTestType(TbDictionary testType) {
		this.testType = testType;
	}

	private TbDictionary testType;

    public TbHospital getHospital() {
		return hospital;
	}

	public void setHospital(TbHospital hospital) {
		this.hospital = hospital;
	}

	public TbDepartment getDepartment() {
		return department;
	}

	public void setDepartment(TbDepartment department) {
		this.department = department;
	}

	public TbDoctor getDoctor() {
		return doctor;
	}

	public void setDoctor(TbDoctor doctor) {
		this.doctor = doctor;
	}

	public TbDictionary getSpecimenType() {
		return specimenType;
	}

	public void setSpecimenType(TbDictionary specimenType) {
		this.specimenType = specimenType;
	}

	public TbDictionary getSpecimenSituation() {
		return specimenSituation;
	}

	public void setSpecimenSituation(TbDictionary specimenSituation) {
		this.specimenSituation = specimenSituation;
	}

	public TbDictionary getSpecimenStatus() {
		return specimenStatus;
	}

	public void setSpecimenStatus(TbDictionary specimenStatus) {
		this.specimenStatus = specimenStatus;
	}

	private String recvTime;

    public Integer getSpecimenId() {
        return specimenId;
    }

    public void setSpecimenId(Integer specimenId) {
        this.specimenId = specimenId;
    }

    public String getSpecimenCode() {
        return specimenCode;
    }

    public void setSpecimenCode(String specimenCode) {
        this.specimenCode = specimenCode == null ? null : specimenCode.trim();
    }

    public String getBedNum() {
        return bedNum;
    }

    public void setBedNum(String bedNum) {
        this.bedNum = bedNum == null ? null : bedNum.trim();
    }

    public Integer getHosId() {
        return hosId;
    }

    public void setHosId(Integer hosId) {
        this.hosId = hosId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getDocId() {
        return docId;
    }

    public void setDocId(Integer docId) {
        this.docId = docId;
    }

    public String getDoorNum() {
        return doorNum;
    }

    public void setDoorNum(String doorNum) {
        this.doorNum = doorNum == null ? null : doorNum.trim();
    }

    public String getPatientName() {
        return patientName;
    }

    @Override
	public String toString() {
		return "TbSpecimen [specimenId=" + specimenId + ", specimenCode=" + specimenCode + ", bedNum=" + bedNum
				+ ", hosId=" + hosId + ", hospital=" + hospital + ", deptId=" + deptId + ", department=" + department
				+ ", docId=" + docId + ", doctor=" + doctor + ", doorNum=" + doorNum + ", patientName=" + patientName
				+ ", patientAge=" + patientAge + ", patientTellphone=" + patientTellphone + ", patientGender="
				+ patientGender + ", specimenTypeId=" + specimenTypeId + ", specimenType=" + specimenType
				+ ", specimenSituationId=" + specimenSituationId + ", specimenSituation=" + specimenSituation
				+ ", specimenStatusId=" + specimenStatusId + ", specimenStatus=" + specimenStatus + ", createTime="
				+ createTime + ", testTypeId=" + testTypeId + ", report=" + report + ", testType=" + testType
				+ ", recvTime=" + recvTime + "]";
	}

	public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientTellphone() {
        return patientTellphone;
    }

    public void setPatientTellphone(String patientTellphone) {
        this.patientTellphone = patientTellphone == null ? null : patientTellphone.trim();
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender == null ? null : patientGender.trim();
    }

    public Integer getSpecimenTypeId() {
        return specimenTypeId;
    }

    public void setSpecimenTypeId(Integer specimenTypeId) {
        this.specimenTypeId = specimenTypeId;
    }

    public Integer getSpecimenSituationId() {
        return specimenSituationId;
    }

    public void setSpecimenSituationId(Integer specimenSituationId) {
        this.specimenSituationId = specimenSituationId;
    }

    public Integer getSpecimenStatusId() {
        return specimenStatusId;
    }

    public void setSpecimenStatusId(Integer specimenStatusId) {
        this.specimenStatusId = specimenStatusId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getRecvTime() {
        return recvTime;
    }

    public void setRecvTime(String recvTime) {
        this.recvTime = recvTime == null ? null : recvTime.trim();
    }
}