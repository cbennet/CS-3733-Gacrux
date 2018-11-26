package com.amazonaws.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.amazonaws.model.Meeting;

public class MeetingsDAO {
	
	java.sql.Connection conn;
	
	public MeetingsDAO() {
		try {
			conn = DatabaseUtil.connect();
		} catch (Exception e) {
			conn = null;
		}
	}
	
	public Meeting getMeeting(String secretID) throws Exception {
		try {
			Meeting meeting = null;
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM meetings WHERE secretID=?;");
			ps.setString(1, secretID);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				meeting = null;//generateConstant(resultSet);
			}
			resultSet.close();
			ps.close();
			
			return meeting;
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in gettting constant: " + e.getMessage());
		}
	}
	//TODO create a generateMeeting method after database is createds
}
