package br.com.tech4me.pedido.shared;

import br.com.tech4me.pedido.model.Pastel;
import br.com.tech4me.pedido.model.Pedido;
import br.com.tech4me.pedido.model.TiposPagamento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PedidoCompletoDto(

        @NotNull String id,

        @NotBlank @Size(max = 100) 
        String nomeCliente,

        @NotBlank @Size(max = 12) 
        Integer telefone,

        @NotBlank @Size(max = 11) 
        String cpf,

        @NotNull Pastel pastel,

        TiposPagamento tiposPagamento) {

    public static PedidoCompletoDto from(Pedido pedido) {
        return new PedidoCompletoDto(pedido.getId(),
                pedido.getNomeCliente(),
                pedido.getTelefone(),
                pedido.getCpf(),
                pedido.getPastel(),
                pedido.getTiposPagamento());
    }

}
