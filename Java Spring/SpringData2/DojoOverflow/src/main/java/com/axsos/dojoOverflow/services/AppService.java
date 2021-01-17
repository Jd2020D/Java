package com.axsos.dojoOverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axsos.dojoOverflow.models.Answer;
import com.axsos.dojoOverflow.models.Question;
import com.axsos.dojoOverflow.models.QuestionForm;
import com.axsos.dojoOverflow.models.Tag;
import com.axsos.dojoOverflow.models.TagQuestion;
import com.axsos.dojoOverflow.repositories.AnswerRepository;
import com.axsos.dojoOverflow.repositories.QuestionRepository;
import com.axsos.dojoOverflow.repositories.TagQuestionRepository;
import com.axsos.dojoOverflow.repositories.TagRepository;

@Service
public class AppService {
	private final TagRepository tagRepository;
	private final AnswerRepository answerRepository;
	private final QuestionRepository questionRepository;
	private final TagQuestionRepository tagQuestionRepository;
	public AppService(TagRepository tagRepository,
			AnswerRepository answerRepository,
			QuestionRepository questionRepository,
			TagQuestionRepository tagQuestionRepository) {
		this.tagRepository = tagRepository;
		this.answerRepository = answerRepository;
		this.questionRepository = questionRepository;
		this.tagQuestionRepository = tagQuestionRepository;
	}
	
	public Question getQuestionById(Long id) {
		return this.questionRepository.findById(id).orElse(null);
	}
	public List<Question> allQuestions(){
		return this.questionRepository.findAll();
	}
	
	public void createAnswer(Answer answer,Question question) {
		answer = new Answer(answer.getAnswer(),question);
		answer=this.answerRepository.save(answer);
}

	public Question createQuestion(QuestionForm form) {
		String[] tags=form.getTagsList();
		Question question=this.questionRepository.save(new Question(form.getQuestion()));
		for(int i=0;i<tags.length;i++) {
			Tag tag=this.tagRepository.findBySubject(tags[i].trim()).orElse(null);
			if(tag==null)
				tag=this.tagRepository.save(new Tag(tags[i].trim()));
			this.tagQuestionRepository.save(new TagQuestion(question, tag));
		}
		return question;

	}
	
	
}
