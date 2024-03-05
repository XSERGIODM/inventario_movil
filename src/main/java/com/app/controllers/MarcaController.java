package com.app.controllers;

import com.app.models.Marca;
import com.app.services.MarcaService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/marca")
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class MarcaController {
    MarcaService marcaService;

    @GetMapping("/")
    public String home() {
        return "redirect:/marca/show";
    }

    @GetMapping("/show")
    public String show(Model model) {
        model.addAttribute("marcas", marcaService.findAll());
        return "marca/show";
    }

    @GetMapping("/create")
    public String create() {
        return "marca/create";
    }

    @PostMapping("/save")
    public String save(Marca marca) {
        marcaService.save(marca);
        return "redirect:/marca/show";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("marca", marcaService.findById(id));
        return "marca/edit";
    }

    @PostMapping("/update")
    public String update(Marca marca) {
        marcaService.update(marca);
        return "redirect:/marca/show";
    }

    @GetMapping("/deshabilitarHabilitar/{id}")
    public String deshabilitarHabilitar(@PathVariable(name = "id") Long id) {
        marcaService.deshabilitarHabilitar(id);
        return "redirect:/marca/show";
    }

}
