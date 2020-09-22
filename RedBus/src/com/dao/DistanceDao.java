package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DistanceDao {
	public static int getkilometers(String from, String to) throws ClassNotFoundException, SQLException {
		Connection con = ConnectionUtility.getConnection();
		PreparedStatement ps = (PreparedStatement) con
				.prepareStatement("select kilometers from distance where startpoint=? and endpoint=?");
		ps.setString(1, from);
		ps.setString(2, to);
		

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			return rs.getInt(1);

		}
		return 0;

	}

}
