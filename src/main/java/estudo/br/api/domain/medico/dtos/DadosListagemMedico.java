package estudo.br.api.domain.medico.dtos;

import estudo.br.api.domain.medico.Especialidade;

public record DadosListagemMedico(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        Boolean ativo) {
}
