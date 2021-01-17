package com.axsos.eventsBelt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.eventsBelt.models.AttendedEvent;

@Repository
public interface AttendedEventRepository extends CrudRepository<AttendedEvent, Long>{
//	List<AttendedEvent>findAllByEventIdAndUserId(Long EventId,Long UserId);
//	@Query
}
