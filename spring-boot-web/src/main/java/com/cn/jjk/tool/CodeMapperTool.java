package com.cn.jjk.tool;

/**
 * 反射工具
 * @author jnjikui
 *
 */
public abstract class CodeMapperTool {
	
	/**
	 * 无参方法
	 * @param clazz 将要调用的类
	 * @param code 方法对应的代码
	 * @return
	 */
	abstract Object getResult(Class clazz,String code);
	
	/**
	 * 有参方法
	 * @param clazz 类
	 * @param str 方法和参数
	 * @return
	 */
	abstract Object getResult(Class[] clazzs,Object[] str);
}
