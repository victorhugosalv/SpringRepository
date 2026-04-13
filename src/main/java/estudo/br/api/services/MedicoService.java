package estudo.br.api.services;

import estudo.br.api.dados.DadosAtualizacaoMedico;
import estudo.br.api.dados.DadosCadastroMedico;
import estudo.br.api.dados.DadosListagemMedico;
import estudo.br.api.mappers.MedicoMapper;
import estudo.br.api.models.Medico;
import estudo.br.api.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Boas práticas: @Transactional(readOnly = true) utilizado em métodos que Não fazem escrita no bd, economiza memoria e processamento;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Transactional
    public void cadastrar(DadosCadastroMedico dados) {
        medicoRepository.save(MedicoMapper.toEntity(dados));
    }

    @Transactional(readOnly = true)
    public Page<DadosListagemMedico> listar(Pageable paginacao) {
        return medicoRepository.findAllByAtivoTrue(paginacao).map(MedicoMapper::toDadosListagem);
    }

    @Transactional
    public void atualizar(DadosAtualizacaoMedico dados) {
        medicoRepository.findById(dados.id())
                .ifPresent(medico -> medico.atualizaDados(dados)    );
    }

    @Transactional
    public void deletar(Long id) {
        medicoRepository.deleteById(id);
    }

    @Transactional
    public void demitir(Long id) {
        medicoRepository.findById(id).ifPresent(Medico::demitir);
    }
}
