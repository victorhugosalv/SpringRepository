package estudo.br.api.domain.paciente.dtos;

import estudo.br.api.domain.medico.endereco.DadosEndereco;

public record DadosDetalhamentoPaciente(
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        DadosEndereco endereco,
        Boolean ativo
) {
}
