package estudo.br.api.domain.medico;

import estudo.br.api.domain.medico.dtos.DadosAtualizacaoMedico;
import estudo.br.api.domain.medico.dtos.DadosCadastroMedico;
import estudo.br.api.domain.medico.dtos.DadosDetalhamentoMedico;
import estudo.br.api.domain.medico.dtos.DadosListagemMedico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoMedico> cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder){
        DadosDetalhamentoMedico medico = medicoService.cadastrar(dados);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.id()).toUri();
        return ResponseEntity.created(uri).body(medico);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}, direction = Sort.Direction.ASC) Pageable paginacao){
        return ResponseEntity.ok(medicoService.listar(paginacao));
    }

    @PutMapping
    public ResponseEntity<DadosDetalhamentoMedico> atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        return ResponseEntity.ok(medicoService.atualizar(dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        medicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoMedico> detalhar(@PathVariable Long id) {
        return ResponseEntity.ok(medicoService.detalhar(id));
    }

    @DeleteMapping("/demitir/{id}")
    public ResponseEntity<Void> demitir(@PathVariable Long id){
        medicoService.demitir(id);
        return ResponseEntity.noContent().build();
    }
}
