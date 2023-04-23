package ma.enset.controleJEE.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.controleJEE.enums.TypeAbonnement;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Abonnement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateAbonnement;
    @Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbonnement;

    private double solde;
    private double montantMensuel;
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;



}
