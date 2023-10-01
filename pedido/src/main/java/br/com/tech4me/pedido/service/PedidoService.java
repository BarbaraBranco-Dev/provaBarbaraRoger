package br.com.tech4me.pedido.service;

import java.util.List;
import br.com.tech4me.pedido.shared.PedidoCadastroDto;
import br.com.tech4me.pedido.shared.PedidoCompletoDto;

public interface PedidoService {

    PedidoCompletoDto cadastrarPedido(PedidoCadastroDto pedidoDto);

    PedidoCompletoDto obterPedidoPorId(String id);

    List<PedidoCompletoDto> obterTodosPedidos();

    PedidoCompletoDto atualizarPedidoPorId(String id, PedidoCadastroDto pedidoDto);

    void excluirPedidoPorId(String id);

}
