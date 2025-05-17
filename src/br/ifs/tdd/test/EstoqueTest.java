package br.ifs.tdd.test;

import br.ifs.tdd.exception.OperacaoInvalidaException;
import br.ifs.tdd.exception.ProdutoDuplicadoException;
import br.ifs.tdd.exception.ProdutoNaoEncontradoException;
import br.ifs.tdd.exception.ValidacaoException;
import br.ifs.tdd.model.Lote;
import br.ifs.tdd.model.Produto;
import br.ifs.tdd.service.Estoque;
import junit.framework.TestCase;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class EstoqueTest {
    Produto produto = new Produto("1234567890123", "Caneta", "Esferográfica", 2.50);
    Produto produto2;
    Estoque estoque = new Estoque();

    @Test
    public void adicionarItem() {
        assertDoesNotThrow(() -> {
            estoque.adicionarItem(produto);
        });
    }

    @Test
    public void adicionarItemNull(){
        assertThrows(ValidacaoException.class, () -> {
            estoque.adicionarItem(produto2);
        });
    }

    @Test
    public void adicionarItemDuplicado(){
        assertThrows(ProdutoDuplicadoException.class, ()  ->{
           estoque.adicionarItem(produto);
           estoque.adicionarItem(produto);
        });
    }

    @Test
    public void removerItem(){
        assertDoesNotThrow(() -> {
            estoque.adicionarItem(produto);
            estoque.removerItem(produto.getIdentificador());
        });
    }

    @Test
    public void removerItemComChaveNull(){
        assertThrows(ValidacaoException.class, () ->{
           estoque.removerItem(null);
        });
    }

    @Test
    public void removerItemInexistente(){
        assertThrows(ProdutoNaoEncontradoException.class, () ->{
            estoque.removerItem(produto.getIdentificador());
        });
    }

    //@Test
    //public void removerItemComLote(){
    //    assertThrows(OperacaoInvalidaException.class, () ->{
    //        estoque.adicionarItem(produto);
    //        estoque.removerItem(produto.getIdentificador());
    //    });
    //}

    @Test
    public void buscarItem(){
        assertDoesNotThrow(() -> {
            estoque.adicionarItem(produto);
            estoque.buscarItem(produto.getIdentificador());
        });
    }

    @Test
    public void buscarItemComIdentificadorNull(){
        assertThrows(ValidacaoException.class, () ->{
            estoque.buscarItem(null);
        });
    }

    @Test
    public void buscarItemInexistente(){
        assertThrows(ProdutoNaoEncontradoException.class, () ->{
            estoque.buscarItem(produto.getIdentificador());
        });
    }

    @Test
    public void atualizarItem(){
        assertDoesNotThrow(() -> {
            estoque.adicionarItem(produto);
            estoque.buscarItem(produto.getIdentificador());
        });
    }


}