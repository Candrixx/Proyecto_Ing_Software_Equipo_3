//Test usando JUnit
package src.test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import src.controllers.UserControl;
import src.model.User;;


public class testUser {

    private Integer userId = 7484654;
    private String email = "klkkjhhkjf@er";
    private String password = "polima";

    
    @Test //Si el usuario existe en la base de datos
    public void testIsUser(){
        User user = new User();

        assertEquals(true, user.isUser(email,password));

    }

    @Test
    public void testReadUser(){
        User user = new User();
        user.readUser(email);

        assertEquals(password, user.getPassword());
        assertEquals(userId, user.getUserId());
    }

}