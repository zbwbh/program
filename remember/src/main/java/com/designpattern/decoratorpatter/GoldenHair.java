package com.designpattern.decoratorpatter;

public class GoldenHair extends GirlDecorator{

	private Girl girl;
	
	public GoldenHair(Girl g) {
		girl = g;
	}
	@Override
	public String getDescription() {
		return girl.getDescription() + "+goldenHair";
	}
}
