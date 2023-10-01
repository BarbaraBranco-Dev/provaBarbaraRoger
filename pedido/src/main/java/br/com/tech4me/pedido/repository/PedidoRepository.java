package br.com.tech4me.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.tech4me.pedido.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, String> {

}
