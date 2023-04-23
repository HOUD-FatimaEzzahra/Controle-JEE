package ma.enset.controleJEE;

import ma.enset.controleJEE.entities.Client;
import ma.enset.controleJEE.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class MainClasse {

    public static void main(String[] args) {
        SpringApplication.run(MainClasse.class, args);
    }

   /* @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository) {
        return args -> {

            for (int i = 0; i < 10; i++) {
                clientRepository.save(
                        new Client(3+i, "ALAMI", "Hiba", "fatiza@gmail.com", "alami.hiba"));
            }

            clientRepository.findAll().forEach(p -> {
                System.out.println(p.getNom() + " " + p.getPrenom());
            });
        };
    }*/



    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
