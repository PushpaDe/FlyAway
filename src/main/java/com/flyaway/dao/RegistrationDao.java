package com.flyaway.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flyaway.models.PassengerDetails;
import com.flyaway.models.User;
import com.flyaway.utils.HibernateUtils;

public class RegistrationDao {
	
	public void saveUser(User user,PassengerDetails pass) {
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
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

}
