//Test usando JUnit
package src.test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import src.model.*;
import src.controllers.*;

public class testEvent {
    String title = "YU";
    String date = "85742398178";
    String description = "POLIMA";
    String location = "POI";

    @Test
    public void testsearchEvent(){
        Event event = new Event(title,date,description,location);
        EventControl eventControl = new EventControl();

        assertEquals(event.getTitle(), eventControl.searchEvent(title).getTitle());
        assertEquals(event.getDate(), eventControl.searchEvent(title).getDate());
        assertEquals(event.getDescriptionEvent(), eventControl.searchEvent(title).getDescriptionEvent());
        assertEquals(event.getLocation(), eventControl.searchEvent(title).getLocation());

    }

    @Test
    public void testReadEvent(){
        Event event = new Event(title,null,null,null);
        event.readEvent(title);

        assertEquals(description, event.getDescriptionEvent());
        assertEquals(date, event.getDate());
        assertEquals(location, event.getLocation());

    }
}