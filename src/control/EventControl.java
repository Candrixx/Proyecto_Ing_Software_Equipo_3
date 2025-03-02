package src.control;

import src.model.Event; 

public class EventControl {
    
    public EventControl(){
        
    }

    public void setDataEvent(String title, String date, String description, String location){
        Event event = new Event(title, date, description, location);
        event.editDataEvent();
    }

    public void addNewEvent(String title, String date, String description, String location){
        Event event = new Event(title, date, description, location);
        event.saveNewEvent();
    }
}
