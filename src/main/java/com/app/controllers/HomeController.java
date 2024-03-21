package com.app.controllers;

import com.app.models.Movil;
import com.app.services.MovilService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class HomeController {
    MovilService movilService;
    @GetMapping("/")
    public String home(Model model) {
        List<Movil> moviles = movilService.findAll();
        moviles.removeIf(movil -> !movil.getMovilEstado());
        model.addAttribute("moviles", moviles);
        return "home/home";
    }

    @GetMapping("/home")
    public String home2() {
        return "redirect:/";
    }
}
