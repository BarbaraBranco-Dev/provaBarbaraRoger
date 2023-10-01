package br.com.tech4me.pastelaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.tech4me.pastelaria.server.PastelServerImpl;
import br.com.tech4me.pastelaria.shared.PastelCompletoDTO;
import br.com.tech4me.pastelaria.shared.PastelDTO;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/pastel")
public class PastelController {
    @Autowired

    PastelServerImpl servico;

    @GetMapping
   private ResponseEntity<List<PastelDTO>> obterPasteis(){
    return new ResponseEntity<>(servico.obterTodos(),HttpStatus.OK);
   }
 

   @PostMapping
   public ResponseEntity<PastelCompletoDTO> cadastrarPasteis(@RequestBody 
                                                                @Valid PastelCompletoDTO pastelCmpleto) {
       return new ResponseEntity<>(servico.cadastrar(pastelCmpleto),HttpStatus.CREATED);
   }
   
   @PutMapping("/{id}")
   private ResponseEntity<PastelCompletoDTO> atualizarPastelPorId(@PathVariable String id ,@RequestBody 
                                                                    @Valid PastelCompletoDTO pastelAtualizar){
    Optional <PastelCompletoDTO> atualizarPastal = servico.atualizarPorId(id, pastelAtualizar);
    if (atualizarPastal.isPresent()) {
        return new ResponseEntity<>(atualizarPastal.get(),HttpStatus.OK);
        
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }
   @GetMapping("/{id}")
   private ResponseEntity<PastelCompletoDTO> obterPastelPorId(@PathVariable String id ){
    
    if (servico.obterPorId(id).isPresent()) {
        return new ResponseEntity<>(servico.obterPorId(id).get(),HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }

   @DeleteMapping("/{id}")
   private ResponseEntity<PastelCompletoDTO> deletarPastel(@PathVariable String id,
                                                     @RequestBody  PastelCompletoDTO pastelCompleto){
    Optional <PastelCompletoDTO> deletarPastal = servico.deletarPorId(id, pastelCompleto);
    return new ResponseEntity<>(deletarPastal.get(),HttpStatus.NO_CONTENT);
   }
}
