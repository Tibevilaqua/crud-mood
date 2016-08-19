package bevila.tiago.service;

import bevila.tiago.domain.User;
import bevila.tiago.endpoint.dto.ManagedUserDTO;
import bevila.tiago.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Service class for managing users.
 */
@Service
public class UserService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);



    @Inject
    private UserRepository userRepository;





    public User createUserInformation(String login, String password, String firstName, String lastName, String email) {

        User newUser = new User();

        newUser.setLogin(login);
        // new user gets initially a generated password
        newUser.setPassword(password);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);

        userRepository.save(newUser);
        log.debug("Created Information for User: {}", newUser);
        return newUser;
    }

    public User createUser(ManagedUserDTO managedUserDTO) {
        User user = new User();
        user.setLogin(managedUserDTO.getLogin());
        user.setFirstName(managedUserDTO.getFirstName());
        user.setLastName(managedUserDTO.getLastName());
        user.setEmail(managedUserDTO.getEmail());

        user.setPassword(managedUserDTO.getPassword());
        userRepository.save(user);
        log.debug("Created Information for User: {}", user);
        return user;
    }



    public void deleteUserInformation(String login) {
        userRepository.findOneByLogin(login).ifPresent(u -> {
            userRepository.delete(u);
            log.debug("Deleted User: {}", u);
        });
    }
}
