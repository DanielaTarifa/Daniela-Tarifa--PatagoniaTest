package com.example.patagoniatest.repository;

import com.example.patagoniatest.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    static Client findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }
}
