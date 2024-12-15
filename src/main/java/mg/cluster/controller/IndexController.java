package mg.cluster.controller;



import jakarta.servlet.http.HttpSession;
import mg.cluster.model.Form_login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("form", new Form_login());
        return "index"; // Correspond au fichier index.html dans /templates
    }

    @PostMapping("/login")
    public String submitForm(@ModelAttribute Form_login form_login, HttpSession session, Model model) {
        // Ici, vous pouvez traiter les données du formulaire, les enregistrer en base de données, etc.
        // System.out.println("Nom soumis : " + form_login.getNom());
        session.setAttribute("nom", form_login.getNom());
        // Ajout de données dans le modèle, à afficher dans la vue après soumission
        model.addAttribute("submittedNom", form_login.getNom());

        // Retourner une vue de succès
        return "pages/loginSuccess";  // La vue 'loginSuccess.html' doit exister
    }
}
