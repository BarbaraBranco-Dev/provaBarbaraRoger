package br.com.tech4me.pedido.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.tech4me.pedido.httpClient.PastelClient;
import br.com.tech4me.pedido.model.Pastel;
import br.com.tech4me.pedido.model.Pedido;
import br.com.tech4me.pedido.repository.PedidoRepository;
import br.com.tech4me.pedido.shared.PedidoCadastroDto;
import br.com.tech4me.pedido.shared.PedidoCompletoDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository repositorio;

    @Autowired
    private PastelClient pastelClient;

    @CircuitBreaker(name = "obterPastelPorId")
    @Override
    public PedidoCompletoDto cadastrarPedido(PedidoCadastroDto pedidoDto) {
        Pastel pastel = pastelClient.obterPastelPorId(pedidoDto.pastelId());
        Pedido pedido = Pedido.fromPedido(pedidoDto, pastel);
        repositorio.save(pedido);
        return PedidoCompletoDto.from(pedido);
    }

    @Override
    public PedidoCompletoDto obterPedidoPorId(String id) {
        return PedidoCompletoDto.from(repositorio.findById(id).get());
    }

    @Override
    public List<PedidoCompletoDto> obterTodosPedidos() {
        return repositorio.findAll().stream().map(pedido -> PedidoCompletoDto.from(pedido)).toList();
    }

    @CircuitBreaker(name = "obterPastelPorId")
    @Override
    public PedidoCompletoDto atualizarPedidoPorId(String id, PedidoCadastroDto pedidoDto) {
        Pedido pedido = repositorio.findById(id).get();

        if (pedidoDto.nomeCliente() != pedido.getNomeCliente()) {
            pedido.setNomeCliente(pedidoDto.nomeCliente());
        }

        if (pedidoDto.cpf() != pedido.getCpf()) {
            pedido.setCpf(pedidoDto.cpf());
        }

        if (pedidoDto.telefone() != pedido.getTelefone()) {
            pedido.setTelefone(pedidoDto.telefone());
        }

        if (pedido.getPastel().getId() != pedidoDto.pastelId()) {
            pedido.setPastel(pastelClient.obterPastelPorId(pedidoDto.pastelId()));
        }

        repositorio.save(pedido);

        return PedidoCompletoDto.from(pedido);
    }

    @Override
    public void excluirPedidoPorId(String id) {
        repositorio.deleteById(id);
    }

}
