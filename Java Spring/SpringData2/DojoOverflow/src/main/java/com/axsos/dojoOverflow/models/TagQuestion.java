package com.axsos.dojoOverflow.models;

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
import javax.validation.constraints.Pattern;

//...
@Entity
@Table(name="tags_questions")
public class TagQuestion {
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
 @JoinColumn(name="question_id")
 private Question question;
 
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name="tag_id")
 private Tag tag;
 
 public TagQuestion() {
     
 }
public Question getQuestion() {
	return question;
}

public void setQuestion(Question question) {
	this.question = question;
}

public Tag getTag() {
	return tag;
}

public void setTag(Tag tag) {
	this.tag = tag;
}

public Long getId() {
	return id;
}

public Date getCreatedAt() {
	return createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}
 
}