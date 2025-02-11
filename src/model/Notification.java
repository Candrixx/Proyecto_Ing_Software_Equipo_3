package src.model;

import src.model.Event;
<<<<<<< HEAD
import java.sql.Date;
=======
>>>>>>> 3a3ffd47e44cf9f40a94bf8da4d509aca6e8a020

public class Notification {
    private Integer notificationId = null;
    private Event event = null;

    public Notification (Integer notificationId, Event event) {
        this.notificationId = notificationId;
        this.event = event;
    }

    public Date getDateNotification(){
        return this.event.getDate();
    }

    public Event getEventNotification(){
        return this.event;
    }

    public Integer getNotificationID(){
        return this.notificationId;
    }

}
