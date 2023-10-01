package br.com.tech4me.pedido.model;

import br.com.tech4me.pedido.shared.PedidoCadastroDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "pastelaria", name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nomeCliente;

    private Integer telefone;

    private String cpf;

    private TiposPagamento tiposPagamento;

    @JoinColumn(name = "id_pastel")
    @OneToOne
    private Pastel pastel;

    public static Pedido fromPedido(PedidoCadastroDto pedidoDto, Pastel pastel) {
        Pedido pedido = new Pedido();
        pedido.setNomeCliente(pedidoDto.nomeCliente());
        pedido.setTelefone(pedidoDto.telefone());
        pedido.setCpf(pedidoDto.cpf());
        pedido.setTiposPagamento(pedidoDto.tiposPagamento());
        pedido.setPastel(pastel);
        return pedido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public TiposPagamento getTiposPagamento() {
        return tiposPagamento;
    }

    public void setTiposPagamento(TiposPagamento tiposPagamento) {
        this.tiposPagamento = tiposPagamento;
    }

    public Pastel getPastel() {
        return pastel;
    }

    public void setPastel(Pastel pastel) {
        this.pastel = pastel;
    }

}
