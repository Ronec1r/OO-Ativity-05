package br.ifs.tdd.test;
import br.ifs.tdd.exception.ValidacaoException;
import br.ifs.tdd.model.Produto;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoTest {
    @Test
    public void criarProdutoValido(){
        assertNotNull(new Produto("1234567890123", "Caneta", "Esferográfica", 2.50));
    }
    @Test
    public void criarProdutoComIdentificadorNull() {
        assertThrows(ValidacaoException.class, () -> {
            new Produto("", "Caneta", "Esferográfica",2.50);
        });
    }
    @Test
    public void criarProdutoComIdentificadorCurto() {
        assertThrows(ValidacaoException.class, () -> {
            new Produto("123456789012", "Caneta", "Esferográfica",2.50);
        });
    }
    @Test
    public void criarProdutoComIdentificadorComLetras() {
        assertThrows(ValidacaoException.class, () -> {
            new Produto("12345ABC90123", "Caneta", "Esferográfica",2.50);
        });
    }
    @Test
    public void criarProdutoComNomeNull() {
        assertThrows(ValidacaoException.class, () -> {
            new Produto("1234567890123","", "Esferográfica",2.50);
        });
    }
    @Test
    public void criarProdutoComNomeLongo() {
        assertThrows(ValidacaoException.class, () -> {
            new Produto("1234567890123", "12345678901231234567890123123456789012312345678901231234567890123123456789012312345678901231234567890123", "Esferográfica",2.50);
        });
    }
    @Test
    public void criarProdutoComDescricaoNull() {
        assertThrows(ValidacaoException.class, () -> {
            new Produto("1234567890123", "Caneta", "",2.50);
        });
    }
    @Test
    public void criarProdutoComDescricaoLonga() {
        assertThrows(ValidacaoException.class, () -> {
            new Produto("1234567890123", "Caneta", "1234567890123123456789012312345678901231234567890123123456789012312345678901231234567890123123456789012312345678901231234567890123123456789012312345678901231234567890123123456789012312345678901231234567890123123456789012312345678901231234567890123123456789012312345678901231234567890123123456789012312345678901231234567890123123456789012312345678901231234567890123123456789012312345678901231234567890123123456789012312345678901231234567890123123456789012312345678901231234567890123123456789012312345678901231234567890123",2.50);
        });
    }
    @Test
    public void criarProdutoComPrecoNegativo() {
        assertThrows(ValidacaoException.class, () -> {
            new Produto("1234567890123", "Caneta", "Esferográfica",-2.50);
        });
    }
}