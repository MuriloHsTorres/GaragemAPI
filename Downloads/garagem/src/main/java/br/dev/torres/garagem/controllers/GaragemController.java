/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.torres.garagem.controllers;

import br.dev.torres.garagem.DTO.VeiculoDTO;
import br.dev.torres.garagem.entities.Veiculo;
import br.dev.torres.garagem.service.GaragemService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/forsale/{id}")
    public ResponseEntity<Veiculo> findByIgnoreCase (@PathVariable long id) {
        Optional<Veiculo> resultOptional = garagemService.findById(id);
    
        if (resultOptional.isPresent()) {
            Veiculo garagem = resultOptional.get();
            
            return ResponseEntity.ok(garagem);
        } else {
            return ResponseEntity.notFound().build();
        }    
    }
    
    @GetMapping("/color/{cor}")
    public ResponseEntity<List<VeiculoDTO>> findByCorIgnoreCase (@PathVariable String cor){
        List<VeiculoDTO> result = garagemService.findByCor(cor);
        
        if(result.isEmpty()){
            return ResponseEntity.notFound().build();
        } else { 
            return ResponseEntity.ok(result);
        }
        
    }
    
    @GetMapping("/ano/{ano}")
    public ResponseEntity<List<VeiculoDTO>> findByAno (@PathVariable int ano){
        List<VeiculoDTO> result = garagemService.findByAno(ano);
        
        if(result.isEmpty()){
            return ResponseEntity.notFound().build();
        } else { 
            return ResponseEntity.ok(result);
        }
    }
}