package com.axsos.eventsBelt.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.eventsBelt.models.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{

}
