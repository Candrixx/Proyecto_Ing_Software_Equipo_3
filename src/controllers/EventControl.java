package src.controllers;

import java.time.LocalDateTime;

import src.model.Event; 

public class EventControl {
    public void setDataEvent(String title, LocalDateTime date, String description, String location){

    }

    public void addNewEvent(String title, String date, String description, String location){
        Event event = new Event(title, date, description, location);
        event.createNewEvent(event);
    }
}
