package co.develhope.librarymanagement.model.DTO;

public class ActivationDTO {

    private String activationCode;

    public ActivationDTO() {
    }

    public ActivationDTO(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }
}
