package com.hlql.example.query;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.hlql.example.domain.Employee;
import com.hlql.util.HibernateUtil;

public class QueryTest {

	@Test
	public void test1() {
		Session session = HibernateUtil.getSession();
		String hql = "SELECT e FROM Employee e where e.name LIKE ? AND e.id BETWEEN ? AND ?";
		Query query = session.createQuery(hql);
		query.setString(0, "%a%");
		query.setLong(1, 1L);
		query.setLong(2, 10L);
		List<Employee> list = query.list(); // 执行查询操作
		session.close();

		for (Employee e : list) {
			System.out.println(e.getName());
		}
	}

	@Test
	public void test2() {
		Session session = HibernateUtil.getSession();
		String sql = "SELECT * FROM employee WHERE name like ?";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter(0, "%a%");
		List<Object[]> list = query.list(); // 执行查询操作
		session.close();

		for (Object[] e : list) {
			System.out.println(Arrays.toString(e));
		}
	}

	@Test
	public void test3() {
		Session session = HibernateUtil.getSession();
		Criteria cri = session.createCriteria(Employee.class);
		
		cri.add(Restrictions.like("name", "a", MatchMode.ANYWHERE));
		List<Employee> list = cri.list();
		
		session.close();
		for (Employee e : list) {
			System.out.println(e.getName());
		}
	}

}
