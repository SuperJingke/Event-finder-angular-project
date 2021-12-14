package com.events.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

public class Event implements Serializable{


	private int eventId;
    private String FullName; 
    private String Brief;  
    private String Contact;
    private String ImageUrl;
    private String Location;
    private String DateStart;
    private String DateEnd;
    private String FullDescription;
    private Map<String,Integer> bookings = new HashMap<String,Integer>();
    
	public Event(int eventId, String fullName, String brief, String contact, String imageUrl, String location,
			String dateStart, String dateEnd, String fullDescription) {
		
		super();
		this.eventId = eventId;
		FullName = fullName;
		Brief = brief;
		Contact = contact;
		ImageUrl = imageUrl;
		Location = location;
		DateStart = dateStart;
		DateEnd = dateEnd;
		FullDescription = fullDescription;
	}

	private static final long serialVersionUID = -7788619177798333712L;
	   
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getBrief() {
		return Brief;
	}

	public void setBrief(String brief) {
		Brief = brief;
	}

	public String getContact() {
		return Contact;
	}

	public void setContact(String contact) {
		Contact = contact;
	}

	public String getImageUrl() {
		return ImageUrl;
	}

	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getDateStart() {
		return DateStart;
	}

	public void setDateStart(String dateStart) {
		DateStart = dateStart;
	}

	public String getDateEnd() {
		return DateEnd;
	}

	public void setDateEnd(String dateEnd) {
		DateEnd = dateEnd;
	}

	public String getFullDescription() {
		return FullDescription;
	}

	public void setFullDescription(String fullDescription) {
		FullDescription = fullDescription;
	}

    
    public Map<String, Integer> getBookings() {
		return bookings;
	}

	public void updateBooking(String user, int count) {
		bookings.put(user, count);
	}

	public int getBookingCount(String user) {
		
		if (user == null || user.isEmpty())
			return 0;

		return (bookings.getOrDefault(user, 0));
	}

	
}
