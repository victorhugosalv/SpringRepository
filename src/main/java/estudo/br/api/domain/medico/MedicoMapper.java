package estudo.br.api.domain.medico;

import estudo.br.api.domain.medico.dtos.DadosDetalhamentoMedico;
import estudo.br.api.domain.medico.endereco.EnderecoMapper;
import estudo.br.api.domain.medico.dtos.DadosCadastroMedico;
import estudo.br.api.domain.medico.dtos.DadosListagemMedico;

public class MedicoMapper {

    public static Medico toEntity(DadosCadastroMedico dados) {
        Medico medico = new Medico();
        medico.setNome(dados.nome());
        medico.setEmail(dados.email());
        medico.setTelefone(dados.telefone());
        medico.setCrm(dados.crm());
        medico.setEspecialidade(dados.especialidade());
        medico.setEndereco(EnderecoMapper.toEndereco(dados.endereco()));
        medico.setAtivo(true); // O padrão ao cadastrar é sempre true
        return medico;
    }

    public static DadosCadastroMedico toDadosCadastro(Medico medico) {
        return new DadosCadastroMedico(
                medico.getNome(),
                medico.getEmail(),
                medico.getTelefone(),
                medico.getCrm(),
                medico.getEspecialidade(),
                EnderecoMapper.toDados(medico.getEndereco())
        );
    }

    public static DadosListagemMedico toDadosListagem(Medico medico) {
        return new DadosListagemMedico(
                medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getCrm(),
                medico.getEspecialidade(),
                medico.getAtivo()
        );
    }

    public static DadosDetalhamentoMedico toDadosDetalhamento(Medico medico){
        return new DadosDetalhamentoMedico(
                medico.getId(),
                medico.getNome(),
                medico.getEmail(),
                medico.getTelefone(),
                medico.getCrm(),
                medico.getEspecialidade(),
                EnderecoMapper.toDados(medico.getEndereco()),
                medico.getAtivo()
        );
    }


}
