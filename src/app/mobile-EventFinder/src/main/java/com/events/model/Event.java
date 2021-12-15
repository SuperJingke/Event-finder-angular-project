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
    private String fullName; 
    private String brief;  
    private String contact;
    private String imageUrl;
    private String location;
    private String postalCode;
	private String dateStart;
    private String dateEnd;
    private String fullDescription;
    private Boolean isBooked;
    public Boolean getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(Boolean isBooked) {
		this.isBooked = isBooked;
	}

	private Map<String,Integer> bookings = new HashMap<String,Integer>();
    
	public Event(int eventId, String fullName, String brief, String contact, String imageUrl, 
			String location, String postalCode,
			String dateStart, String dateEnd, String fullDescription) {
		
		super();
		this.eventId = eventId;
		this.fullName = fullName;
		this.brief = brief;
		this.contact = contact;
		this.imageUrl = imageUrl;
		this.location = location;
		this.postalCode = postalCode;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.fullDescription = fullDescription;
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
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

    public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getFullDescription() {
		return fullDescription;
	}

	public void setFullDescription(String fullDescription) {
		this.fullDescription = fullDescription;
	}

    
    public Map<String, Integer> getBookings() {
		return bookings;
	}

	public void updateBooking(String user, int count) {
		bookings.put(user, count);
		this.isBooked =true;
	}

	public int getBookingCount(String user) {
		
		if (user == null || user.isEmpty())
			return 0;

		return (bookings.getOrDefault(user, 0));
	}

	
}
