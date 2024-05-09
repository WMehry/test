package tn.esprit.pi.services;

import jakarta.mail.MessagingException;
import tn.esprit.pi.dto.requests.RegisterRequest;
import tn.esprit.pi.entities.User;

import java.util.List;

public interface IAdminService {
    List<User> getAll();
    void delete(Integer id);
    public void register(RegisterRequest request) throws MessagingException;
}