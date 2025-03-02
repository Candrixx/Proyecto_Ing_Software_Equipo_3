package src.control;

import src.model.User;
import src.inter.RegisterUI;

public class UserControl {

    private User user;
    public RegisterUI registerUI;

    public boolean isUser(String email, String password){
        User user = new User();
        return this.user.isUser(email, password);
    }
    
    public void setUserData(Integer userId, String email, String password){
        User user = new User(userId, email, password);
        this.user.editUserData();
    }

    public void addNewUser(Integer userId, String email, String password){
        User user = new User(userId, email, password);
        this.user.saveNewUser();
    }

    public static void main(String[] args){
        registerUI.setVisible(true);
        registerUI.setLocationRelativeTo(null);
    }
}
