package com.designpattern.adapterpattern;

/**
 * 适配器模式的应用
 * 当你想使用一个已有的类，但是这个类的接口跟你的又不一样，不能拿来直接用，
 * 这个时候你就需要一个适配器来帮你了，其主要作用就是在旧的接口、
 * 新的接口之间完成适配
 * 适配器模式的三个特点：
 * 1、适配器对象实现原有接口
 * 2、适配器对象组合一个实现新接口的对象（这个对象也可以不实现一个接口，只是一个单纯的对象）
 * 3、对适配器原有接口方法的调用被委托给新接口的实例的特定方法（就是替换或是附加给原接口一个新的方法）
 * 
 *
 * @author zbw
 * @since 2017年10月19日
 */
public class AdapterTest {

	public static void main(String[] args) {
		EnPluginInterface enPlugin = new EnPlugin();
		//将英标的充电方法放入适配器当中
		PluginAdapter adapter = new PluginAdapter(enPlugin);
		Home home = new Home();
		home.setPlugin(adapter);//将适配器加入到国标的充电方法里实现转换
		home.charge();
	}
}
