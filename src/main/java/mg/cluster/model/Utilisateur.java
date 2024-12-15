package mg.cluster.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "utilisateur")
public class Utilisateur {

    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id @Column (name = "id_utilisateur") private int id;
    @Column (name = "nom", nullable = false) private String nom; 
    @Column (name = "mdp", nullable = false) private String mdp;



    // Getter et Setter pour le nom
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getMdp() { return mdp; }
    public void setMdp(String mdp) { this.mdp = mdp; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

}
