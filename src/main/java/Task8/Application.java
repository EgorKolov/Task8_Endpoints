package Task8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@SpringBootApplication
@Controller
public class Application {
    @Autowired
    private ListsManager manager;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    // for some reason it doesn't work with curl (it corrupts the encoding if the russian symbols are present)
    // postman requests work fine
    @PostMapping(value="/api/add", consumes="application/json;charset=UTF-8")
    public ResponseEntity<Void> addToDoList(@RequestBody ToDoList toDoList) {
        manager.addList(toDoList);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @GetMapping("/api/get") 
    public ResponseEntity<List<ToDoList>> getToDoLists() {
        return new ResponseEntity<>(manager.getLists(), HttpStatus.OK);
    }
}
