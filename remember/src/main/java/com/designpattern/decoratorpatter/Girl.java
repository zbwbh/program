package com.designpattern.decoratorpatter;

/**
 * 装饰着模式：就是动态的把职责附加到已有对象上去，实现功能扩展。
 * 这种特性，使得装饰着模式提供了比继承更具有弹性的解决方案
 * 
 *
 * @author zbw
 * @since 2017年10月19日
 */
public abstract class Girl {

	String description = "no particular";
	
	public String getDescription() {
		return description;
	}
}
