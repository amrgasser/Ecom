package org.example.Auth.Services;

import org.example.Auth.DTO.AddAddressDTO;
import org.example.Auth.Models.Address;
import org.example.Auth.Models.AppUser;
import org.example.Auth.Models.Role;

public interface UserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String email, String roleName);
    AppUser findUser(Long id);
    AppUser addAddressToUser(AddAddressDTO addressDTO);
}
