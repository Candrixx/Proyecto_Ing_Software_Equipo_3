package src.controllers;

import src.model.User;

public class UserControl {
    
    public void setUserData(String username, String career, String email, String password){

    }

    public void addNewUser(Integer userId, String email, String password){
        User user = new User(userId, email, password);
        user.saveNewUser();
    }
}
