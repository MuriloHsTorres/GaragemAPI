/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.dev.torres.garagem.repository;

import br.dev.torres.garagem.entities.Veiculo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sesidevb
 */
public interface GaragemRepository extends JpaRepository<Veiculo, Long>{
    
    List<Veiculo> findByCorIgnoreCase(String cor);
    
    List<Veiculo> findByAno(int ano);
    
}

   