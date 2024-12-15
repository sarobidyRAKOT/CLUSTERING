package mg.cluster.controller;



import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mg.cluster.model.Utilisateur;
import mg.cluster.repository.UtilisateurRepository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {


    @Autowired
    private UtilisateurRepository utilisateurRepository;



    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("form", new Utilisateur());
        return "index"; // Correspond au fichier index.html dans /templates
    }


    @PostMapping("/login")
    public String submitForm(@ModelAttribute Utilisateur u, HttpSession session, Model model) {

        Utilisateur user = utilisateurRepository.findByNomAndMdp(u.getNom(), u.getMdp());

        if (user != null) {
            session.setAttribute("nom", user.getNom());
            // System.out.println(session.getAttribute("nom"));

            model.addAttribute("nom", session.getAttribute("nom"));
            return "pages/loginSuccess";            
        } else {
            return "redirect:/";
        }

    }
}
