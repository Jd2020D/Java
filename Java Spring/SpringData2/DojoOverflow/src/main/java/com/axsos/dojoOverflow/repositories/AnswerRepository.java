package com.axsos.dojoOverflow.repositories;

import com.axsos.dojoOverflow.models.Answer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
}
