package estudo.br.api.dados;

import estudo.br.api.models.Especialidade;

public record DadosListagemMedico(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        Boolean ativo) {
}
