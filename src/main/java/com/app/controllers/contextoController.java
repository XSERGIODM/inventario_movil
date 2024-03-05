package com.app.controllers;

import com.app.models.Contexto;
import com.app.services.ContextoService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contexto")
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class contextoController {
    ContextoService contextoService;

    @PostMapping("/save")
    public String save(Contexto contexto) {
        log.info(" controlador Contexto 1:  " + contexto.getContexto_movil());
        contextoService.update(contexto);
        log.info("controlador Contexto 2:  " + contexto);
        contextoService.save(contexto);
        log.info("Contexto 3:  " + contexto);
        return "redirect:/movil/info/" + contexto.getContexto_movil().getMovil_id() ;
    }
}
