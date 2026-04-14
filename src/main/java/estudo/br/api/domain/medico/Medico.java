package estudo.br.api.domain.medico;

import estudo.br.api.domain.medico.endereco.Endereco;
import estudo.br.api.domain.medico.dtos.DadosAtualizacaoMedico;
import estudo.br.api.domain.medico.endereco.EnderecoMapper;
import jakarta.persistence.*;
import lombok.*;

import java.util.Optional;

@Entity
@Table(name = "medicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Setter
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public void atualizaDados(DadosAtualizacaoMedico dados) {
        Optional.ofNullable(dados.nome()).ifPresent(nome -> this.nome = nome);
        Optional.ofNullable(dados.email()).ifPresent(email -> this.email = email);
        Optional.ofNullable(dados.telefone()).ifPresent(telefone -> this.telefone = telefone);
        Optional.ofNullable(dados.endereco()).ifPresent(endereco -> this.endereco.atualizaDados(EnderecoMapper.toEndereco(endereco)));
    }

    public void demitir() {
        setAtivo(false);
    }
}
