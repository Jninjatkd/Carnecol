package Carnecol;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Controlador principal de la aplicación Carnecol
@Controller
public class HomeController {

    // Muestra la página de inicio
    @GetMapping("/")
    public String inicio() {
        return "index";
    }
}