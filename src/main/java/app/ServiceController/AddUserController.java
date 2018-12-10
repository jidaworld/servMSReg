package app.ServiceController;

import Businesslayer.Handlers.UserHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityExistsException;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@RestController
public class AddUserController {

    private UserHandler userHandler = new UserHandler();

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public void addUser(@Valid @RequestBody AddUserObj obj) {
        try {
            userHandler.addUser(obj.username, obj.password, obj.email, obj.name, obj.lastname);
        } catch (EntityExistsException e) {
            throw e;
        }
    }

    private static class AddUserObj{
        @JsonProperty
        @NotEmpty
        private String username;
        @JsonProperty
        @NotEmpty
        private String password;
        @JsonProperty
        @NotEmpty
        private String email;
        @JsonProperty
        @NotEmpty
        private String name;
        @JsonProperty
        @NotEmpty
        private String lastname;

        @Override
        public String toString() {
            return "AddUserObj{" +
                    ", password='" + password + '\'' +
                    ", email='" + email + '\'' +
                    ", name='" + name + '\'' +
                    ", lastname='" + lastname + '\'' +
                    '}';
        }
    }
}
