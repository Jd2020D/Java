package com.axsos.dojoOverflow.models;

import java.util.Arrays;
import java.util.HashSet;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class QuestionForm {
	@NotBlank(message = "THIS FIELD IS REQUIRED!")
	private String question;
	@Pattern(regexp="^(([a-zA-Z\\s])+$|([a-zA-Z\\s]+,)[a-zA-Z\\s]+){1,2}$",message="Tags must be separated by commas, max 3")
	private String tags;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String[] getTagsList() {

		return new HashSet<String>(Arrays.asList(this.tags.split(","))).toArray(new String[0]);
	}
	
	
}
