package com.jzyoa.pojo;


public class TbReport implements Cloneable {
    private Integer reportId;
    
    private Integer specimenId;
    private TbSpecimen specimen;
    private Integer reporterId;
    
    private TbManager reporter;

    private Integer reviewerId;

    private TbManager reviewer;
    
    private String createTime;

    public TbSpecimen getSpecimen() {
		return specimen;
	}

	public void setSpecimen(TbSpecimen specimen) {
		this.specimen = specimen;
	}

	public TbManager getReporter() {
		return reporter;
	}

	public void setReporter(TbManager reporter) {
		this.reporter = reporter;
	}

	public TbManager getReviewer() {
		return reviewer;
	}

	public void setReviewer(TbManager reviewer) {
		this.reviewer = reviewer;
	}

	public TbDictionary getSpecimenResult() {
		return specimenResult;
	}

	public void setSpecimenResult(TbDictionary specimenResult) {
		this.specimenResult = specimenResult;
	}

	public TbDictionary getReferenceValue() {
		return referenceValue;
	}

	public void setReferenceValue(TbDictionary referenceValue) {
		this.referenceValue = referenceValue;
	}

	private Integer specimenResultId;
    
    private TbDictionary specimenResult;
    
    private Integer referenceValueId;

    private TbDictionary referenceValue;
    
    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getSpecimenId() {
        return specimenId;
    }

    public void setSpecimenId(Integer specimenId) {
        this.specimenId = specimenId;
    }

    public Integer getReporterId() {
        return reporterId;
    }

    public void setReporterId(Integer reporterId) {
        this.reporterId = reporterId;
    }

    public Integer getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(Integer reviewerId) {
        this.reviewerId = reviewerId;
    }


    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getSpecimenResultId() {
        return specimenResultId;
    }

    public void setSpecimenResultId(Integer specimenResultId) {
        this.specimenResultId = specimenResultId;
    }


	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "TbReport [reportId=" + reportId + ", specimenId=" + specimenId + ", specimen=" + specimen
				+ ", reporterId=" + reporterId + ", reporter=" + reporter + ", reviewerId=" + reviewerId + ", reviewer="
				+ reviewer + ", createTime=" + createTime + ", specimenResultId=" + specimenResultId
				+ ", specimenResult=" + specimenResult + ", referenceValueId=" + referenceValueId + ", referenceValue="
				+ referenceValue + "]";
	}

	public Integer getReferenceValueId() {
        return referenceValueId;
    }

    public void setReferenceValueId(Integer referenceValueId) {
        this.referenceValueId = referenceValueId;
    }
}