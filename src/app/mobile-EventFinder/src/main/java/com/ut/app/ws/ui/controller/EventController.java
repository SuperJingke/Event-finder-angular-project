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
	
	public void init() {
		
		if (eventData.isEmpty()) {
			int eventId = 1;
			eventData.put(eventId, new Event(
					eventId++,
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

			eventData.put(eventId, new Event(
					eventId++,
					"Snow Magic",
					"Drive Thru Art Exhibit and Wonderland",
					"https://www.drivethrufunco.com/experience",
					"https://www.todocanada.ca/wp-content/uploads/Snow-Magic-855x421.jpg",
					"Ontario Place, 955 Lake Shore Blvd W, Toronto",
					"2021/11/12",
					"2022/1/16",
					"A winter wonderland that only dreams are made of. Let epic creatures, caverns, sights & lights surround you.\r\n" + 
					"18 fantastical artworks to inspire all. 1.7 km of enchanting drive thru fun.\r\n" + 
					"Realize your adventure in these realms: Celestial, Terra Firma, Oceanic.\r\n" + 
					"Enter Celestial and fly through the night amongst the stars. Next, explore dreamland on Terra Firma with its incredible creatures, "
					+ "the castle and frosty wonders. Onward, through a gleaming grotto close to shore, dive deep into Oceanic to play amongst the beings that thrive there. "
					+ "Lastly, find yourself back on Terra Firma yet only to be enchanted once again."));
			
			eventData.put(eventId, new Event(
					eventId++,
					"Simcoe Panorama",
					"Walking Holiday Light Tour",
					"http://www.simcoepanorama.ca/visitus/",
					"https://www.todocanada.ca/wp-content/uploads/Simcoe-Christmas-Panorama-1-855x570.jpg",
					"Wellington Park, 50 Bonnie Drive, Simcoe",
					"2021/12/04",
					"2022/1/02",
					"Experience the charm of the original light festival in Ontario during the annual Simcoe Christmas Panorama and "
					+ "start your journey in a world of wonder as twinkling lights glimmer throughout the night."));

			eventData.put(eventId, new Event(
					eventId++,
					"That Choir CAROLS 2021",
					"a wonderful night of music ",
					"https://www.eventbrite.ca/e/that-choir-carols-2021-tickets-169137303227?aff=ebdssbdestsearch",
					"https://img.evbuc.com/https%3A%2F%2Fcdn.evbuc.com%2Fimages%2F146146903%2F109555262949%2F1%2Foriginal.20210831-162917?w=800&auto=format%2Ccompress&q=75&sharp=10&rect=0%2C0%2C2160%2C1080&s=12ab7c5197a3f760e5b78bc9607ff8b6",
					"St. Andrew's Presbyterian Church, 73 Simcoe Street, Toronto, ON M5J 1W9",
					"2021/12/18",
					"2021/12/19",
					"What has become a family tradition, That Choir Carols is a wonderful night of music making with some of your favourite carols and holiday music. "
					+"Through a shared musical experience, this concert will inspire community, while bringing together family and friends to celebrate the love and warmth of Christmas, the holidays and the Solstice."));
			
			eventData.put(eventId, new Event(
					eventId++,
					"Caribbean Eats",
					"Caribbean Eats Indoor Night Market: An All Black Affair",
					"https://www.eventbrite.ca/e/caribbean-eats-indoor-night-market-an-all-black-affair-tickets-174329503237?aff=ebdssbdestsearch",
					"https://img.evbuc.com/https%3A%2F%2Fcdn.evbuc.com%2Fimages%2F151565449%2F552400482913%2F1%2Foriginal.20210917-211930?w=800&auto=format%2Ccompress&q=75&sharp=10&rect=0%2C575%2C1728%2C864&s=c451cbb72d636366585bcd575b4ee38d",
					"2642 Eglinton Avenue East, Upper Level, Toronto, ON M1K 2S3",
					"2021/08/16",
					"2021/12/18",
					"Caribbean Eats will host Toronto's first Indoor Night Market featuring quality black-owned businesses from across the GTA!\r\n" 
					+ "Making available a wide array of cultural, culinary, health and fashionable goods, the Night Market will be this season's spectacle. "
					+ "It features quality vendors selling wines, mens' and womens' fashion, books, decadent, savory foods, fresh juices, beauty products and much more."));
		}
	}
	
	

		
}
