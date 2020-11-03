package com.marico.ncovreportsystem.pojo;

import java.util.List;

public class TbRole {
    private Integer roleId;

    private String roleName;

    private String roleIntro;

    private Integer roleStatus;
    
    private List<TbRight> rightList;
    
    
    @Override
	public String toString() {
		return "TbRole [roleId=" + roleId + ", roleName=" + roleName + ", roleIntro=" + roleIntro + ", roleStatus="
				+ roleStatus + ", rightList=" + rightList + "]";
	}

	public List<TbRight> getRightList() {
		return rightList;
	}

	public void setRightList(List<TbRight> rightList) {
		this.rightList = rightList;
	}

	public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleIntro() {
        return roleIntro;
    }

    public void setRoleIntro(String roleIntro) {
        this.roleIntro = roleIntro == null ? null : roleIntro.trim();
    }

    public Integer getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }
}