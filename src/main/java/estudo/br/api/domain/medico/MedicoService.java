package estudo.br.api.domain.medico;

import estudo.br.api.domain.medico.dtos.DadosAtualizacaoMedico;
import estudo.br.api.domain.medico.dtos.DadosCadastroMedico;
import estudo.br.api.domain.medico.dtos.DadosDetalhamentoMedico;
import estudo.br.api.domain.medico.dtos.DadosListagemMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Boas práticas: @Transactional(readOnly = true) utilizado em métodos que Não fazem escrita no bd, economiza memória e processamento;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Transactional
    public DadosDetalhamentoMedico cadastrar(DadosCadastroMedico dados) {
        return MedicoMapper.toDadosDetalhamento(medicoRepository.save(MedicoMapper.toEntity(dados)));
    }

    @Transactional(readOnly = true)
    public Page<DadosListagemMedico> listar(Pageable paginacao) {
        return medicoRepository.findAllByAtivoTrue(paginacao).map(MedicoMapper::toDadosListagem);
    }

    @Transactional
    public DadosDetalhamentoMedico atualizar(DadosAtualizacaoMedico dados) {
        Medico medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizaDados(dados);
        return MedicoMapper.toDadosDetalhamento(medico);
    }

    @Transactional
    public void deletar(Long id) {
        medicoRepository.deleteById(id);
    }

    @Transactional
    public void demitir(Long id) {
        medicoRepository.findById(id).ifPresent(Medico::demitir);
    }

    public DadosDetalhamentoMedico detalhar(Long id) {
        return MedicoMapper.toDadosDetalhamento( medicoRepository.getReferenceById(id));
    }
}
