package bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bank.entiry.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	Employee findByUserNameAndPassWord(String username,String Password);
	
}
