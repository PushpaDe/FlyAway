package com.flyaway.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flyaway.models.Airline;
import com.flyaway.utils.HibernateUtils;

public class AirlineDao {
	public void saveUser(Airline airLine) {
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(airLine);
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
