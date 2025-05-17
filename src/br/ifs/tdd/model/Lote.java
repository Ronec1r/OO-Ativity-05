package br.ifs.tdd.model;
import br.ifs.tdd.exception.ValidacaoException;
import java.time.LocalDate;

public class Lote {
    private Produto produto;
    private LocalDate data;
    private int quantidade;

    public Lote(Produto produto, LocalDate data, int quantidade) {
        this.validarProduto(produto);
        this.validarQuantidade(quantidade);
        this.validarData(data);

        this.produto = produto;
        this.data = data;
        this.quantidade = quantidade;
    }

    private void validarQuantidade(int quantidade){
        if(quantidade<0){
            throw new ValidacaoException("Quantidade inválida(deve ser positiva)");
        }
    }

    private void validarProduto(Produto produto){
        if(produto==null){
            throw new ValidacaoException("Produto inválido");
        }
    }

    private void validarData(LocalDate data){
        if(data==null){
            throw new ValidacaoException("Data de validade obrigatória");
        }
        if(LocalDate.now().isAfter(data)){
            throw new ValidacaoException("Data de validade vencida");
        }
    }
}
