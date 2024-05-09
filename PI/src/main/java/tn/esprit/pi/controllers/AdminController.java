package tn.esprit.pi.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pi.dto.requests.RegisterRequest;
import tn.esprit.pi.dto.responses.MessageResponse;
import tn.esprit.pi.entities.User;
import tn.esprit.pi.services.IAdminService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {
    private final IAdminService iServices;

    @GetMapping("/get/all")
    public List<User> getAll() {
        return iServices.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void removeUser(@PathVariable Integer id) {
        iServices.delete(id);
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {

        try {
            iServices.register(request) ;
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage())) ;
        }
        return ResponseEntity.ok()
                .body(new MessageResponse("user added"));
    }

}