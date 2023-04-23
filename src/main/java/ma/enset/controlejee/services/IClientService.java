package ma.enset.controleJEE.services;

import ma.enset.controleJEE.entities.Client;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IClientService {

    List<Client> findAllClients();

    Client findClientById(Long id);

    Client saveClient(Client client);

    void deleteClientById(Long id);

    Page<Client> searchClientsByKeyword(String keyword, int page, int size);
}
