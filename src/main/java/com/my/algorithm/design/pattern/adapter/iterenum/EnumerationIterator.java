package com.my.algorithm.design.pattern.adapter.iterenum;

import java.util.*;

public class EnumerationIterator implements Iterator<Object> {
	Enumeration<?> enumeration;
 
	public EnumerationIterator(Enumeration<?> enumeration) {
		this.enumeration = enumeration;
	}
 	@Override
	public boolean hasNext() {
		return enumeration.hasMoreElements();
	}
	@Override
	public Object next() {
		return enumeration.nextElement();
	}
	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
