package src.model;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class User {
    private Integer userId;
    private String email;
    private String password;

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

    public boolean isUser(){
        return true;
    }

    public void editUserData(){

    }

    public void saveNewUser(){
         List<String> lines = new ArrayList<String>();
        lines.add(userId.toString());
        lines.add(email);
        lines.add(password);
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
