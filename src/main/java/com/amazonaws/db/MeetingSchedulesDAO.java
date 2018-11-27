package com.amazonaws.db;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.amazonaws.model.Meeting;
import com.amazonaws.model.MeetingSchedule;

public class MeetingSchedulesDAO {
	java.sql.Connection conn;
	
	public MeetingSchedulesDAO() {
		try {
			conn = DatabaseUtil.connect();
		} catch (Exception e) {
			conn = null;
		}
	}
	
	public MeetingSchedule getMeetingScheduleSecretID(String secretID) throws Exception {
		try {
			MeetingSchedule ms = null;
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM meetings WHERE secretID=?;");
			ps.setString(1, secretID);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				ms = generateMeetingSchedule(resultSet);
			}
			resultSet.close();
			ps.close();
			
			return ms;
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in getting meeting schedule: " + e.getMessage());
		}
	}
	
	public MeetingSchedule getMeetingSchedule(String scheduleID) throws Exception {
		try {
			MeetingSchedule ms = null;
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM meetings WHERE scheduleID=?;");
			ps.setString(1, scheduleID);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				ms = generateMeetingSchedule(resultSet);
			}
			resultSet.close();
			ps.close();
			
			return ms;
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in getting meeting schedule: " + e.getMessage());
		}
	}
	
	private MeetingSchedule generateMeetingSchedule(ResultSet resultSet) throws Exception {
		String secretID = resultSet.getString("secretID");
		String title = resultSet.getString("title");
		String scheduleID = resultSet.getString("scheduleID");
		HashMap<String, Meeting> meetings = null;
		//TODO get hashmap of meetings from resultSet
		LocalDate startDate = resultSet.getDate("startDate").toLocalDate();
		LocalDate endDate = resultSet.getDate("endDate").toLocalDate();
		int startHour = resultSet.getInt("startHour");
		int endHour = resultSet.getInt("endHour");
		int meetingDuration = resultSet.getInt("meetingDuration");
		LocalDate creationDate = resultSet.getDate("creationDate").toLocalDate();
		return new MeetingSchedule(secretID, title, scheduleID, meetings, startDate, endDate,
				startHour, endHour, meetingDuration, creationDate);
	}
}
