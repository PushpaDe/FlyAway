package com.flyaway.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flyaway.models.User;
import com.flyaway.utils.HibernateUtils;

public class UserDao {
	public void saveUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			String hql = "INSERT INTO Employee(firstName, lastName, salary)"  + 
		             "SELECT firstName, lastName, salary FROM old_employee";
		Query query = session.createQuery(hql);
		int result = query.executeUpdate();
		System.out.println("Rows affected: " + result);
			session.save(user);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public boolean validate(String username, String password) {
		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			user = (User) session.createQuery("FROM User U WHERE U.UserName = :username")
					.setParameter("username", username).uniqueResult();
			
			System.out.println(user);

			if (user != null && user.getPassword().equals(password)) {
				return true;
			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public String validateRole(String username)
	{
		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			user = (User) session.createQuery("FROM User U WHERE U.UserName = :username")
					.setParameter("username", username).uniqueResult();
			
			System.out.println(user);
			return user.getRole();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
		}
		return user.getRole();
	}
}
