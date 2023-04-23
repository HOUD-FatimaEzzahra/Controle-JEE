package ma.enset.controleJEE.repositories;

import ma.enset.controleJEE.entities.Abonnement;
import ma.enset.controleJEE.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {
    Page<Abonnement> findByTypeAbonnementContains(String mc, Pageable pageable );
}
