package com.hlql.example.query;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Test;

import com.hlql.util.HibernateUtil;

public class QueryResultTest {

	@Test
	public void test() {
		Session session = HibernateUtil.getSession();
		String hql = "select e.name from Employee e";
		Query query = session.createQuery(hql);
		List<String> list = query.list();
		session.close();
		for (String name : list) {
			System.out.println(name);
		}
	}

	@Test
	public void test2() throws Exception {
		Session session = HibernateUtil.getSession();
		String hql = "select e.name,e.dept from Employee e";
		Query query = session.createQuery(hql);
		List<Object[]> list = query.list();
		session.close();
		for (Object[] arr : list) {
			System.out.println(Arrays.toString(arr));
		}
	}

	@Test
	public void test3() throws Exception {
		Session session = HibernateUtil.getSession();
		String hql = "select NEW LIST(e.name,e.dept) from Employee e";
		Query query = session.createQuery(hql);
		List<List<Object>> list = query.list();
		for (List<Object> arr : list) {
			System.out.println(arr);
		}
		session.close();
	}

	@Test
	public void test4() throws Exception {
		Session session = HibernateUtil.getSession();
		String hql = "select NEW MAP(e.name,e.dept.name) from Employee e";
		Query query = session.createQuery(hql);
		List<Map> list = query.list();
		for (Map arr : list) {
			System.out.println(arr);
		}
		session.close();
	}

	@Test
	public void test5() throws Exception {
		Session session = HibernateUtil.getSession();
		String hql = "select NEW MAP(e.name as name,e.dept as dept) from Employee e";
		Query query = session.createQuery(hql);
		List<Map<String, Object>> list = query.list();
		for (Map arr : list) {
			System.out.println(arr);
		}
		session.close();
	}
}
