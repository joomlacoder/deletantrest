package xyz.ignatev.deletantrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.ignatev.deletantrest.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
