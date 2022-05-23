package Task8;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ToDoListSerializer extends StdSerializer<ToDoList> {
    public ToDoListSerializer() {
        this(null);
    }
    
    protected ToDoListSerializer(Class<ToDoList> t) {
        super(t);
    }
    
    @Override
    public void serialize(ToDoList toDoList, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) 
            throws IOException {
        
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name", toDoList.getName());
        jsonGenerator.writeFieldName("events");
        jsonGenerator.writeStartArray();
        for (var event : toDoList.getEvents()) {
            jsonGenerator.writeString(event.description);
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
    
}
