package Businesslayer.Handlers;

import Businesslayer.Entities.UserEntity;
import Datalayer.DBHandler.DBHandler;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.EntityExistsException;

public class UserHandler {

    private DBHandler DBHandler;

    public UserHandler() {
        this.DBHandler = new DBHandler();
    }

    public void addUser(String username, String password, String email, String name, String lastname){

        UserEntity user = new UserEntity();
        String hash = BCrypt.hashpw(password, BCrypt.gensalt());
        user.setPassword(hash);
        user.setUserName(username);
        user.setPassword(hash);
        user.setEmail(email);
        user.setName(name);
        user.setLastName(lastname);

        try {
            DBHandler.addUser(user);
        } catch (EntityExistsException e){
            throw e;
        }
    }
}
