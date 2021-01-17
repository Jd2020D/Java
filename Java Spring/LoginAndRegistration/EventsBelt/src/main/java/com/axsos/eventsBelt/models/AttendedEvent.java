package com.axsos.eventsBelt.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="users_events")
public class AttendedEvent {
	 @Id

	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	 @PrePersist
	 protected void onCreate() {
	     this.createdAt = new Date();
	 }

	 @PreUpdate
	 protected void onUpdate() {
	     this.updatedAt = new Date();
	 }


	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="user_id")
	 private User userAtend;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name="event_id")
	 private Event eventAtended;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public AttendedEvent(User userAtend, Event eventAtended) {
		this.userAtend = userAtend;
		this.eventAtended = eventAtended;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUserAtend() {
		return userAtend;
	}

	public void setUserAtend(User userAtend) {
		this.userAtend = userAtend;
	}

	public Event getEventAtended() {
		return eventAtended;
	}

	public void setEventAtended(Event eventAtended) {
		this.eventAtended = eventAtended;
	}
}
