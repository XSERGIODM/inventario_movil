package com.app.controllers;

import com.app.models.Color;
import com.app.services.ColorService;
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
@RequestMapping("/color")
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class ColorController {
    ColorService colorService;

    @GetMapping("/")
    public String home() {
        return "redirect:/color/show";
    }

    @GetMapping("/show")
    public String show(Model model) {
        model.addAttribute("colores", colorService.findAll());
        return "color/show";
    }

    @GetMapping("/create")
    public String create() {
        return "color/create";
    }

    @PostMapping("/save")
    public String save(Color color) {
        colorService.save(color);
        return "redirect:/color/show";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable ("id") Long id, Model model) {
        model.addAttribute("color", colorService.findById(id));
        return "color/edit";
    }

    @PostMapping("/update")
    public String update(Color color) {
        colorService.update(color);
        return "redirect:/color/show";
    }

    @GetMapping("/deshabilitarHabilitar/{id}")
    public String delete(@PathVariable("id") Long id) {
        colorService.deshabilitarHabilitar(id);
        return "redirect:/color/show";
    }
}
