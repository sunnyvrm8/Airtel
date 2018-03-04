package com.airtel.report.monitor.service;

import com.airtel.report.monitor.constants.MonitorConstant;
import com.airtel.report.monitor.domain.Event;
import com.airtel.report.monitor.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by sunny on 04/03/18.
 */

@Service
public class MonitorServiceImpl implements MonitorService{
    private final static Logger LOGGER = Logger.getLogger(MonitorServiceImpl.class.getName());
    @Autowired
    private EventRepository eventRepository;

    @Override
    public Set<String> getEventName() {
        List<Event> eventNames = eventRepository.findAll();
        if(eventNames == null)
            return null;
        Set<String> uniqueEventNames = new HashSet<>();
        for(Event eventName : eventNames){
            uniqueEventNames.add(eventName.getEventName());
        }
        return uniqueEventNames;
    }

    @Override
    public Set<String> getUsersByCatDate(String category, String date) {
        List<Event> eventList = eventRepository.getUsers(category, date);
        if(eventList == null)
            return null;
        Set<String> userIds = new HashSet<>();
        for(Event event : eventList){
            userIds.add(event.getUserId());
        }
        return userIds;
    }

    @Override
    public Set<String> getUsersByDay(String day) {
        List<Event> eventList = eventRepository.getUsersByDay(day);
        if(eventList == null)
            return null;
        Set<String> userIds = new HashSet<>();
        for(Event event : eventList){
            userIds.add(event.getUserId());
        }
        return userIds;
    }

    @Override
    public Set<String> getUsersByDroppedPayment(String day) {
        List<Event> visitList = eventRepository.getUsersByEventName(MonitorConstant.VISIT, day);
        List<Event> paymentList = eventRepository.getUsersByEventName(MonitorConstant.PAYMENT, day);
        if(visitList == null)
            return null;
        Set<String> userIdsVisit = new HashSet<>();
        for(Event event : visitList){
            userIdsVisit.add(event.getUserId());
        }

        Set<String> userIdsPayment = new HashSet<>();
        for(Event event : paymentList){
            userIdsPayment.add(event.getUserId());
        }

        userIdsVisit.removeAll(userIdsPayment);
        return userIdsVisit;
    }

    @Override
    public double getConversionPercentage(String date) {
        List<Event> visitList = eventRepository.getUsersByEventType(MonitorConstant.VISIT, date);
        List<Event> bookingList = eventRepository.getUsersByEventType(MonitorConstant.BOOKING, date);
        if(visitList == null)
            return 0.0;
        Set<String> userIdsVisit = new HashSet<>();
        for(Event event : visitList){
            userIdsVisit.add(event.getUserId());
        }

        Set<String> userIdsBooking = new HashSet<>();
        for(Event event : bookingList){
            userIdsBooking.add(event.getUserId());
        }

        float booked = userIdsBooking.size();
        float visit = userIdsVisit.size();

        return visit == 0.0 || booked == 0.0 ? 0.0 : (booked/visit)*100;
    }
}
