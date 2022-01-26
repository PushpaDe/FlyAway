package com.flyaway.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flyaway.models.Cities;
import com.flyaway.models.User;
import com.flyaway.utils.HibernateUtils;

public class CitiesDao {
	List<String> listCities = new ArrayList<>();
	String cityName=null;
	private List<String> listCity;
	/*
	 * String databaseURL =
	 * "jdbc:mysql://localhost:3306/phase2_flight?useSSL=false"; String user =
	 * "root"; String password = "Behappy@11"; String driverName =
	 * "com.mysql.jdbc.Driver";
	 * 
	 * public List<Cities> list() throws SQLException { List<Cities> listCities =
	 * new ArrayList<>();
	 * 
	 * try(Connection con = DriverManager.getConnection(databaseURL, user,
	 * password)) { String sql = "SELECT * from Cities"; Statement stmt =
	 * con.createStatement(); ResultSet rs= stmt.executeQuery(sql); while(rs.next())
	 * { int id = rs.getInt("CID"); System.out.println("id"); String name =
	 * rs.getString("CName"); Cities city = new Cities(id,name);
	 * listCities.add(city); } }catch(SQLException e) { e.printStackTrace(); throw
	 * e; } return listCities; }
	 */
	
	public void saveCities(Cities city) {
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(city);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	public List<String> getDropDownValue(String value) {
		Transaction transaction = null;
		Cities city = null;
		List<String> names = new ArrayList<String>();
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			String sql = "SELECT * FROM cities";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Cities.class);
			List data = query.list();
			 Iterator<Cities> itr=data.iterator(); 
			 while(itr.hasNext()){    
				 Cities e=itr.next();    
				/*
				 * System.out.println(e); cityName = e.getCName(); System.out.println(cityName);
				 * listCities.add(cityName);
				 */
				 if(e.getCCode().toLowerCase().contains(value.toLowerCase()))
					{
						names.add(e.getCCode());
					}
				 
				/*
				 * if(cityName.startsWith(value)) {
				 * System.out.println("I am in If block of City"); listCities.add(cityName);
				 * }else { System.out.println("I am in else block of City"); }
				 */
				     } 
			System.out.println(listCities);
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println(e.getMessage());
		}
		return names;
	}
	
	/*
	 * public List<String> getData(String query) { String country = null; query =
	 * query.toLowerCase(); List<String> matched = new ArrayList<>(); for(int i=0;
	 * i<getDropDownValue(); i++) { country = listCities.get(i).toLowerCase();
	 * System.out.println(country); if(country.startsWith(query)) {
	 * matched.add(country); } } return matched; }
	 */

}
