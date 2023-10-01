package br.com.tech4me.pastelaria.server;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.pastelaria.model.Pastel;
import br.com.tech4me.pastelaria.repository.RepositoryPastel;
import br.com.tech4me.pastelaria.shared.PastelCompletoDTO;
import br.com.tech4me.pastelaria.shared.PastelDTO;
@Service
public class PastelServerImpl implements PastelServer{
    @Autowired
    RepositoryPastel repositorio;

    

    @Override
    public List<PastelDTO> obterTodos() {
       return repositorio.findAll().stream().
       map( p -> PastelDTO.fromPastelDTO(p) ).toList();
    }

    @Override
    public PastelCompletoDTO cadastrar(PastelCompletoDTO pastel) {
      Pastel pastelCadastro = new Pastel(pastel);
       repositorio.save(pastelCadastro);
       return PastelCompletoDTO.fromPastelCompletoDTO(pastelCadastro);
    }

    @Override
    public Optional<PastelCompletoDTO> obterPorId(String id ) {
        Optional<Pastel> pastel = repositorio.findById(id);
        if (pastel.isPresent()) {
        return Optional.of( PastelCompletoDTO.fromPastelCompletoDTO(pastel.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<PastelCompletoDTO> atualizarPorId(String id, PastelCompletoDTO dto) {
     Optional<Pastel> pastel = repositorio.findById(id);

     if (pastel.isPresent()) {
        Pastel atualizar = new Pastel(dto);
        repositorio.save(atualizar);
        return Optional.of( PastelCompletoDTO.fromPastelCompletoDTO(pastel.get()));
     }
     return Optional.empty();
    }
    
    @Override
    public Optional<PastelCompletoDTO> deletarPorId(String id, PastelCompletoDTO pastelCompleto) {
      Optional<Pastel> pastel = repositorio.findById(id);
      if (pastel.isPresent()) {
         repositorio.deleteById(id);
         return Optional.of(( PastelCompletoDTO.fromPastelCompletoDTO(pastel.get())));
      }
      return Optional.empty();
    }
}
