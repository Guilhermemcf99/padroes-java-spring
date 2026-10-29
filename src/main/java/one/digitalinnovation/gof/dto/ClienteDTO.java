package one.digitalinnovation.gof.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ClienteDTO {

    @NotBlank(message = "O nome é obrigatório.")
    private String nome;

    @NotBlank(message = "O CEP é obrigatório.")
    @Pattern(regexp = "\d{8}", message = "O CEP deve conter exatamente 8 dígitos numéricos (ex: 01001000).")
    private String cep;

    public ClienteDTO() {
    }

    public ClienteDTO(String nome, String cep) {
        this.nome = nome;
        this.cep = cep;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
