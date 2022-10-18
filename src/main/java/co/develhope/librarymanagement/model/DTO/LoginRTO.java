package co.develhope.librarymanagement.model.DTO;

import co.develhope.librarymanagement.model.entities.User;
import lombok.Data;

@Data
public class LoginRTO {

    private User user;
    private String JWT;
}
