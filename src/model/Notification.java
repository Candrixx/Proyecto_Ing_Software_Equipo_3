package src.model;

import src.model.Event;
import java.sql.Date;


public class Notification {
    private Integer notificationId = null;
    private Event event = null;

    public Notification (Integer notificationId, Event event) {
        this.notificationId = notificationId;
        this.event = event;
    }

    /*public Date getDateNotification(){
    }*/

    public Event getEventNotification(){
        return this.event;
    }

    public Integer getNotificationID(){
        return this.notificationId;
    }

}
