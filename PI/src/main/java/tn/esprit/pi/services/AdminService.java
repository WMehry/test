package tn.esprit.pi.services;

import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.pi.dto.requests.RegisterRequest;
import tn.esprit.pi.entities.User;
import tn.esprit.pi.repositories.UserRepository;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class AdminService implements IAdminService{
    private final PasswordEncoder passwordEncoder ;

    UserRepository userRepository;
    @Override
    public List<User> getAll() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);

    }

    @Override
    public void register(RegisterRequest request) throws MessagingException {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .registrationDate(new Date())
                .enabled(true)
                .build() ;

        userRepository.save(user) ;
    }


}


