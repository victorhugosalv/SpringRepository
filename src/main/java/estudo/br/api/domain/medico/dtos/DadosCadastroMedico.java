package estudo.br.api.domain.medico.dtos;

import estudo.br.api.domain.medico.endereco.DadosEndereco;
import estudo.br.api.annotations.Telefone;
import estudo.br.api.domain.medico.Especialidade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

//@NotBlank apenas para Strings

public record DadosCadastroMedico(
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Telefone
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid
        DadosEndereco endereco
) {
}
