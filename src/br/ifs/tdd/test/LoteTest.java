package br.ifs.tdd.test;

import br.ifs.tdd.exception.ValidacaoException;
import br.ifs.tdd.model.Lote;
import br.ifs.tdd.model.Produto;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class LoteTest {
    Produto produto = new Produto("1234567890123", "Caneta", "Esferográfica", 2.50);

    @Test
    public void criarLoteValido(){
        assertNotNull(new Lote(produto, LocalDate.now(), 20));
    }

    @Test
    public void criarLoteComQuantidadeNegativa(){
        assertThrows(ValidacaoException.class, () -> {
            new Lote( produto, LocalDate.now(),-20);
        });
    }

    @Test
    public void criarLoteComProdutoNull(){
        assertThrows(ValidacaoException.class, () -> {
            new Lote(null, LocalDate.now(),20);
        });
    }

    @Test
    public void criarLoteComDataNull(){
        assertThrows(ValidacaoException.class, () -> {
            new Lote(produto, null,20);
        });
    }

    @Test
    public void criarLoteComDataPassada(){
        assertThrows(ValidacaoException.class, () -> {
            new Lote(produto, LocalDate.now().minusDays(30),20);
        });
    }
}