package estudo.br.api.domain.paciente;

import estudo.br.api.domain.paciente.dtos.DadosAtualizacaoPaciente;
import estudo.br.api.domain.paciente.dtos.DadosCadastroPaciente;
import estudo.br.api.domain.paciente.dtos.DadosDetalhamentoPaciente;
import estudo.br.api.domain.paciente.dtos.DadosListagemPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Boas práticas: @Transactional(readOnly = true) utilizado em métodos que Não fazem escrita no bd, economiza memória e processamento;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
    public DadosDetalhamentoPaciente cadastrar(DadosCadastroPaciente dados) {
        return PacienteMapper.toDadosDetalhamento(pacienteRepository.save(PacienteMapper.toEntity(dados)));
    }

    @Transactional(readOnly = true)
    public Page<DadosListagemPaciente> listar(Pageable paginacao) {
        return pacienteRepository.findAllByAtivoTrue(paginacao).map(PacienteMapper::toDadosListagem);
    }

    @Transactional
    public DadosDetalhamentoPaciente atualizar(DadosAtualizacaoPaciente dados) {
        Paciente paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizaDados(dados);
        return PacienteMapper.toDadosDetalhamento(paciente);
    }

    @Transactional
    public void deletar(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Transactional
    public void inativar(Long id) {
        pacienteRepository.findById(id).ifPresent(Paciente::inativar);
    }

    public DadosDetalhamentoPaciente detalhar(Long id) {
        return PacienteMapper.toDadosDetalhamento(pacienteRepository.getReferenceById(id));
    }
}
