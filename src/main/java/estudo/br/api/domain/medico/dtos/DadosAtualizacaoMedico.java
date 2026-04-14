package estudo.br.api.domain.medico.dtos;

import estudo.br.api.domain.medico.endereco.DadosEndereco;
import estudo.br.api.annotations.Telefone;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
        @NotNull Long id,
        String nome,
        String email,
        @Telefone String telefone,
        DadosEndereco endereco) {
}
