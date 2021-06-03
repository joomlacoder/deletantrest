package xyz.ignatev.deletantrest.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Event {
    @Id
    @ApiModelProperty("Long - unique id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ApiModelProperty("String - event name")
    private String name;
    private String description;
    private LocalDateTime dateTime;
    private String urlImgLogo;
    private String urlImgBg;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Author> authors = new HashSet<>();
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Sity sity;
    private String location;

    public void addAuthor(Author author) {
        authors.add(author);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                '}';
    }
}
