package xyz.ignatev.deletantrest.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Sity {
    @Id
    @ApiModelProperty("Long - unique id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "sity")
    @JsonIgnoreProperties()
    private List<Event> events = new ArrayList<>();
    private String urlImgLogo;

    public void addEvent(Event event) {
        events.add(event);
        event.setSity(this);
    }
}
