package estudo.br.api.dados;

import estudo.br.api.models.Endereco;
import estudo.br.api.validations.Telefone;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
        @NotNull Long id,
        String nome,
        String email,
        @Telefone String telefone,
        Endereco endereco) {
}
