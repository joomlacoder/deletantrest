package xyz.ignatev.deletantrest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ignatev.deletantrest.entity.Event;
import xyz.ignatev.deletantrest.entity.Sity;
import xyz.ignatev.deletantrest.repository.SityRepository;
import xyz.ignatev.deletantrest.service.SityService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SityServiceImpl implements SityService {
    @Autowired
    SityRepository sityRepository;
    @Autowired
    EventServiceImpl eventService;

    @Override
    public Map<String, Map<Sity, List<Event>>> getSchedule() {
        List<Event> allEvents = eventService.getAllEvents();
        Map<String, List<Event>> eventsMapMonth = allEvents.stream().collect(
                Collectors.groupingBy(event ->
                        event.getDateTime().getMonth().toString()
                )
        );

        Map<String, Map<Sity, List<Event>>> schedule = new HashMap<>();

        eventsMapMonth.forEach((x, y) -> {
            schedule.put(x, y.stream().collect(Collectors.groupingBy(Event::getSity)));
        });

        return schedule;
    }
}
