package com.pragra.learning.estore.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;
    private String username;
    private String Password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    @OneToOne (cascade = CascadeType.PERSIST)
    private Address address;



}
