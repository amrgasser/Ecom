package org.example.Auth.Controllers;

import lombok.AllArgsConstructor;
import org.example.Auth.Models.Role;
import org.example.Auth.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
@AllArgsConstructor
public class RoleController {
    private final UserService userService;
    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        return ResponseEntity.ok().body(userService.saveRole(role));
    }

//    @GetMapping
//    public ResponseEntity<Role> getRoles(){
//        return ResponseEntity.ok().body(userService.);
//    }
}
