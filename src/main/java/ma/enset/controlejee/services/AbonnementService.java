package ma.enset.controleJEE.services;

import ma.enset.controleJEE.entities.Abonnement;
import ma.enset.controleJEE.entities.Client;
import ma.enset.controleJEE.repositories.AbonnementRepository;
import ma.enset.controleJEE.repositories.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbonnementService implements IAbonnementService{
    public AbonnementRepository abonnementRepository;


    public AbonnementService(AbonnementRepository abonnementRepository) {
        this.abonnementRepository = abonnementRepository;
    }

    @Override
    public List<Abonnement> findAllAbonnements() {
        return abonnementRepository.findAll();
    }

    @Override
    public Abonnement findAbonnementById(Long id) {
        return abonnementRepository.findById(id).orElse(null);
    }

    @Override
    public Abonnement saveAbonnement(Abonnement abonnement) {
        return abonnementRepository.save(abonnement);
    }

    @Override
    public void deleteAbonnementById(Long id) {
        abonnementRepository.deleteById(id);
    }

    @Override
    public Page<Abonnement> searchAbonnementByKeyword(String keyword, int page, int size) {
        return abonnementRepository.findByTypeAbonnementContains(keyword, PageRequest.of(page, size));

    }

}
