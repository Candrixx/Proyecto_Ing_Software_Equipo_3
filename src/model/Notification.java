package src.model;

import java.sql.Date;

public class Notification {
    private Integer announcement = null;
    private Event event = null;
    private Date date = null;

    public Notification (Integer announcement, Event event, Date date) {
        this.announcement = announcement;
        this.event = event;
        this.date = date;
    }

    
}
