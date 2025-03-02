package mg.cluster.repository;

import mg.cluster.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    Utilisateur findByMailAndMotpasse(String email, String motpasse);
    Utilisateur findByNomAndMail (String nom, String mail);
}
    