package br.com.tech4me.pastelaria.model;
 
import java.util.List;
import br.com.tech4me.pastelaria.shared.PastelCompletoDTO;
import br.com.tech4me.pastelaria.shared.PastelDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(schema="pastelaria", name = "pastel")
public class Pastel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @JoinColumn(name="sabor-do-pastel")
    private String sabor;

    @JoinColumn(name = "ingrediente-dos-pasteis")
    private List<String> ingredientes;

    private Tamanho tamanho;

    private Tipo tipo;

    private Double valor;

    private Integer quantidade;

    public Pastel (){

    }

    public Pastel(PastelCompletoDTO dtc){
    setId(dtc.id());
    setSabor(dtc.sabor());
    setIngredientes(dtc.ingredientes());
    setTamanho(dtc.tamanho());
    setTipo(dtc.tipo());
    setValor(dtc.valor());
    setQuantidade(dtc.quantidade());
    }
   
     public Pastel(PastelDTO dto){
    setSabor(dto.sabor());
    setIngredientes(dto.ingredientes());
    setTamanho(dto.tamanho());
    setTipo(dto.tipo());
    setQuantidade(dto.quantidade());}
   
   
    public String getSabor() {
        return sabor;
    }
    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    public List<String> getIngredientes() {
        return ingredientes;
    }
    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }
    public Tamanho getTamanho() {
        return tamanho;
    }
    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
