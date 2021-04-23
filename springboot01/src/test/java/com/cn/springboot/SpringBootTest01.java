package com.cn.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cn.springboot.bean.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTest01 {

	@Autowired
	Person person;
	
	@Test
	public void contextLoads(){
		System.out.println(person);
	}
}
