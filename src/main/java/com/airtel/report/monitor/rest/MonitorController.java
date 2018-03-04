package com.airtel.report.monitor.rest;


import com.airtel.report.monitor.constants.MonitorConstant;
import com.airtel.report.monitor.service.MonitorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by sunny on 04/03/18.
 */
@RestController
@RequestMapping("/app")
public class MonitorController {
    private final static Logger LOGGER = Logger.getLogger(MonitorController.class.getName());

    @Autowired
    MonitorService monitorService;

    @ApiOperation(value = "View a list of unique events", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/events")
    public ResponseEntity getEventName() {
        Set<String> response = monitorService.getEventName();
        if(response == null) {
            LOGGER.info(MonitorConstant.DATA_NOT_AVAILABLE);
            return ResponseEntity.ok(MonitorConstant.DATA_NOT_AVAILABLE);
        }
        return ResponseEntity.ok(response);

    }

    @ApiOperation(value = "View a list of users by category and date", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/users")
    public ResponseEntity getUsersByCatDate(@RequestParam String category, @RequestParam String date) {
        Set<String> response = monitorService.getUsersByCatDate(category, date);
        if(response == null) {
            LOGGER.info(MonitorConstant.DATA_NOT_AVAILABLE);
            return ResponseEntity.ok(MonitorConstant.DATA_NOT_AVAILABLE);
        }
        return ResponseEntity.ok(response);

    }

    @ApiOperation(value = "View a list of users by day", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/user")
    public ResponseEntity getUsersByDay(@RequestParam String day) {
        Set<String> response = monitorService.getUsersByDay(day);
        if(response == null) {
            LOGGER.info(MonitorConstant.DATA_NOT_AVAILABLE);
            return ResponseEntity.ok(MonitorConstant.DATA_NOT_AVAILABLE);
        }
        return ResponseEntity.ok(response);

    }

    @ApiOperation(value = "View a list of users who dropped from payment", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/payment")
    public ResponseEntity getUsersByDroppedPayment(@RequestParam String day) {
        Set<String> response = monitorService.getUsersByDroppedPayment(day);
        if(response == null) {
            LOGGER.info(MonitorConstant.DATA_NOT_AVAILABLE);
            return ResponseEntity.ok(MonitorConstant.DATA_NOT_AVAILABLE);
        }
        return ResponseEntity.ok(response);

    }

    @ApiOperation(value = "View a conversion percentage", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/conversion")
    public ResponseEntity getConversionPercentage(@RequestParam String date) {
        double response = monitorService.getConversionPercentage(date);
        if(response == 0.0) {
            LOGGER.info(MonitorConstant.DATA_NOT_AVAILABLE);
            return ResponseEntity.ok(MonitorConstant.DATA_NOT_AVAILABLE);
        }
        return ResponseEntity.ok(String.format("%.2f", response) + "%");

    }

}
