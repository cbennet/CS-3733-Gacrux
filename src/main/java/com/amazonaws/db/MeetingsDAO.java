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
	
	public Meeting getMeeting() {
		return null;
	}
}
