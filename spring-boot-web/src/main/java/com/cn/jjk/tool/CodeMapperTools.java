package com.cn.jjk.tool;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 操作映射操作工具
 * 
 * @author jnjikui
 *
 */
public class CodeMapperTools extends CodeMapperTool {

    /**
     * 无参方法
     * 
     * @param clazz 将要调用的类
     * @param code  方法对应的代码
     * @return
     */
    @SuppressWarnings({ "deprecation", "rawtypes" })
    @Override
    public Object getResult(Class clazd, String code) {
        // 获取对象
        Class<? extends CodeMapper> clazz = CodeMapper.class;
        try {
            Field[] fields = clazz.getDeclaredFields();
            Object newInstance = clazd.newInstance();
            for (Field field : fields) {
                if (field.equals(clazz.getDeclaredField(code))) {
                    return clazz.getMethod(clazd.getDeclaredField(code).get(newInstance).toString(), Class.class)
                            .invoke(newInstance, clazd);
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "未定义对应方法！";
    }

    /**
     * 有参方法
     * 
     * @param clazz 类
     * @param str   方法和参数
     * @return
     */
    @SuppressWarnings({ "rawtypes", "deprecation", "unchecked" })
    @Override
    public Object getResult(Class[] clazzs, Object[] str) {
        // 获取方法code
        String code = (String) str[0];
        // 获取对象
        Class clazz = clazzs[0];
        // 获取接口对象
        Class<? extends CodeMapper> claza = CodeMapper.class;
        // 去除方法
        Object[] strd = arrayDelete(0, str);
        // 去除对象
        Class[] clazzd = (Class[]) arrayDelete(0, clazzs);
        try {
            // 创建实体
            Object newInstance = clazz.newInstance();
            // 反射获取接口的所有方法
            Field[] fields = claza.getDeclaredFields();
            // 遍历接口的方法，执行定义的方法
            for (Field field : fields) {
                if (field.equals(claza.getDeclaredField(code))) {
                    return clazz.getMethod(claza.getDeclaredField(code).get(newInstance).toString(), clazzd)
                            .invoke(newInstance, strd);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "未定义对应方法！";
    }

    /**
     * 删除数组中对应下标的元素
     * 
     * @param <T> 数组的类型
     * @param n   要删除元素的下标
     * @param str 原始数组
     * @return 删除后的数组
     */
    public static Object[] arrayDelete(int n, Object[] str) {
        for (int i = n; i < str.length - 1; i++) {
            str[i] = str[i + 1];
        }
        str = Arrays.copyOf(str, str.length - 1);
        return str;
    }
}
