package org.adri.apinotaalta.controller;

import org.adri.apinotaalta.DTO.AltaInDTO;
import org.adri.apinotaalta.service.AltaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AltaController {

    private static final Logger LOG = LoggerFactory.getLogger(AltaController.class);
    private final AltaService altaService;

    //Constructor para que no se queje
    public AltaController(AltaService altaService) {
        this.altaService = altaService;
    }

    @PostMapping("/insert-note")
    public String testFirebase(@RequestBody AltaInDTO dataIn) throws Exception {
        LOG.debug("Datos de entrada {}",dataIn.toString());

        return altaService.guardarDato(dataIn);
    }
}
