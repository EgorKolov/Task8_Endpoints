package Task8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ListsManager {
    @Autowired
    ToDoListRepository repository;
    
    @Transactional
    public void addList(ToDoList toDoList) {
        repository.save(toDoList);
    }
    
    @Transactional
    public List<ToDoList> getLists() {
        return repository.findAll();
    }
}
