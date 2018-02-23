package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Rendezvous;

@Repository
public interface RendezvousRepository extends JpaRepository<Rendezvous, Integer>{

	@Query("select r from Rendezvous r join r.comment c where c.id=?1")
	Rendezvous findRendezvousByComment(int id);
	
}
