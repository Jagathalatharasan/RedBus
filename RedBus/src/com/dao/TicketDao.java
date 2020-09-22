package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TicketDao {
	public static boolean getticket(int user_id,String from,String to) throws ClassNotFoundException, SQLException {
		Connection con=ConnectionUtility.getConnection();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into ticket(usert_id,from_t,to_t) values(?,?,?)");
		ps.setInt(1,user_id);
		ps.setString(2, from);
		ps.setString(3, to);
		
		if(ps.executeUpdate()>0){
			return true;
		}
		
		return false;
	}

	public static int getticketId(int user_id) throws SQLException, ClassNotFoundException {
		Connection con=ConnectionUtility.getConnection();
		PreparedStatement ps=(PreparedStatement) con.prepareStatement("select max(ticket_id) from ticket where usert_id=?");
		ps.setInt(1,user_id);
		
		ResultSet rs=ps.executeQuery();
		
		if(rs.next()){
			return rs.getInt(1);
		}
		return 0;
	}
	
	

}
