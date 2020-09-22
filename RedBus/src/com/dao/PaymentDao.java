package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentDao {
	public static boolean insertpaymentdetails(int uid1, int ticket_id, String from, String to, int totalprice) throws ClassNotFoundException, SQLException {
		Connection con=ConnectionUtility.getConnection();
		PreparedStatement ps =  con.prepareStatement("insert into payment(user_id,ticket_id,startpoint,endpoint,totalprice) values(?,?,?,?,?)");

		ps.setInt(1, uid1);
		ps.setInt(2, ticket_id);
		ps.setString(3, from);
		ps.setString(4, to);
		ps.setInt(5, totalprice);

		if (ps.executeUpdate() > 0){
			return true;
		}
		
		return false;
	}

}
