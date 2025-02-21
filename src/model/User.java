package src.model;

public class User {
    private Integer userId;
    private String username;
    private String career;
    private String email;
    private String password;

    public Integer getUserId(){
        return this.userId;
    }
    public String getUserName(){
        return this.username;
    }
    public String getUserCareer(){
        return this.career;
    }
    public String getPassword(){
        return this.password;
    }
    public String getUserEmail(){
        return this.email;
    }

    public void editUserData(){

    }

    public void saveNewUser(){
        
    }
}
