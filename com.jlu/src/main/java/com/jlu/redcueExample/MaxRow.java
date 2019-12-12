package com.jlu.redcueExample;

public class MaxRow {
	
	ElemwntList gl = new ElemwntList();
	
	public void reduce(ElemwntList list) {
		int max = 0;
		int y = 0;
		
		
		for(Element el : list.getList()) {
			int x = (Integer) el.getList().get(1);
			if(max<x) {
				max = x;
				y = (Integer) el.getList().get(2);
			}
		}
		
		doSomething(y);
	}
	
	public void doSomething(int y) {
		
	}

}
