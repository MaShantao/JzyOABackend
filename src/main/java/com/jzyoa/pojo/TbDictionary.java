package com.jzyoa.pojo;

public class TbDictionary {
    private Integer dictId;

    private String dictName;

    @Override
	public String toString() {
		return "TbDictionary [dictId=" + dictId + ", dictName=" + dictName + ", dictValue=" + dictValue + ", dictMark="
				+ dictMark + "]";
	}

	private String dictValue;

    private String dictMark;

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue == null ? null : dictValue.trim();
    }

    public String getDictMark() {
        return dictMark;
    }

    public void setDictMark(String dictMark) {
        this.dictMark = dictMark == null ? null : dictMark.trim();
    }
}