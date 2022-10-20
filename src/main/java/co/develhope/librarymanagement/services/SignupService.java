package co.develhope.librarymanagement.services;

import co.develhope.librarymanagement.inventory.entities.Employee;
import co.develhope.librarymanagement.inventory.repositories.EmployeeRepository;
import co.develhope.librarymanagement.library.repositories.UserRepository;
import co.develhope.librarymanagement.model.DTO.SignupActivationDTO;
import co.develhope.librarymanagement.model.DTO.SignupDTO;
import co.develhope.librarymanagement.model.entities.Role;
import co.develhope.librarymanagement.model.entities.User;
import co.develhope.librarymanagement.notification.MailNotificationService;
import co.develhope.librarymanagement.repositories.RoleRepository;
import co.develhope.librarymanagement.utils.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class SignupService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private MailNotificationService mailNotificationService;

    public User signup(SignupDTO signupDTO) throws Exception {
        User userInDB = userRepository.findByEmail(signupDTO.getEmail());
        if(userInDB != null) throw new Exception("User already Exists");
        User user = new User();
        user.setName(signupDTO.getName());
        user.setEmail(signupDTO.getEmail());
        user.setSurname(signupDTO.getSurname());
        user.setPassword(passwordEncoder.encode(signupDTO.getPassword()));
        user.setActivationCode(UUID.randomUUID().toString());

        Set<Role> roles = new HashSet<>();
        Optional<Role> userRole = roleRepository.findByName(Roles.REGISTERED);
        if(!userRole.isPresent()) throw  new Exception("Cannot set role");
        roles.add(userRole.get());
        user.setRoles(roles);

        mailNotificationService.sendActivationEmail(user);
        return userRepository.save(user);
    }
    public User activate(SignupActivationDTO signupActivationDTO) throws Exception {
        User user = userRepository.findByActivationCode(signupActivationDTO.getActivationCode());
        if(user == null) throw new Exception("User Not found");
        user.setActive(true);
        user.setActivationCode(null);
        return userRepository.save(user);
    }

    public Employee employeeSignup(SignupDTO signupDTO) throws Exception {
        Employee employeeInDB = employeeRepository.findByEmail(signupDTO.getEmail());
        if(employeeInDB != null) throw new Exception("User already Exists");
        Employee employee = new Employee();
        employee.setName(signupDTO.getName());
        employee.setSurname(signupDTO.getSurname());
        employee.setEmail(signupDTO.getEmail());
        employee.setPassword(passwordEncoder.encode(signupDTO.getPassword()));
        employee.setActivationCode(UUID.randomUUID().toString());

        Set<Role> roles = new HashSet<>();
        Optional<Role> employeeRole = roleRepository.findByName(Roles.CUSTOMER);
        if(!employeeRole.isPresent()) throw new Exception("Cannot set role");
        roles.add(employeeRole.get());
        employee.setRoles(roles);

        mailNotificationService.sendActivationEmailForEmployee(employee);
        return employeeRepository.save(employee);
    }
    public Employee activeEmployee(SignupActivationDTO signupActivationDTO) throws Exception {
        Employee employee = employeeRepository.findByActivationCode(signupActivationDTO.getActivationCode());
        if(employee == null) throw new Exception("User Not found");
        employee.setActive(true);
        employee.setActivationCode(null);
        return employeeRepository.save(employee);

    }


}
