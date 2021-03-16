/*
 * Adam Bender
 * CST 323 Activity 2
 * 1/17/2021
 * Data Service
 */

package com.gcu.data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.gcu.business.OrdersBusinessService;
import com.gcu.model.User;
import com.gcu.utility.MyLogger;

public class OrdersDataService implements DataAccessInterface {

	private DataSource ds;
	private JdbcTemplate jto;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
		this.jto = new JdbcTemplate(ds);
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		MyLogger.getInstance().Info("Entering findAll method", OrdersDataService.class);
		
		List<User> orders = new ArrayList<User>();

		String stmt = "SELECT * FROM visitor";
		SqlRowSet rs = jto.queryForRowSet(stmt);

		while (rs.next()) {
			String id = rs.getString("FIRST_NAME");
			String pN = rs.getString("LAST_NAME");
			String p = rs.getString("DATE");

			User o1 = new User(id, pN, p);
			orders.add(o1);
		}

		MyLogger.getInstance().Info("Exiting findAll method", OrdersDataService.class);
		return orders;
	}

	@Override
	public boolean create(User t) {

		MyLogger.getInstance().Info("Entering create method", OrdersDataService.class);
		
		// get the current date to add to DB
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
				
		String stmt = "INSERT INTO visitor(FIRST_NAME, LAST_NAME, DATE) VALUES(?, ?, ?)";

		int rowsInserted = jto.update(stmt, t.getFirstName(), t.getLastName(), dtf.format(now));

		if (rowsInserted > 0) {
			System.out.println("Data service Success");
			return true;
		} else {
			System.out.println("Data service Fail");

		}

		MyLogger.getInstance().Info("Exiting create method", OrdersDataService.class);
		return false;
	}
}
