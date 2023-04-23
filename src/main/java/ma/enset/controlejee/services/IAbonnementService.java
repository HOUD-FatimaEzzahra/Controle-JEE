package ma.enset.controleJEE.services;

import ma.enset.controleJEE.entities.Abonnement;
import ma.enset.controleJEE.entities.Client;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IAbonnementService {
    List<Abonnement> findAllAbonnements();

    Abonnement findAbonnementById(Long id);

    Abonnement saveAbonnement(Abonnement abonnement);

    void deleteAbonnementById(Long id);
    Page<Abonnement> searchAbonnementByKeyword(String keyword, int page, int size);
}
