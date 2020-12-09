package com.opcbiz.fxprimus.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class ListOfSomething<X> implements ParameterizedType {

	private Class<?> wrapped;

	public ListOfSomething(Class<X> wrapped) {
		this.wrapped = wrapped;
	}

	public Type[] getActualTypeArguments() {
		return new Type[] { wrapped };
	}

	public Type getOwnerType() {
		return null;
	}

	public Type getRawType() {
		return List.class;
	}

}