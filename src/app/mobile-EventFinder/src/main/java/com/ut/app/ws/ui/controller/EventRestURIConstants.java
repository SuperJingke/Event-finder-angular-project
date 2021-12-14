package com.ut.app.ws.ui.controller;

public class EventRestURIConstants {

	public static final String DUMMY_EVENT = "event/dummy";
	public static final String GET_EVENT = "event/{eventId}";
	public static final String GET_MY_EVENTS = "myEvents/{email}";
	public static final String SEARCH_UNBOOKED_EVENTS = "unbookedEvents/{email}/{search}";
	public static final String BOOK_EVENT = "event/book/{eventId}/{email}/{count}";
}
