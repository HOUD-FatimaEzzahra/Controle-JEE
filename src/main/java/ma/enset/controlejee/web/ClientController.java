package ma.enset.controleJEE.web;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.enset.controleJEE.entities.Client;
import ma.enset.controleJEE.services.ClientService;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;

    @GetMapping(path = "/user/index")
    public String clients(Model model,
                           @RequestParam(name = "page", defaultValue = "0")int page,
                           @RequestParam(name = "size", defaultValue = "5")int size,
                           @RequestParam(name = "motCle", defaultValue = "")String motCle){
        Page<Client> pageClients = clientService.searchClientsByKeyword(motCle, page, size);
        model.addAttribute("ListClients", pageClients.getContent());
        model.addAttribute("pages", new int[pageClients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("motCle", motCle);
        return "clients";
    }


    @GetMapping("/admin/delete")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(Long id, String motCle, int page){
        clientService.deleteClientById(id);
        return "redirect:/user/index?page="+page+"&motCle="+motCle;
    }

    @GetMapping("/admin/formulaireClient")
    @PreAuthorize("hasRole('ADMIN')")
    public String formulaireClient(Model model){
        model.addAttribute("client", new Client());
        return "formulaireClient";
    }

    @PostMapping(path = "/admin/save")
    @PreAuthorize("hasRole('ADMIN')")
    public String save(@Valid Client client, BindingResult bindingResult, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = " ") String motCle){
        if (bindingResult.hasErrors())
            return "formulaireClient";
        clientService.saveClient(client);
        return "redirect:/";
    }

    @GetMapping(path = "/admin/editClient")
    @PreAuthorize("hasRole('ADMIN')")
    public String editClient(Model model, Long id, String motCle, int page){
        Client client = clientService.findClientById(id);
        if(client == null)
            throw new RuntimeException("client introuvable");
        model.addAttribute("client", client);
        model.addAttribute("page", page);
        model.addAttribute("motCle", motCle);
        return "editClient";
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/user/index";
    }
}
