package src.model;

import java.time.*;;

public class Event {
    private String title = null;
    private LocalDateTime date = null;
    private String description = null;
    private String location = null;


    public Event (String title, LocalDateTime date, String description, String location) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.location = location;
    }

    public String getTitle() {
        return this.title;
    }

    public LocalDateTime getDate(){
        return this.date;
    }

    public String getDescriptionEvent() {
        return this.description;
    }

    public void createNewEvent(Event event){
        
    }
}
