package com.amazonaws.model;

import java.util.Date;
import java.util.HashMap;

public class MeetingSchedule {
	public final String secretID;
	public final String title;
	public final String scheduleID;
	public final HashMap<String, Meeting> meetings;
	public final Date startDate;
	public final Date endDate;
	public final int startHour;
	public final int endHour;
	public final int meetingDuration;
	public final Date creationDate;
	
	public MeetingSchedule(
			String secretID, String title, String scheduleID,
			HashMap<String, Meeting> meetings, Date startDate, Date endDate,
			int startHour, int endHour, int meetingDuration, Date creationDate) {
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
