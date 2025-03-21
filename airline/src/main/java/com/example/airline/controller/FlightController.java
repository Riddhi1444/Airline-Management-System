package com.example.airline.controller;

import com.example.airline.model.Flight;
import com.example.airline.model.Schedule;
import com.example.airline.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping
    public List<Flight> getAllFlights(@RequestParam(required = false) String sort) {
        return flightService.getAllFlights(sort);
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }

    @GetMapping("/{id}/schedules")
    public List<Schedule> getFlightSchedules(@PathVariable Long id,
                                             @RequestParam(required = false) String dates) {
        Flight flight = flightService.getFlightById(id);
        // Add date filtering logic if dates parameter is provided
        return flight.getSchedules();
    }
}