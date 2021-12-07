package bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bank.entiry.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

}
