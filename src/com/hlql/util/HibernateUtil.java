package com.hlql.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	static {
		//　1. 创建配置对象
		Configuration config = new Configuration();
		// 2. 加载Hibernate的主配置文件
		config.configure("hibernate.cfg.xml");
		// 3. 创建SessionFactory对象：好比于连接池
		sessionFactory = config.buildSessionFactory();
	}

	public static Session getSession() {
		// 获取当前线程中存在的session
		//　return sessionFactory.getCurrentSession();
		// 开启一个新的线程
		return sessionFactory.openSession();
	}
}
