package br.com.tech4me.pedido.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tech4me.pedido.model.Pastel;

@FeignClient("pastelaria")
public interface PastelClient {

    @RequestMapping(method = RequestMethod.GET, value = "/pasteis/{id}")
    Pastel obterPastelPorId(@PathVariable String id);
}
