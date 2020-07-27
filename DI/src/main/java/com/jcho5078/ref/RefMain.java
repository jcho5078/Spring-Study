package com.jcho5078.ref;

public class RefMain {
	private RefSub sub;
	
	public RefMain(RefSub sub) {
		this.sub = sub;
		System.out.println(this.sub.str); //확인용.
	}
}
