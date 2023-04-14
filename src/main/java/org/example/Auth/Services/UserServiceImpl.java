package org.example.Auth.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.Auth.Builder.AppUserBuilder;
import org.example.Auth.DTO.AddAddressDTO;
import org.example.Auth.Models.Address;
import org.example.Auth.Models.AppUser;
import org.example.Auth.Models.Role;
import org.example.Auth.Repository.AddressRepository;
import org.example.Auth.Repository.AppUserRepository;
import org.example.Auth.Repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{
    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;
    private final AddressRepository addressRepository;

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving new User {} to database", user.getEmail());
        return appUserRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new Role {} to database", role.getRoleName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        log.info("Adding role {} to {} user", email, roleName);
        AppUser user = appUserRepository.findByEmail(email);
        Role role = roleRepository.findByRoleName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public AppUser findUser(Long id) {
        log.info("Fetching information for user {}", id);
        Optional<AppUser> appUser = appUserRepository.findById(id);
        return appUser.get();
    }

    @Override
    public AppUser addAddressToUser(AddAddressDTO addressDTO) {
        AppUser current = appUserRepository.findById(Long.valueOf(addressDTO.getUser_id())).get();
        Address address = addressRepository.save(addressDTO.getAddress());
        current.getAddressList().add(address);
        appUserRepository.save(current);
        return current;
    }
}
