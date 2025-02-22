package src.controllers;

import src.model.User;

public class UserControl {

    public boolean isUser(String email, String password){
        User user = new User();
        return user.isUser(email, password);
    }
    
    public void setUserData(Integer userId, String email, String password){
        User user = new User(userId, email, password);
        user.editUserData();
    }

    public void addNewUser(Integer userId, String email, String password){
        User user = new User(userId, email, password);
        user.saveNewUser();
    }
}
