package com.pragra.learning.estore.repositories;


import com.pragra.learning.estore.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    //
}
