package estudo.br.api.domain.paciente;

import estudo.br.api.domain.medico.endereco.Endereco;
import estudo.br.api.domain.medico.endereco.EnderecoMapper;
import estudo.br.api.domain.paciente.dtos.DadosAtualizacaoPaciente;
import jakarta.persistence.*;
import lombok.*;

import java.util.Optional;

@Entity
@Table(name = "pacientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Setter
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String cpf;

    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public void atualizaDados(DadosAtualizacaoPaciente dados) {
        Optional.ofNullable(dados.nome()).ifPresent(nome -> this.nome = nome);
        Optional.ofNullable(dados.email()).ifPresent(email -> this.email = email);
        Optional.ofNullable(dados.telefone()).ifPresent(telefone -> this.telefone = telefone);
        Optional.ofNullable(dados.endereco()).ifPresent(endereco -> this.endereco.atualizaDados(EnderecoMapper.toEndereco(endereco)));
    }

    public void inativar() {
        setAtivo(false);
    }
}
