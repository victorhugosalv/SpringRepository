package estudo.br.api.controllers;


import estudo.br.api.dados.DadosAtualizacaoMedico;
import estudo.br.api.dados.DadosCadastroMedico;
import estudo.br.api.dados.DadosListagemMedico;
import estudo.br.api.services.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        medicoService.cadastrar(dados);
        return ResponseEntity.ok("Medico cadastrado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}, direction = Sort.Direction.ASC) Pageable paginacao){
        return ResponseEntity.ok(medicoService.listar(paginacao));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<String> atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados){
        medicoService.atualizar(dados);
        return ResponseEntity.ok("Medico atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        medicoService.deletar(id);
        return ResponseEntity.ok("Medico deletado com sucesso!");
    }

    @DeleteMapping("/demitir/{id}")
    public ResponseEntity<String> demitir(@PathVariable Long id){
        medicoService.demitir(id);
        return ResponseEntity.ok("Medico demitido com sucesso!");
    }
}
