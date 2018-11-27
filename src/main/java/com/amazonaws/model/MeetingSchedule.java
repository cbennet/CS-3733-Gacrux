package com.amazonaws.model;

import java.time.LocalDate;
import java.util.HashMap;

public class MeetingSchedule {
	public final String secretID;
	public final String title;
	public final String scheduleID;
	public final HashMap<String, Meeting> meetings;
	public final LocalDate startDate;
	public final LocalDate endDate;
	public final int startHour;
	public final int endHour;
	public final int meetingDuration;
	public final LocalDate creationDate;
	
	public MeetingSchedule(
			String secretID, String title, String scheduleID,
			HashMap<String, Meeting> meetings, LocalDate startDate, LocalDate endDate,
			int startHour, int endHour, int meetingDuration, LocalDate creationDate) {
		this.secretID = secretID;
		this.title = title;
		this.scheduleID = scheduleID;
		this.meetings = meetings;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startHour = startHour;
		this.endHour = endHour;
		this.meetingDuration = meetingDuration;
		this.creationDate = creationDate;
	}
}
