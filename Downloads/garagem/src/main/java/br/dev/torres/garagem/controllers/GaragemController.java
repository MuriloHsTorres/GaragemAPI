/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.torres.garagem.controllers;

import br.dev.torres.garagem.DTO.VeiculoDTO;
import br.dev.torres.garagem.service.GaragemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sesidevb
 */

@RestController
public class GaragemController {
    @Autowired
    private GaragemService garagemService;
    
    @GetMapping("/forsale")
    public List<VeiculoDTO> findAll(){
        List<VeiculoDTO> result = garagemService.findAll();
        return result;
    }
}