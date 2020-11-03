package com.marico.ncovreportsystem.pojo;

public class TbManager {
    private Integer managerId;

    private String managerName;

    private String autograph;

    @Override
	public String toString() {
		return "TbManager [managerId=" + managerId + ", managerName=" + managerName + ", autograph=" + autograph
				+ ", managerType=" + managerType + "]";
	}

	private Integer managerType;

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph == null ? null : autograph.trim();
    }

    public Integer getManagerType() {
        return managerType;
    }

    public void setManagerType(Integer managerType) {
        this.managerType = managerType;
    }
}