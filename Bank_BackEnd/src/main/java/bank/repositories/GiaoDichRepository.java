package bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import bank.entiry.GiaoDich;

public interface GiaoDichRepository extends JpaRepository<GiaoDich, Integer> {
} 
