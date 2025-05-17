package br.ifs.tdd.service;
import java.util.Map;
import java.util.TreeMap;

import br.ifs.tdd.exception.ProdutoDuplicadoException;
import br.ifs.tdd.exception.ProdutoNaoEncontradoException;
import br.ifs.tdd.exception.ValidacaoException;
import br.ifs.tdd.model.Produto;

public class Estoque {
    private Map<String, Produto> produtosEstoque = new TreeMap<String, Produto>();

    public Estoque() {
    }

    public void adicionarItem(Produto produto){
        this.validarItem(produto);
        this.verificarItemDuplicado(produto);
        this.produtosEstoque.put(produto.getIdentificador(),produto);
    }

    private void validarItem(Produto produto){
        if(produto==null){
            throw new ValidacaoException("Produto inválido)");
        }
    }

    private void verificarItemDuplicado(Produto produto){
        if(this.produtosEstoque.containsKey(produto.getIdentificador())){
            throw new ProdutoDuplicadoException("Produto com identificador já existente no estoque");
        }
    }

    public void removerItem(String chave){
        this.validarChaveNull(chave);
        this.validarChaveExistente(chave);
        this.produtosEstoque.remove(chave);
    }

    private void validarChaveNull(String chave){
        if(chave==null){
            throw new ValidacaoException("Identificador de produto inválido");
        }
    }

    private void validarChaveExistente(String chave){
        if (!this.produtosEstoque.containsKey(chave)){
            throw new ProdutoNaoEncontradoException("Identificador não encontrado");
        }
    }

    public Produto buscarItem(String chave){
        this.validarChaveNull(chave);
        this.validarChaveExistente(chave);
        return this.produtosEstoque.get(chave);
    }

}
