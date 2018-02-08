package com.iot.spring.vo;

public class ColumnVO {
	private String columnName;
	private String columnDefault;
	private String isNullAble;
	private String dataType;
	private int characterMaximumLength;
	private String columnType;
	private String columnKey;
	private String columnComment;
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getColumnDefault() {
		return columnDefault;
	}
	public void setColumnDefault(String columnDefault) {
		this.columnDefault = columnDefault;
	}
	public String getIsNullAble() {
		return isNullAble;
	}
	public void setIsNullAble(String isNullAble) {
		this.isNullAble = isNullAble;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	public int getCharacterMaximumLength() {
		return characterMaximumLength;
	}
	public void setCharacterMaximumLength(int characterMaximumLength) {
		this.characterMaximumLength = characterMaximumLength;
	}
	public String getColumnType() {
		return columnType;
	}
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	public String getColumnKey() {
		return columnKey;
	}
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}
	public String getColumnComment() {
		return columnComment;
	}
	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}
	@Override
	public String toString() {
		return "ColumnVO [columnName=" + columnName + ", columnDefault=" + columnDefault + ", isNullAble=" + isNullAble
				+ ", dataType=" + dataType + ", characterMaximumLength=" + characterMaximumLength + ", columnType="
				+ columnType + ", columnKey=" + columnKey + ", columnComment=" + columnComment + "]";
	}
	
	
	
}
