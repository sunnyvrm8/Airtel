package com.airtel.report.monitor.repo;

import com.airtel.report.monitor.domain.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Created by sunny on 04/03/18.
 */
@Repository
public interface EventRepository extends MongoRepository<Event, Long> {

    @Query(value="{ 'eventType' : ?0, 'ts' : ?1 }")
    List<Event> getUsers(String category, String date);

    @Query(value="{ 'ts' : ?0}")
    List<Event> getUsersByDay(String day);

    @Query(value="{ 'eventType' : ?0}, 'ts' : ?1 }")
    List<Event> getUsersByEventType(String eventType, String date);

    @Query(value="{ 'eventName' : ?0}, 'ts' : ?1 }")
    List<Event> getUsersByEventName(String eventName, String date);

}