package one.digitalinnovation.gof.service;

import org.springframework.stereotype.Component;
import one.digitalinnovation.gof.model.Endereco;

@Component
public class ViaCepFallback implements ViaCepService {

    @Override
    public Endereco consultarCep(String cep) {
        Endereco enderecoDesconhecido = new Endereco();
        enderecoDesconhecido.setCep(cep);
        enderecoDesconhecido.setLogradouro("Endereço indisponível (Serviço ViaCEP temporariamente inoperante)");
        enderecoDesconhecido.setBairro("N/A");
        enderecoDesconhecido.setLocalidade("Desconhecida");
        enderecoDesconhecido.setUf("UF");
        return enderecoDesconhecido;
    }
}
