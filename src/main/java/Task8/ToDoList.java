package Task8;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonSerialize(using= ToDoListSerializer.class)
@Table(name="ToDoLists")
public class ToDoList {
    @Id
    @GeneratedValue
    @Column(name="ID", nullable=false)
    private Long id;
    
    @JsonProperty("name")
    @Column(name="NAME")
    private String name;
    
    @JsonProperty("events")
    @OneToMany(mappedBy="toDoList", cascade=CascadeType.ALL, orphanRemoval = true)
    private List<Event> events;
    
    public ToDoList() {
    }
    
    public String getName() {
        return name;
    }
    
    public List<Event> getEvents() {
        return events;
    }
}
