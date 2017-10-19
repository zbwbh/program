package com.designpattern.decoratorpatter;

public class DecoratorTest {

	/**
	 * 稍微有点乱，不过细看图片上的代码可以明白点
	 * 就是不断的重写父类的方法来扩展角色的功能或者特性
	 * 
	 * @param args
	 *
	 * @author zbw
	 * @since 2017年10月19日
	 */
	public static void main(String[] args) {
		Girl g1 = new AmericanGirl();
		System.out.println(g1.getDescription());
		GoldenHair g2 = new GoldenHair(g1);
		System.out.println(g2.getDescription());
		Tall g3 = new Tall(g2);
		System.out.println(g3.getDescription());
	}
}
