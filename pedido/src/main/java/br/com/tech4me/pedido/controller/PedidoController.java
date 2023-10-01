package br.com.tech4me.pedido.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.tech4me.pedido.service.PedidoService;
import br.com.tech4me.pedido.shared.PedidoCadastroDto;
import br.com.tech4me.pedido.shared.PedidoCompletoDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping("/{id}")
    public ResponseEntity<PedidoCompletoDto> obterPedidoPorId(@PathVariable(value = "id") String id) {
        return ResponseEntity.ok(service.obterPedidoPorId(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<PedidoCompletoDto>> obterTodosPedidos() {
        return ResponseEntity.ok(service.obterTodosPedidos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoCompletoDto> atualizarPedidoPorId(@PathVariable(value = "id") @Valid String id,
            @RequestBody PedidoCadastroDto pedidoCadastroDto) {
        return new ResponseEntity<>(service.atualizarPedidoPorId(id, pedidoCadastroDto), HttpStatus.OK);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<PedidoCompletoDto> cadastrarPedido(@RequestBody @Valid PedidoCadastroDto pedidoCadastroDto) {
        return new ResponseEntity<>(service.cadastrarPedido(pedidoCadastroDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirPedidoPorId(@PathVariable(value = "id") String id) {
        service.excluirPedidoPorId(id);
        return new ResponseEntity<>("Pedido deletado com sucesso!", HttpStatus.OK);
    }
}