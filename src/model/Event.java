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

    public void readEvent(String title){
        try (BufferedReader br = new BufferedReader(new FileReader("src/model/txts/events.txt"))) {
            int count = -1;
            String line;
            while ((line = br.readLine()) != null) {
                if(line.equals(title) || (0 <= count && count < 3)){
                    if(count < 0){
                        this.title = line;
                    }
                    else{
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
                            default:
                            break;
                        }
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
        System.out.println(eventRead.getTitle());
        System.out.println(eventRead.getDescriptionEvent());
        System.out.println(eventRead.getDate());
        System.out.println(eventRead.getLocation());
        
        try {
            // 1. Leer el archivo a la memoria
            List<String> lines = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader("src/model/txts/events.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            }

            int count = -1;
            // 2. Modificar el contenido en la memoria
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).equals(eventRead.getTitle()) && count < 0) {
                    lines.set(i, this.title);
                    count++;
                }
                else if(lines.get(i).equals(eventRead.getDescriptionEvent()) && count == 0){
                    lines.set(i, this.description);
                    count++;
                }
                else if(lines.get(i).equals(eventRead.getDate()) && count == 1){
                    lines.set(i, this.date);
                    count++;
                }
                else if(lines.get(i).equals(eventRead.getLocation()) && count == 2){
                    lines.set(i, this.location);
                    count++;
                }
            }

            // 3. Reescribir el archivo con el nuevo contenido
            try (FileWriter fw = new FileWriter("src/model/txts/events.txt")) {
                for (String line : lines) {
                    fw.write(line + "\n");
                }
            }

            System.out.println("Archivo modificado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al modificar el archivo: " + e.getMessage());
        }
    }
}
