package br.com.tech4me.pastelaria.shared;

import java.util.List;
import br.com.tech4me.pastelaria.model.Pastel;
import br.com.tech4me.pastelaria.model.Tamanho;
import br.com.tech4me.pastelaria.model.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PastelCompletoDTO(String id,
    @NotBlank(message = "Ola o campo deve ser preechido")
    @NotEmpty(message = "Ola o sabor nao foi informado")
    String sabor,
    List<String>ingredientes,
    @NotNull(message = "ola este campo dever ser informado ")
    Tamanho tamanho,
    @NotNull(message = "ola este campo dever ser informado ")
    Tipo tipo,
    @NotNull(message = "ola este campo dever ser informado ")
    @NotBlank(message = "Ola o campo deve ser preechido")
    Double valor,
    @NotNull(message = "ola este campo dever ser informado ")
    @NotEmpty(message = "Ola o quantidade nao foi informado")
    Integer quantidade 
 ) {
    public static PastelCompletoDTO fromPastelCompletoDTO (Pastel pastel){

            return new PastelCompletoDTO( 
            pastel.getId(),
            pastel.getSabor(),
            pastel.getIngredientes()
            ,pastel.getTamanho()
            ,pastel.getTipo(),
            pastel.getValor()
            ,pastel.getQuantidade());

    }
    
}
