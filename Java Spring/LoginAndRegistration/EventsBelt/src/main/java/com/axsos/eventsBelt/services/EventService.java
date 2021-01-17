package com.axsos.eventsBelt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsos.eventsBelt.models.Event;
import com.axsos.eventsBelt.models.User;
import com.axsos.eventsBelt.models.Message;
import com.axsos.eventsBelt.repositories.EventRepository;
import com.axsos.eventsBelt.repositories.MessageRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private MessageRepository messageRepository;
	
	public List<Event> allEventsWithState(String state) {
		return this.eventRepository.findByState(state);
	}
	
	public List<Event> allEventsNotState(String state) {
		return this.eventRepository.findByStateIsNot(state);
	}
	public Event findById(Long id) {
		return this.eventRepository.findById(id).orElse(null);
	}
	public Event create(Event event) {
		return this.eventRepository.save(event);
	}
	public Event update(Event event) {
		return this.eventRepository.save(event);
	}
	public void comment(User user, Event event, String comment) {
		this.messageRepository.save(new Message(user, event, comment));
	}
	public void delete(Long id) {
		this.eventRepository.deleteById(id);
	}
	public void manageAttendees(Event event, User user, boolean isJoining) {
		if(isJoining) {
			event.getAttendees().add(user);
		} else {
			event.getAttendees().remove(user);
		}
		this.eventRepository.save(event);
	}
}
