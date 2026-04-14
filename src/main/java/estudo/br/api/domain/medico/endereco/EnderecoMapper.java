package estudo.br.api.domain.medico.endereco;

public class EnderecoMapper {
    public static Endereco toEndereco(DadosEndereco dados) {
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

    public static DadosEndereco toDados(Endereco endereco) {
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
