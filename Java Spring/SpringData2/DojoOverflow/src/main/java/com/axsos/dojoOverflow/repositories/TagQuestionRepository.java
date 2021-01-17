package com.axsos.dojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.dojoOverflow.models.TagQuestion;

@Repository
public interface TagQuestionRepository extends CrudRepository<TagQuestion, Long> {
}
