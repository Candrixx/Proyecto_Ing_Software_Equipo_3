package src.model;

import java.util.List;
import java.io.*;
import java.util.ArrayList;

public class Event {
    private String title = null;
    private String date = null;
    private String description = null;
    private String location = null;

    public Event(){
        this.title = null;
        this.date = null;
        this.description = null;
        this.location = null;
    }

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

    public void saveNewEvent(){
        List<String> lines = new ArrayList<String>();
        lines.add(title);
        lines.add(description);
        lines.add(date);
        lines.add(location);


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

    public void readEvent(String title){
        try (BufferedReader br = new BufferedReader(new FileReader("src/model/txts/events.txt"))) {
            int count = -1;
            String line;
            while ((line = br.readLine()) != null) {
                if(line == title || (0 <= count && count < 3)){
                    switch(count){
                        case 0:
                            this.description = line;
                        break;
                        case 1:
                            this.date = line;
                        break;
                        case 2:
                            this.location = line;
                        break;
                    }
                    count++;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void editDataEvent(){
        Event eventRead = new Event();
        eventRead.readEvent(this.title);
        try (BufferedReader br = new BufferedReader(new FileReader("src/model/txts/events.txt"));
             FileWriter fw = new FileWriter("src/model/txts/events.txt")) {

            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.equals(getTitle())) {
                    fw.write( this.title + "\n");
                }
                else if(linea.equals(getDescriptionEvent())){
                    fw.write( this.description + "\n");
                } 
                else if(linea.equals(getDate())){
                    fw.write( this.date + "\n");
                } 
                else if(linea.equals(getLocation())){
                    fw.write( this.location + "\n");
                } 
                else {
                    fw.write(linea + "\n");
                }
            }
            System.out.println("Archivo modificado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al modificar el archivo: " + e.getMessage());
        }
        
    }
}
