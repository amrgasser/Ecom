package org.example.Auth.Controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.Auth.DTO.AddAddressDTO;
import org.example.Auth.Models.Address;
import org.example.Auth.Models.AppUser;
import org.example.Auth.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> findUser(@PathVariable Long id){
        return ResponseEntity.ok().body(userService.findUser(id));
    }
    @PostMapping("/register")
    public ResponseEntity<AppUser> registerNewUser(@RequestBody AppUser user){
        return ResponseEntity.ok().body(userService.saveUser(user));
    }
    @PostMapping("/add-address")
    public ResponseEntity<AppUser> addAddressToUser(@RequestBody AddAddressDTO addressDTO){

        return ResponseEntity.ok().body(userService.addAddressToUser(addressDTO));
    }
}
