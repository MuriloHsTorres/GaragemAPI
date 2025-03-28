/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.dev.torres.garagem.service;

import br.dev.torres.garagem.DTO.VeiculoDTO;
import br.dev.torres.garagem.entities.Veiculo;
import br.dev.torres.garagem.repository.GaragemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sesidevb
 */

@Service
public class GaragemService {
    
   @Autowired
   
   private GaragemRepository garagemRepository;
   
    public List<VeiculoDTO> findAll(){

        List<Veiculo> resultVeiculo = garagemRepository.findAll();
        List<VeiculoDTO> resultDTO = resultVeiculo.stream()
                .map(x -> new VeiculoDTO(x)).toList();
        return resultDTO;

    }
}
