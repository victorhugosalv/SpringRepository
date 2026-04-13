package estudo.br.api.models;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.util.Optional;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    public void atualizaDados(Endereco endereco) {
        Optional.ofNullable(endereco.logradouro).ifPresent(logradouro -> this.logradouro = logradouro);
        Optional.ofNullable(endereco.bairro).ifPresent(bairro -> this.bairro = bairro);
        Optional.ofNullable(endereco.cep).ifPresent(cep -> this.cep = cep);
        Optional.ofNullable(endereco.cidade).ifPresent(cidade -> this.cidade = cidade);
        Optional.ofNullable(endereco.uf).ifPresent(uf -> this.uf = uf);
        Optional.ofNullable(endereco.numero).ifPresent(numero -> this.numero = numero);
        Optional.ofNullable(endereco.complemento).ifPresent(complemento -> this.complemento = complemento);
    }
}
