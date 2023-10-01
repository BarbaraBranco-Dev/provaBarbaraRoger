package br.com.tech4me.pastelaria.server;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.pastelaria.shared.PastelCompletoDTO;
import br.com.tech4me.pastelaria.shared.PastelDTO;

public interface PastelServer {
    List<PastelDTO> obterTodos();
    PastelCompletoDTO cadastrar(PastelCompletoDTO pastel );
    Optional <PastelCompletoDTO> obterPorId(String id );
   Optional<PastelCompletoDTO> atualizarPorId(String id, PastelCompletoDTO dto );
    Optional<PastelCompletoDTO> deletarPorId(String id , PastelCompletoDTO pastelCompleto);
}
