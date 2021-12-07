package bank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import bank.entiry.TKGuiTien;


@Repository
public interface TKGuiTienRepository extends JpaRepository<TKGuiTien,String>{
	@Query("select t from TKGuiTien t where t.customer.id=?1")
	public TKGuiTien getTKGuiTienbyCustomer(int id);
}
