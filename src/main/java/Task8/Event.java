package Task8;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

@Entity
@Table(name="Events")
public class Event {
    @Transient
    private Logger logger = LoggerFactory.getLogger(Event.class);
    
    @Id
    @GeneratedValue
    @Column(name="ID", nullable=false)
    private Long id;
    
    @Column(name="DESCRIPTION")
    public String description;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="event_id")
    private ToDoList toDoList;
    
    public Event() {
    }
    
    public Event(String description) {
        this.description = description;
        logger.info(description);
    }
}
