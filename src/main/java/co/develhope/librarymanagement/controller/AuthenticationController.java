package co.develhope.librarymanagement.controller;

import co.develhope.librarymanagement.inventory.entities.Employee;
import co.develhope.librarymanagement.model.DTO.SignupActivationDTO;
import co.develhope.librarymanagement.model.DTO.SignupDTO;
import co.develhope.librarymanagement.model.entities.User;
import co.develhope.librarymanagement.services.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private SignupService signupService;

    @PostMapping("/signup")
    public User signup(@RequestBody SignupDTO signupDTO) throws Exception {
        return signupService.signup(signupDTO);
    }
    @PostMapping("/signup/activation")
    public User signup(@RequestBody SignupActivationDTO signupActivationDTO) throws Exception {
        return signupService.activate(signupActivationDTO);
    }
    @PostMapping("/signup/employee")
    public Employee signupEmployee(@RequestBody SignupDTO signupDTO) throws Exception {
        return signupService.employeeSignup(signupDTO);
    }
    @PostMapping("/signup/employee/activation")
    public Employee signupEmployee(@RequestBody SignupActivationDTO signupActivationDTO) throws Exception {
        return signupService.activeEmployee(signupActivationDTO);
    }
}
