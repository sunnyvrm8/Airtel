package com.airtel.report.monitor.service;

import java.util.Set;
/**
 * Created by sunny on 04/03/18.
 */
public interface MonitorService {
    Set<String> getEventName();
    Set<String> getUsersByCatDate(String category, String date);
    Set<String> getUsersByDay(String day);
    Set<String> getUsersByDroppedPayment(String day);
    double getConversionPercentage(String date);

}
