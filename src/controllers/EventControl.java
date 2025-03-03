package src.controllers;

import src.model.Event; 

public class EventControl {
    
    public void setDataEvent(String title, String date, String description, String location){
        Event event = new Event(title, date, description, location);
        event.editDataEvent();
    }

    public void addNewEvent(String title, String date, String description, String location){
        Event event = new Event(title, date, description, location);
        event.saveNewEvent();
    }

    //Experimental
    public Event searchEvent(String title){
        Event event = new Event(title,null,null,null);
        event.readEvent(title);
        return event;
    }
}
