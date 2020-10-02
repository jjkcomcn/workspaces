package com.cn.jjk.tool;

/**
 * 操作映射接口
 * 
 * @author jnjikui
 *
 */
public interface CodeMapper {
	/**
	 * 查询Q0101
	 */
	public final String Q0101 = "getQ0101";
	/**
	 * 读取文件生成相应表实体
	 */
	public final String GDB01 = "getDBFromText";

	public abstract Object getQ0101();

	public abstract Object getDBFromText(Class clazz, String fileUrl, String splitstr, String[] names);
}
