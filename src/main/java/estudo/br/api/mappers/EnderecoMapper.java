package estudo.br.api.mappers;

import estudo.br.api.dados.DadosEndereco;
import estudo.br.api.models.Endereco;

public class EnderecoMapper {
    protected static Endereco toEndereco(DadosEndereco dados) {
        return new Endereco(
                dados.logradouro(),
                dados.bairro(),
                dados.cep(),
                dados.cidade(),
                dados.uf(),
                dados.numero(),
                dados.complemento()
        );
    }

    protected static DadosEndereco toDados(Endereco endereco) {
        return new DadosEndereco(
                endereco.getLogradouro(),
                endereco.getBairro(),
                endereco.getCep(),
                endereco.getCidade(),
                endereco.getUf(),
                endereco.getNumero(),
                endereco.getComplemento()
        );
    }
}
