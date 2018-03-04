package com.airtel.report;

import com.airtel.report.monitor.domain.Event;
import com.airtel.report.monitor.repo.EventRepository;
import com.airtel.report.monitor.rest.MonitorController;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by sunny on 04/03/18.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class MonitorApplication {
    private final static Logger LOGGER = Logger.getLogger(MonitorApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(MonitorApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(EventRepository eventRepository) {
        return args -> {

            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Event>> typeReference = new TypeReference<List<Event>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/eventData.txt");
            try {
                List<Event> events = mapper.readValue(inputStream,typeReference);
                eventRepository.save(events);
                LOGGER.info(events.size() + " events available");
            } catch (IOException e){
                LOGGER.info("Unable to create json object: " + e.getMessage());
            }
        };
    }
}
