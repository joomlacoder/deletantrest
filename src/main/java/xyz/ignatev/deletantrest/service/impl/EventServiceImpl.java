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

        Event event = new Event();
        Author author = new Author();
        author.setName("Maer");
        event.addAuthor(author);
        event.setName("TEst");
        event.setDateTime(LocalDateTime.now());
        event.setLocation("xz xyz");
        event.setDescription("sssssssss");
        Sity sity = new Sity();
        sity.setName("WQwq");
        sity.addEvent(event);
        eventRepository.save(event);


        return eventRepository.findAll();
    }

}
