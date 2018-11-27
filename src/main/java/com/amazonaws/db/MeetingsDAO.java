package com.amazonaws.db;

import java.sql.*;
import java.time.LocalDate;
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
				meeting = generateMeeting(resultSet);
			}
			resultSet.close();
			ps.close();
			
			return meeting;
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Failed in gettting constant: " + e.getMessage());
		}
	}
	
	public boolean deleteMeeting(Meeting meeting) throws Exception {
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM meetings WHERE secretID=?;");
			ps.setString(1, meeting.secretID);
			int numAffected = ps.executeUpdate();
			ps.close();
			
			return (numAffected == 1);
		} catch (Exception e) {
			throw new Exception("Failed to delete constant: " + e.getMessage());
		}
	}
	
	public boolean addMeeting(Meeting meeting) throws Exception {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM meetings WHERE secretID=?;");
			ps.setString(1, meeting.secretID);
			ResultSet resultSet = ps.executeQuery();
			
			//Already present
			while (resultSet.next()) {
				Meeting m = generateMeeting(resultSet);
				resultSet.close();
				return false;
			}
			
			ps = conn.prepareStatement("INSERT INTO meetings (participant,secretID,meetingID,startTime,date,isLocked) values(?,?,?,?,?,?);");
			ps.setString(1, meeting.participant);
			ps.setString(2, meeting.secretID);
			ps.setString(3, meeting.meetingID);
			ps.setInt(4, meeting.startTime);
			//TODO set sql date in ps.setDate(5, meeting.date) but in sql date format
			ps.setBoolean(6, meeting.isLocked);
			ps.execute();
			return true;
		} catch (Exception e) {
			throw new Exception("Failed to insert meeting: " + e.getMessage());
		}
	}
	
	public List<Meeting> getAllMeetings() throws Exception {
		List<Meeting> allMeetings = new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			String query = "SELECT * FROM meetings";
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				Meeting m = generateMeeting(resultSet);
				allMeetings.add(m);
			}
			resultSet.close();
			statement.close();
			return allMeetings;
		} catch (Exception e) {
			throw new Exception("Failed in getting books: " + e.getMessage());
		}
	}
	
	private Meeting generateMeeting(ResultSet resultSet) throws Exception {
		String participant = resultSet.getString("participant");
		String secretID = resultSet.getString("secretID");
		String meetingID = resultSet.getString("meetingID");
		int startTime = resultSet.getInt("startTime");
		LocalDate date = resultSet.getDate("date").toLocalDate();
		boolean isLocked = resultSet.getBoolean("isLocked");
		return new Meeting(participant, secretID, meetingID, startTime, date, isLocked);
	}
}
