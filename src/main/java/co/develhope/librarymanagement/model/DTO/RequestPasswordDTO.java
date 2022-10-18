package co.develhope.librarymanagement.model.DTO;

public class RequestPasswordDTO {

    String email;

    public RequestPasswordDTO(){}

    public RequestPasswordDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
