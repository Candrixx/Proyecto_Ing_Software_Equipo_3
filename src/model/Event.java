package src.model;

import java.time.*;
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Event {
    private String title = null;
    private String date = null;
    private String description = null;
    private String location = null;


    public Event (String title, String date, String description, String location) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.location = location;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDate(){
        return this.date;
    }

    public String getDescriptionEvent() {
        return this.description;
    }

    public String getLocation() {
        return this.location;
    }

    public void createNewEvent(Event event){
        List<String> lines = new ArrayList<String>();
        lines.add(title);
        lines.add(description);
        lines.add(date);
        lines.add(location);
        lines.add("\n");


        File file = new File("src/model/txts/events.txt");
        try{
            if(file.exists()){
                System.out.println("Existe");
                try (FileWriter fileWrite = new FileWriter("src/model/txts/events.txt",true))
                {
                    PrintWriter pw = new PrintWriter(fileWrite);

                    for (int i = 0; i < lines.size(); i++)
                        pw.println(lines.get(i));

                } catch (Exception e) {
                    e.printStackTrace();
                } 
            }
            else {
                System.out.println("NO Existe");
                try (FileWriter fileWrite = new FileWriter("src/model/txts/events.txt"))
                {
                    PrintWriter pw = new PrintWriter(fileWrite);

                    for (int i = 0; i < lines.size(); i++)
                        pw.println(lines.get(i));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        catch(Exception e){
            System.err.println("ERROR");
        }
    }
}
