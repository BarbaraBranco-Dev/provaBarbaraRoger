package br.com.tech4me.pedido.shared;

import br.com.tech4me.pedido.model.TiposPagamento;

public record PedidoCadastroDto(

        String nomeCliente,
        Integer telefone,
        String cpf,
        String pastelId,
        TiposPagamento tiposPagamento) {

}
