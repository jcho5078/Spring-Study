package com.jcho5078.cast;

public class Binding{
	private Integer temp;
	
	public Binding(int temp) {
		this.temp = temp;
	}
	
	public Integer getValue() {
		return temp;
	}
	
	@Override
	public String toString() {
		return "출력: "+ temp;
	}
}
