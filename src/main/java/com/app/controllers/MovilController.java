package com.app.controllers;

import com.app.models.*;
import com.app.services.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/movil")
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class MovilController {

    MovilService movilService;
    MarcaService marcaService;
    FamiliaService familiaService;
    ModeloService modeloService;
    ColorService colorService;
    UploadFileService uploadFileService;
    UbicacionService ubicacionService;
    ContextoService contextoService;

    @GetMapping("/")
    public String home() {

        return "redirect:/movil/show";
    }

    @GetMapping("/show")
    public String show(Model model) {
        model.addAttribute("moviles", movilService.findAll());
        log.info("hola mundo");
        return "movil/show";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("marcas", marcaService.findAll());
        List<Color> colores = colorService.findAll();
        colores.removeIf(color -> !color.getColor_estado());
        model.addAttribute("colores", colores);
        List<Ubicacion> ubicaciones = ubicacionService.findAll();
        ubicaciones.removeIf(ubicacion -> !ubicacion.getUbicacion_estado());
        model.addAttribute("ubicaciones", ubicaciones);
        return "movil/create";
    }

    @PostMapping("/save")
    public String save(Movil movil, Moodelo modelo, @RequestParam("img") MultipartFile file, Contexto contexto) throws IOException {
        Moodelo modeloAux = modeloService.findById(modelo.getModelo_id());
        movil.setMovil_modelo(modeloAux);
        movil.setMovil_imagen(uploadFileService.saveImage(file));
        if (movilService.save(movil) != null) {
            contexto.setContexto_movil(movil);
            contexto.setContexto_estado(true);
            contexto.setContexto_fecha_entrada(LocalDateTime.now());
            contextoService.save(contexto);
            return "redirect:/movil/show";
        } else {
            return "redirect:/movil/create";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("movil", movilService.findById(id));
        model.addAttribute("marcas", marcaService.findAll());
        model.addAttribute("familias", familiaService.findAll());
        model.addAttribute("modelos", modeloService.findAll());
        List<Color> colores = colorService.findAll();
        colores.removeIf(color -> !color.getColor_estado());
        model.addAttribute("colores", colores);
        return "movil/edit";
    }

    @PostMapping("/update")
    public String update(Movil movil, Moodelo modelo, @RequestParam("img") MultipartFile file) throws IOException {
        Moodelo modeloAux = modeloService.findById(modelo.getModelo_id());
        movil.setMovil_modelo(modeloAux);
        if (file.isEmpty()) {
            Movil movil1 = movilService.findById(movil.getMovil_id());
            movil.setMovil_imagen(movil1.getMovil_imagen());
        } else {
            log.info("imagen: " + movil.getMovil_imagen());
            uploadFileService.deleteImage(movil.getMovil_imagen());
            movil.setMovil_imagen(uploadFileService.saveImage(file));
            log.info("imagen: " + movil.getMovil_imagen());
        }
        movilService.update(movil);
        return "redirect:/movil/show";
    }

    @GetMapping("/getFamiliasByMarca/{marcaId}")
    public ResponseEntity<List<Familia>> getFamiliasByMarca(@PathVariable Long marcaId) {
        Marca marca = marcaService.findById(marcaId);
        return ResponseEntity.ok(marca.getFamilias());
    }

    @GetMapping("/getModelosByFamilia/{familiaId}")
    public ResponseEntity<List<Moodelo>> getModelosByFamilia(@PathVariable Long familiaId) {
        Familia familia = familiaService.findById(familiaId);
        return ResponseEntity.ok(familia.getModelos());
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("movil", movilService.findById(id));
        List<Ubicacion> ubicaciones = ubicacionService.findAll();
        ubicaciones.removeIf(ubicacion -> !ubicacion.getUbicacion_estado());
        model.addAttribute("ubicaciones", ubicaciones);
        Contexto contextoActual = new Contexto();
        for (Contexto contexto : movilService.findById(id).getContextos()) {
            if (contexto.getContexto_estado()) {
                contextoActual = contexto;
            }
        }
        model.addAttribute("contextoActual", contextoActual);
        return "movil/info";
    }
    @PostMapping("/searchProduct")
    public String searchProduct(@RequestParam String nombre , Model model) {
        List<Movil> listaMovil = movilService.buscarMovil(nombre);
        model.addAttribute("listamovil", listaMovil);
        return "home/home";
    }
}
