package com.yulong.datatype.impl;

import com.yulong.datatype.AbstractValue;
import com.yulong.datatype.DataType;

public class StringValue extends AbstractValue {

	private String value;

	public StringValue(String value) {
		this.value = value;
	}

	@Override
	public DataType getDataType() {
		return DataType.STRING;
	}

	@Override
	public String getStringValue() {
		return value;
	}

	@Override
	public Object getValue() {
		return value;
	}

}
