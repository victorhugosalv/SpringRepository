package estudo.br.api.domain.paciente;

import estudo.br.api.domain.paciente.dtos.DadosAtualizacaoPaciente;
import estudo.br.api.domain.paciente.dtos.DadosCadastroPaciente;
import estudo.br.api.domain.paciente.dtos.DadosDetalhamentoPaciente;
import estudo.br.api.domain.paciente.dtos.DadosListagemPaciente;
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
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoPaciente> cadastrar(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriBuilder){
        DadosDetalhamentoPaciente paciente = pacienteService.cadastrar(dados);
        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.id()).toUri();
        return ResponseEntity.created(uri).body(paciente);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listar(@PageableDefault(size = 10, sort = {"nome"}, direction = Sort.Direction.ASC) Pageable paginacao){
        return ResponseEntity.ok(pacienteService.listar(paginacao));
    }

    @PutMapping
    public ResponseEntity<DadosDetalhamentoPaciente> atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados){
        return ResponseEntity.ok(pacienteService.atualizar(dados));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pacienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoPaciente> detalhar(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.detalhar(id));
    }

    @DeleteMapping("/inativar/{id}")
    public ResponseEntity<Void> inativar(@PathVariable Long id){
        pacienteService.inativar(id);
        return ResponseEntity.noContent().build();
    }
}
