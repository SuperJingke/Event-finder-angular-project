package com.ut.app.ws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMethod;
import com.events.model.Event;

@RestController
@RequestMapping("event-finder/rest/") //http://localhost:8080/event-finder
public class EventController {
	
	//Map to store events, eventId and the event
	Map<Integer, Event> eventData = new HashMap<Integer, Event>();
		
	public void init() {
		
		if (eventData.isEmpty()) {
			int eventId = 1;

			eventData.put(eventId, new Event(
					eventId,
					"St. Jacobs Sparkles",
					"Holiday Shopping Event",
					"https://www.stjacobsvillage.com/sparkles",
					"https://images.squarespace-cdn.com/content/v1/5c083af789c17249e7eb8404/1634741430246-QXGSDE32CAR8O7EYKPMV/StJacobSparkles2018-4.jpg?format=750w",
					"Main St, St. Jacobs",
					"2021/11/12",
					"2021/12/10",
					"Our annual St. Jacobs Sparkles event will occur again this fall. We’ve stretched out the dates to avoid crowding, "
					+ "so you get even more time to engage in the various activities and do your holiday shopping! "
					+ "Thousands of sparkling lights, a visit from Santa, sales & promotions, and more!"));

		}
	}
	
	
	//http://localhost:8080/event-finder/rest/event/{eventId}
	@RequestMapping(value = EventRestURIConstants.GET_EVENT, method = RequestMethod.GET)
	public @ResponseBody Event getEvent(@PathVariable("eventId") int eventId) {
		
		init();
		Event event= eventData.get(eventId);
		return (event);
	}
	
	//http://localhost:8080/event-finder/rest/event/book/{eventId}/{user}/{count}
	@RequestMapping(value = EventRestURIConstants.BOOK_EVENT, method = RequestMethod.GET)
	public @ResponseBody Event bookEvent(@PathVariable("eventId") int eventId, @PathVariable("email") String email, @PathVariable("count") int count) {
		
		init();
		Event event= eventData.get(eventId);
		if (event != null) {
			event.updateBooking(email, count);
		}
		return (event);
	}
	
	//http://localhost:8080/event-finder/rest/event/{eventId}
	@RequestMapping(value = EventRestURIConstants.GET_MY_EVENTS, method = RequestMethod.GET)
	public @ResponseBody  List<Event> getMyEvents(@PathVariable("email") String email) {
		
		init();
		List<Event> myEvents = new ArrayList<Event>();
		for (Event event : eventData.values()) {
			if (event.getBookingCount(email) > 0){
				myEvents.add(event);
			}
		}
		return (myEvents);
	}
	
	//http://localhost:8080/event-finder/rest/event/{eventId}
	@RequestMapping(value = EventRestURIConstants.SEARCH_UNBOOKED_EVENTS, method = RequestMethod.GET)
	public @ResponseBody  List<Event> getUnbookedEvents(@PathVariable("email") String email, @PathVariable("search") String search) {
		
		init();
		List<Event> unbookedEvents = new ArrayList<Event>();
		for (Event event : eventData.values()) {
			if (event.getBookingCount(email) == 0)
			{
				if (search == null || search.trim().isEmpty() || search.equals("*") )
				{
					unbookedEvents.add(event);
				} else if ( (event.getFullDescription().contains(search)) ||
						 	(event.getBrief().contains(search)) ||
						 	(event.getFullName().contains(search)) ) 
				{
					unbookedEvents.add(event);
				}
			}
		}
		return (unbookedEvents);
	}
	
		
}
