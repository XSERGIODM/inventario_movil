package com.app.controllers;

import com.app.models.Familia;
import com.app.models.Marca;
import com.app.models.Moodelo;
import com.app.services.FamiliaService;
import com.app.services.MarcaService;
import com.app.services.ModeloService;
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
@RequestMapping("/modelo")
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class ModeloContreller {
    ModeloService modeloService;
    MarcaService marcaService;
    FamiliaService familiaService;

    @GetMapping("/")
    public String home() {
        return "redirect:/modelo/show";
    }
    @GetMapping("/show")
    public String show(Model model) {
        model.addAttribute("modelos", modeloService.findAll());
        return "modelo/show";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("marcas", marcaService.findAll());
        model.addAttribute("familias", familiaService.findAll());
        return "modelo/create";
    }
    @PostMapping("/save")
    public String save(Moodelo modelo) {
        modeloService.save(modelo);
        return "redirect:/modelo/show";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("modelo", modeloService.findById(id));
        model.addAttribute("familias", familiaService.findAll());
        model.addAttribute("marcas", marcaService.findAll());
        return "modelo/edit";
    }
    @PostMapping("/update")
    public String update(Moodelo modelo, Familia familia) {
        log.info("Modelo: " + modelo.getModelo_id());
        log.info("Familia: " + familia.getFamilia_id());
        Familia familiaAux = familiaService.findById(familia.getFamilia_id());
        modelo.setModelo_familia(familiaAux);
        modeloService.update(modelo);
        return "redirect:/modelo/show";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        modeloService.deleteById(id);
        return "redirect:/modelo/show";
    }
    @GetMapping("/deshabilitarHabilitar/{id}")
    public String deshabilitarHabilitar(@PathVariable(name = "id") Long id) {
        modeloService.deshabilitarHabilitar(id);
        return "redirect:/modelo/show";
    }
    @GetMapping("/getFamiliasByMarca/{marcaId}")
    public ResponseEntity<List<Familia>> getFamiliasByMarca(@PathVariable Long marcaId) {
        Marca marca = marcaService.findById(marcaId);
        return ResponseEntity.ok(marca.getFamilias());
    }
}
