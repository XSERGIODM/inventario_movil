package com.app.controllers;

import com.app.models.Ubicacion;
import com.app.services.UbicacionService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ubicacion")
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class UbicacionController {

    UbicacionService ubicacionService;

    @GetMapping("/")
    public String home() {
        return "redirect:/ubicacion/show";
    }

    @GetMapping("/show")
    public String show(Model model) {
        model.addAttribute("ubicaciones", ubicacionService.findAll());
        return "ubicacion/show";
    }

    @GetMapping("/create")
    public String create() {
        return "ubicacion/create";
    }

    @PostMapping("/save")
    public String save(Ubicacion ubicacion) {
        ubicacionService.save(ubicacion);
        return "redirect:/ubicacion/show";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("ubicacion", ubicacionService.findById(id));
        return "ubicacion/edit";
    }

    @PostMapping("/update")
    public String update(Ubicacion ubicacion) {
        ubicacionService.update(ubicacion);
        return "redirect:/ubicacion/show";
    }

    @GetMapping("/deshabilitarHabilitar/{id}")
    public String delete(@PathVariable("id") Long id) {
        ubicacionService.deshabilitarHabilitar(id);
        return "redirect:/ubicacion/show";
    }

    @GetMapping("/ubicaciones")
    public ResponseEntity<List<Ubicacion>> getUbicaciones() {
        List<Ubicacion> ubicaciones = ubicacionService.findAll();
        ubicaciones.removeIf(ubicacion -> !ubicacion.getUbicacionEstado());
        return ResponseEntity.ok(ubicaciones);
    }
}
