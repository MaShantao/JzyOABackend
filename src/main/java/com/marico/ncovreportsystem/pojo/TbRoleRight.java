package com.marico.ncovreportsystem.pojo;

public class TbRoleRight {
    private Integer roleRightId;

    private Integer roleId;

    private Integer rightId;

    public Integer getRoleRightId() {
        return roleRightId;
    }

    public TbRoleRight() {
		super();
	}

	public TbRoleRight(Integer roleRightId, Integer roleId, Integer rightId) {
		super();
		this.roleRightId = roleRightId;
		this.roleId = roleId;
		this.rightId = rightId;
	}

	public void setRoleRightId(Integer roleRightId) {
        this.roleRightId = roleRightId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRightId() {
        return rightId;
    }

    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }
}