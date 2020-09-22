package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.dto.PassengerDto;
import com.dto.TicketDto;
import com.dto.UserDto;

public class PassengerDao {
	public static boolean insertpassengerdetails(int uid1, int ticket_id, String n1, String g, int a1, String category,
			Timestamp ts) throws SQLException, ClassNotFoundException {
		Connection con = ConnectionUtility.getConnection();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(
				"insert into passenger (user_id,ticket_id,name,gender,age,category,order_date) values(?,?,?,?,?,?,?)");
		ps.setInt(1, uid1);
		ps.setInt(2, ticket_id);
		ps.setString(3, n1);
		ps.setString(4, g);
		ps.setInt(5, a1);
		ps.setString(6, category);
		ps.setTimestamp(7, ts);

		if (ps.executeUpdate() > 0) {
			return true;
		}

		return false;
	}

	public static List<PassengerDto> ShowPassengerDetails(int uid1, int ticket_id)
			throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtility.getConnection();
		PreparedStatement ps = (PreparedStatement) con
				.prepareStatement("select * from passenger where user_id=? and ticket_id=?");
		ps.setInt(1, uid1);
		ps.setInt(2, ticket_id);
		ResultSet rs = ps.executeQuery();
		PassengerDto p = null;
		List<PassengerDto> plist = new ArrayList<PassengerDto>();
		while (rs.next()) {
			UserDto u = new UserDto();
			u.setId(rs.getInt(2));
			TicketDto t = new TicketDto();
			t.setTicket_id(rs.getInt(3));
			p = new PassengerDto(rs.getInt(1), u, t, rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7),
					rs.getTimestamp(8));
			plist.add(p);
		}
		return plist;
	}

	public static int getcount(int ticket_id) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtility.getConnection();
		PreparedStatement ps = (PreparedStatement) con
				.prepareStatement("select count(ticket_id) from passenger where ticket_id=?");

		ps.setInt(1, ticket_id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return rs.getInt(1);
		}
		return 0;
	}

}
