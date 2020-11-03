package com.marico.ncovreportsystem.pojo;

import java.util.List;

public class TbRight {
    private Integer rightId;

    private Integer parentId;

    private String rightName;

    private String path;

    private Integer level;
    
    private List<TbRight> children;
    

    @Override
	public String toString() {
		return "TbRight [rightId=" + rightId + ", parentId=" + parentId + ", rightName=" + rightName + ", path=" + path
				+ ", level=" + level + ", children=" + children + "]";
	}

	public List<TbRight> getChildren() {
		return children;
	}

	public void setChildren(List<TbRight> children) {
		this.children = children;
	}

	public Integer getRightId() {
        return rightId;
    }

    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName == null ? null : rightName.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}