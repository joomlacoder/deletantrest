package xyz.ignatev.deletantrest.service;

import xyz.ignatev.deletantrest.entity.Event;
import xyz.ignatev.deletantrest.entity.Sity;

import java.util.List;
import java.util.Map;

public interface SityService {

    Map<String, Map<Sity, List<Event>>> getSchedule();
}
