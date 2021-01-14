package com.axsos.dojoOverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.axsos.dojoOverflow.models.Answer;
import com.axsos.dojoOverflow.models.Question;
import com.axsos.dojoOverflow.models.QuestionForm;
import com.axsos.dojoOverflow.models.Tag;
import com.axsos.dojoOverflow.repositories.AnswerRepository;
import com.axsos.dojoOverflow.repositories.QuestionRepository;
import com.axsos.dojoOverflow.repositories.TagRepository;

@Service
public class AppService {
	private final TagRepository tagRepository;
	private final AnswerRepository answerRepository;
	private final QuestionRepository questionRepository;
	public AppService(TagRepository tagRepository,
			AnswerRepository answerRepository,
			QuestionRepository questionRepository) {
		this.tagRepository = tagRepository;
		this.answerRepository = answerRepository;
		this.questionRepository = questionRepository;
	}
	
	public Question getQuestionById(Long id) {
		return this.questionRepository.findById(id).orElse(null);
	}
	public List<Question> allQuestions(){
		return this.questionRepository.findAll();
	}
	
	public void createAnswer(Answer answer,Question question) {
		answer.setQuestion(question);
		answer=this.answerRepository.save(answer);
}

	public Question createQuestion(QuestionForm form) {
		String[] tags=form.getTagsList();
		List<Tag> tagsList = new ArrayList<Tag>() ;
		for(int i=0;i<tags.length;i++) {
			Tag temp=this.tagRepository.findBySubject(tags[i]).orElse(null);
			if(temp==null)
				temp=this.tagRepository.save(new Tag(tags[i]));
			tagsList.add(temp);
		}
		return this.questionRepository.save(new Question(form.getQuestion(),tagsList));

	}
	
	
}
