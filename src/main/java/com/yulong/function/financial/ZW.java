package com.yulong.function.financial;

import java.util.Map;

import com.yulong.datatype.Valuable;
import com.yulong.function.Function;

public class ZW implements Function{

	@Override
	public String getName() {
		return "zw";
	}

	@Override
	public int getDimension() {
		return -1;
	}

	@Override
	public Valuable execute(Object[] args, Map<String, Object> env) {
		return null;
	}
	

}
