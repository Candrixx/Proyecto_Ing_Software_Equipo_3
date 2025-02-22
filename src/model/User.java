package src.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class User {
    private Integer userId;
    private String email;
    private String password;

    public User(){
        this.userId = null;
        this.email = null;
        this.password = null;
    }

    public User(Integer userId, String email, String password){
        this.userId = userId;
        this.email = email;
        this.password = password;
    }

    public Integer getUserId(){
        return this.userId;
    }
    public String getPassword(){
        return this.password;
    }
    public String getUserEmail(){
        return this.email;
    }

    public boolean isUser(String email, String password){
        try (BufferedReader br = new BufferedReader(new FileReader("src/model/txts/users.txt"))) {
            boolean findUser = false;
            String line;
            while ((line = br.readLine()) != null) {
                if(line.equals(email) && !findUser){
                 findUser = true; 
                }
                else if(findUser){
                    if(line.equals(password)) return true;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return false;
    }

    public void readUser(String email){
        try (BufferedReader br = new BufferedReader(new FileReader("src/model/txts/users.txt"))) {
            int count = -1;
            String line;
            while ((line = br.readLine()) != null) {
                if(line.equals(email) || (0 <= count && count < 2)){
                    if(count < 0){
                        this.email = line;
                    }
                    else{
                        switch(count){
                            case 0:
                                this.password = line;
                            break;
                            case 1:
                                this.userId = Integer.parseInt(line);
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

    public void editUserData(){
        User userRead = new User();
        userRead.readUser(this.email);

        try {
            // 1. Leer el archivo a la memoria
            List<String> lines = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader("src/model/txts/users.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            }

            int count = -1;
            // 2. Modificar el contenido en la memoria
            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).equals(userRead.getUserEmail()) && count < 0) {
                    lines.set(i, this.email);
                    count++;
                }
                else if(lines.get(i).equals(userRead.getPassword()) && count == 0){
                    lines.set(i, this.password);
                    count++;
                }
                else if(lines.get(i).equals(userRead.getUserId().toString()) && count == 1){
                    lines.set(i, this.userId.toString());
                    count++;
                }
            }

            // 3. Reescribir el archivo con el nuevo contenido
            try (FileWriter fw = new FileWriter("src/model/txts/users.txt")) {
                for (String line : lines) {
                    fw.write(line + "\n");
                }
            }

            System.out.println("Archivo modificado exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al modificar el archivo: " + e.getMessage());
        }
    }

    public void saveNewUser(){
         List<String> lines = new ArrayList<String>();
        lines.add(email);
        lines.add(password);
        lines.add(userId.toString());
        lines.add("\n");


        File file = new File("src/model/txts/users.txt");
        try{
            if(file.exists()){
                System.out.println("Existe");
                try (FileWriter fileWrite = new FileWriter("src/model/txts/users.txt",true))
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
                try (FileWriter fileWrite = new FileWriter("src/model/txts/users.txt"))
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
