package com.flyaway.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flyaway.models.Airline;
import com.flyaway.models.Cities;
import com.flyaway.models.Flight;
import com.flyaway.models.User;
import com.flyaway.utils.HibernateUtils;

public class FlightDao {
	List<Map<String, Object>> flightDetails = new ArrayList<>();
	public void saveFlight(Flight flight) {
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(flight);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Map<String, Object>> searchFlight(String source, String destination, String date, String capacity)
	{
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			System.out.println("Me in Dao");
			//flight = (Flight) session.createQuery("select f.depTime, f.arrTime, a.aName from flight f, airline a where f.depTime >= :date and f.deptime > curdate() and f.aid = a.aid and f.source = (Select c.CID from cities c where c.cName = :source) and f.destination = (Select c.CID from cities c where c.cName = :destination) and f.fid not in select distinct(b.fid) from bookingdetails b, passengerdetail p where  b.bid = p.bid group by b.bid having count(b.bid) > f.capacity - :capacity)").uniqueResult();
			String sql = "select f.DepTime, f.ArrTime, a.aName from Flight f, Airline a where Date(f.DepTime) ='" +date+ "' and f.aid = a.aid and f.Source = (Select c.CID from Cities c where c.CName = '" +source+ "') and f.Destination = (Select c.CID from Cities c where c.CName = '" +destination+ "') and f.FID not in (select distinct(b.FID) from BookingDetails b, passengerDetail p where  b.bid = p.bid group by b.bid having count(b.bid) > f.Capacity - '" +capacity+ "')";
			SQLQuery query = session.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			flightDetails.addAll(query.list());
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return flightDetails;
	}
}
