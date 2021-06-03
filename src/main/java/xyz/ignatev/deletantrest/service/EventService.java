package xyz.ignatev.deletantrest.service;

import org.springframework.stereotype.Service;
import xyz.ignatev.deletantrest.entity.Event;

import java.util.List;

@Service
public interface EventService {

    List<Event> getAllEvents();
}
