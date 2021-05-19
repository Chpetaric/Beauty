package net.javaguidance.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguidance.springboot.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
