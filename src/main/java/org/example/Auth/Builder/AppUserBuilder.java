package org.example.Auth.Builder;

import org.example.Auth.Models.AppUser;
import org.example.Auth.Models.Role;

import java.util.ArrayList;
import java.util.List;

public class AppUserBuilder {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private List<Role> roles = new ArrayList<Role>();
    public AppUserBuilder setEmail(String email){
       this.email = email;
       return this;
    }
    public AppUserBuilder setFirstName(String firstname){
        this.firstName = firstname;
        return this;
    }

    public AppUserBuilder setLastName(String lastName){
        this.lastName = lastName;
        return this;
    }
    public AppUserBuilder setPassword(String password){
        this.password = password;
        return this;
    }
    public AppUserBuilder addRole(Role role){
        this.roles.add(role);
        return this;
    }
    public AppUserBuilder addRoles(List<Role> roles){
        this.roles.addAll(roles);
        return this;
    }

    public AppUser build(){
        AppUser newUser = new AppUser();
        newUser.setEmail(email);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setPassword(password);
        newUser.setRoles(roles);

        return newUser;
    }
}
