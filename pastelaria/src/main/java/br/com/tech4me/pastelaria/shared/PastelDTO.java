package br.com.tech4me.pastelaria.shared;

import java.util.List;
import br.com.tech4me.pastelaria.model.Pastel;
import br.com.tech4me.pastelaria.model.Tamanho;
import br.com.tech4me.pastelaria.model.Tipo;

public record PastelDTO(String sabor,
    List<String>ingredientes,
    Tamanho tamanho,
    Tipo tipo,
    Double valor,
    Integer quantidade ) {


    public static PastelDTO fromPastelDTO(Pastel pastel){
        
        return new PastelDTO(
        pastel.getSabor(),
        pastel.getIngredientes(),
        pastel.getTamanho(),
        pastel.getTipo(),
        pastel.getValor(),
        pastel.getQuantidade()); 

    }
    
}
