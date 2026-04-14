package estudo.br.api.domain.paciente.dtos;

public record DadosListagemPaciente(
        Long id,
        String nome,
        String email,
        String cpf,
        Boolean ativo) {
}
