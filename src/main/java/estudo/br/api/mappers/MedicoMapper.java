package estudo.br.api.mappers;

import estudo.br.api.dados.DadosCadastroMedico;
import estudo.br.api.dados.DadosListagemMedico;
import estudo.br.api.models.Medico;

public class MedicoMapper {

    public static Medico toEntity(DadosCadastroMedico dados) {
        Medico medico = new Medico();
        medico.setNome(dados.nome());
        medico.setEmail(dados.email());
        medico.setTelefone(dados.telefone());
        medico.setCrm(dados.crm());
        medico.setEspecialidade(dados.especialidade());
        medico.setEndereco(EnderecoMapper.toEndereco(dados.endereco()));
        medico.setAtivo(dados.ativo());
        return medico;
    }

    public static DadosCadastroMedico toDadosCadastro(Medico medico) {
        return new DadosCadastroMedico(
                medico.getNome(),
                medico.getEmail(),
                medico.getTelefone(),
                medico.getCrm(),
                medico.getEspecialidade(),
                EnderecoMapper.toDados(medico.getEndereco()),
                medico.getAtivo()
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

}
