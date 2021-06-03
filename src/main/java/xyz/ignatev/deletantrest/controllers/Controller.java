package xyz.ignatev.deletantrest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ignatev.deletantrest.entity.Event;
import xyz.ignatev.deletantrest.entity.Sity;
import xyz.ignatev.deletantrest.service.EventService;
import xyz.ignatev.deletantrest.service.SityService;

import java.util.List;
import java.util.Map;

@RestController
public class Controller {
    @Autowired
    EventService eventService;
    @Autowired
    SityService sityService;

    @GetMapping("/slider")
    ResponseEntity<List<Event>> getSlider() {
        return new ResponseEntity<>(eventService.getAllEvents(), HttpStatus.OK);
    }

    @GetMapping("/schedule")
    ResponseEntity<Map<String, Map<Sity, List<Event>>>> getSchedule() {
        return new ResponseEntity<>(sityService.getSchedule(), HttpStatus.OK);
    }
}
