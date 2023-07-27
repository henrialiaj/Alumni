package com.example.alumnimanager.connection.repository;


import com.example.alumnimanager.connection.model.entity.ConnectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConnectionRepository extends JpaRepository<ConnectionEntity, Integer> {

}
