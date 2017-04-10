package com.hlql.example.domain;

import org.junit.Test;

import com.hlql.util.HibernateUtil;

public class AppTest {

	@Test
	public void test() {
		HibernateUtil.getSession();
	}

}
