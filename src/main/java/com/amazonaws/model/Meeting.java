package com.amazonaws.model;

import java.time.LocalDate;

public class Meeting {
	public final String participant;
	public final String secretID;
	public final String meetingID;
	public final int startTime;
	public final LocalDate date;
	public final boolean isLocked;
	
	public Meeting(String participant,String secretID, String meetingID, int startTime, LocalDate date, boolean isLocked) {
		this.participant = participant;
		this.secretID = secretID;
		this.meetingID = meetingID;
		this.startTime = startTime;
		this.date = date;
		this.isLocked = isLocked;
	}
}
