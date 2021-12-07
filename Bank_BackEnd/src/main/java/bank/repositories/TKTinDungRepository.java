package bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import bank.entiry.TKTinDung;

@Repository
public interface TKTinDungRepository extends JpaRepository<TKTinDung,String>{
	@Query("select t from TKTinDung t where t.customer.id=?1")
	public TKTinDung getTkTinDungbyCustomer(int id);
}
