package estudo.br.api.domain.medico.dtos;

import estudo.br.api.domain.medico.Especialidade;
import estudo.br.api.domain.medico.endereco.DadosEndereco;

public record DadosDetalhamentoMedico(
        Long id,
        String nome,
        String email,
        String telefone,
        String crm,
        Especialidade especialidade,
        DadosEndereco endereco,
        Boolean ativo
) {
}
