package ma.enset.controleJEE.repositories;

import ma.enset.controleJEE.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Page<Client> findByNomContains(String mc, Pageable pageable );
}
