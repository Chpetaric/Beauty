package net.javaguidance.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguidance.springboot.model.Usluga;

public interface UslugaRepository extends JpaRepository<Usluga, Long> {

}
