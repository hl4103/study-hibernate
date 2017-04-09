package com.hlql.enum01;

import org.hibernate.Session;
import org.junit.Test;

import com.hlql.util.HibernateUtil;

public class App {

	@Test
	public void testGet() {
		Session session = HibernateUtil.getSession();
		session.close();
	}

}
