package estudo.br.api.domain.paciente.dtos;

import estudo.br.api.annotations.Telefone;
import estudo.br.api.domain.medico.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
        @NotNull Long id,
        String nome,
        String email,
        @Telefone String telefone,
        DadosEndereco endereco) {
}
