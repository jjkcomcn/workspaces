package com.cn.springboot;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;


public class Test01 {

	public static void main(String[] args) {
		BigDecimal a1 = new BigDecimal("0.01");
		BigDecimal a2 = new BigDecimal("0.09");
		BigDecimal multiply = a1.multiply(a2);
		System.out.println(multiply.divide(BigDecimal.ONE,3,BigDecimal.ROUND_HALF_UP));
		System.out.println(a1.add(a2));
	}

//	@Test
	public void test01(){
		String str = "dafasfas";
		System.out.println(str.substring(5));
	}
	@Test
	public void test02(){
		String str = "100123654";
		System.out.println(str.substring(5));
		System.out.println(StringUtils.countMatches(str,"1"));
	}
}
