package com.kay.Tikkit.repositories;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kay.Tikkit.entity.Country;
import com.kay.Tikkit.entity.State;

public interface StateRepository extends JpaRepository<State, Long> {

    Optional<State> findByStateName(String stateName);
    List<State> findByCountry(Country country);
    List<State> findByCountryAndIsActiveTrue(Country country);
    List<State> findByIsActiveTrue();
    boolean existsByStateName(String stateName);
    boolean existsByCountry(Country country);
}
