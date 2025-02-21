package src.controllers;
// uwu

import java.sql.Date;
import src.model.Notification;
import src.model.Event; 
import java.sql.Date;

public class NotificationControl {
    public void searchNotification(int id){
        
    }

    public void setNotification(int id, Event event){
        Notification notification = new Notification(id, event);
        //event.createNewEvent(event); help
    }
}
