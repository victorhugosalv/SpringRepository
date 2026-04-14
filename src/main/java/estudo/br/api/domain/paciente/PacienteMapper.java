package estudo.br.api.domain.paciente;

import estudo.br.api.domain.medico.endereco.EnderecoMapper;
import estudo.br.api.domain.paciente.dtos.DadosCadastroPaciente;
import estudo.br.api.domain.paciente.dtos.DadosDetalhamentoPaciente;
import estudo.br.api.domain.paciente.dtos.DadosListagemPaciente;

public class PacienteMapper {

    public static Paciente toEntity(DadosCadastroPaciente dados) {
        Paciente paciente = new Paciente();
        paciente.setNome(dados.nome());
        paciente.setEmail(dados.email());
        paciente.setTelefone(dados.telefone());
        paciente.setCpf(dados.cpf());
        paciente.setEndereco(EnderecoMapper.toEndereco(dados.endereco()));
        paciente.setAtivo(true); // O padrão ao cadastrar é sempre true
        return paciente;
    }

    public static DadosCadastroPaciente toDadosCadastro(Paciente paciente) {
        return new DadosCadastroPaciente(
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getTelefone(),
                paciente.getCpf(),
                EnderecoMapper.toDados(paciente.getEndereco())
        );
    }

    public static DadosListagemPaciente toDadosListagem(Paciente paciente) {
        return new DadosListagemPaciente(
                paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getCpf(),
                paciente.getAtivo()
        );
    }

    public static DadosDetalhamentoPaciente toDadosDetalhamento(Paciente paciente){
        return new DadosDetalhamentoPaciente(
                paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getTelefone(),
                paciente.getCpf(),
                EnderecoMapper.toDados(paciente.getEndereco()),
                paciente.getAtivo()
        );
    }
}
