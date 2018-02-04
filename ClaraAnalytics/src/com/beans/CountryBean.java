package com.beans;

public class CountryBean {

	public CountryBean(String value, String label) {
		super();
		
		this.value = value;
		this.label = label;
	}

	private String label;

	private String value;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
