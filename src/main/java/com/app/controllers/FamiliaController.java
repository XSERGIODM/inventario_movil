package com.app.controllers;

import com.app.models.Familia;
import com.app.models.Marca;
import com.app.services.FamiliaService;
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
@RequestMapping("/familia")
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class FamiliaController {
    FamiliaService familiaService;
    MarcaService marcaService;
    @GetMapping("/")
    public String home() {
        return "redirect:/familia/show";
    }
    @GetMapping("/show")
    public String show(Model model) {
        model.addAttribute("familias", familiaService.findAll());
        return "familia/show";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("marcas", marcaService.findAll());
        return "familia/create";
    }
    @PostMapping("/save")
    public String save(Familia familia) {
        familiaService.save(familia);
        return "redirect:/familia/show";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("familia", familiaService.findById(id));
        model.addAttribute("marcas", marcaService.findAll());
        return "familia/edit";
    }
    @PostMapping("/update")
    public String update(Familia familia, Marca marca) {
        Marca marcaAux = marcaService.findById(marca.getMarca_id());
        Familia familiaAux = familiaService.findById(familia.getFamilia_id());
        familiaAux.setFamilia_marca(marcaAux);
        familiaAux.setFamilia_nombre(familia.getFamilia_nombre());
        familiaService.update(familiaAux);
        return "redirect:/familia/show";
    }
    @GetMapping("/deshabilitarHabilitar/{id}")
    public String deshabilitarHabilitar(@PathVariable(name = "id") Long id) {
        familiaService.deshabilitarHabilitar(id);
        return "redirect:/familia/show";
    }
}
