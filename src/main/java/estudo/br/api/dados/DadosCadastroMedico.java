package estudo.br.api.dados;

import estudo.br.api.models.Especialidade;
import estudo.br.api.validations.Telefone;
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
        DadosEndereco endereco,
        @AssertTrue
        Boolean ativo
) {
}
