package org.example.Auth.DTO;

import lombok.Data;
import org.example.Auth.Models.Address;

@Data
public class AddAddressDTO {
    private String user_id;
    private Address address;
}
