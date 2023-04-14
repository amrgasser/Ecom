package org.example.Auth.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String unitNumber;
    private String street;
    private String addressLine1;
    private String addressLine2;
    @ManyToOne
    private City city;
    private String region;
    private String postal_code;
    private String mapCoords;
    @ManyToOne
    private Country country;

}
