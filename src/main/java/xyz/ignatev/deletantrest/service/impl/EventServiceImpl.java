package xyz.ignatev.deletantrest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.ignatev.deletantrest.entity.Author;
import xyz.ignatev.deletantrest.entity.Event;
import xyz.ignatev.deletantrest.entity.Sity;
import xyz.ignatev.deletantrest.repository.EventRepository;
import xyz.ignatev.deletantrest.service.EventService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

}
