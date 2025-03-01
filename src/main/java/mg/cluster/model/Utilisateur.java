package mg.cluster.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="utilisateur")
public class Utilisateur {

    @Id @Column (name="id_utilisateur")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @Column (name="nom", nullable=false) 
    private String nom;
    @Column (name="mail", nullable=false)
    String mail; 
    @Column (name="mdp", nullable=false) 
    private String motpasse;



    // Getter et Setter pour le nom
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getMotpasse() {
        return motpasse;
    }
    public void setMotpasse(String motpasse) {
        this.motpasse = motpasse;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }
}
