package mg.cluster.controller;


import jakarta.servlet.http.HttpSession;
import mg.cluster.model.Utilisateur;
import mg.cluster.repository.UtilisateurRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {


    @Autowired
    private UtilisateurRepository utilisateurRepository;



    @GetMapping("/")
    public ModelAndView homePage() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("Utilisateur", new Utilisateur());
        mv.addObject("contenu", "pages/login"); // Chemin correct
        return mv;
    }



    @PostMapping("/login")
    public String login (@ModelAttribute Utilisateur u, HttpSession session, Model model) {


        Utilisateur user = utilisateurRepository.findByMailAndMotpasse(u.getMail(), u.getMotpasse());

        if (user != null) {
            session.setAttribute("user", user);

            model.addAttribute("User", (Utilisateur) session.getAttribute("user"));
            System.out.println("MISY");
            model.addAttribute("contenu", "pages/loginSuccess");      
            return "index";
        } else {
            return "redirect:/";
        }

    }


    @PostMapping("/incrire")
    public String inscription (@ModelAttribute Utilisateur u, HttpSession session, Model model) {


        Utilisateur user = utilisateurRepository.findByNomAndMail(u.getNom(), u.getMail());

        if (user != null) {
            // System.out.println("MISY");
            return "redirect:/";
        } else {
            user = (Utilisateur) utilisateurRepository.save(u);
            session.setAttribute("user", user);
            
            model.addAttribute("User", (Utilisateur) session.getAttribute("user"));
            model.addAttribute("contenu", "pages/loginSuccess");      
            return "index";
        }

    }
}
