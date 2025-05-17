package br.ifs.tdd.model;
import br.ifs.tdd.exception.ValidacaoException;

public class Produto {
    private String identificador;
    private String nome;
    private String descricao;
    private double preco;

    public Produto(String identificador, String nome, String descricao, double preco) {
        this.validarIdentificador(identificador);
        this.validarNome(nome);
        this.validarDescricao(descricao);
        this.validarPreco(preco);

        this.identificador = identificador;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    private void validarIdentificador(String identificador){
        if(identificador==null || identificador.equals("")){
            throw new ValidacaoException("Identificador obrigatório");
        }
        if(identificador.length()<13){
            throw new ValidacaoException("Tamanho do identificador inválido (13 caracteres)");
        }
        if (!identificador.matches("\\d+")) {
            throw new ValidacaoException("Formato do identificador inválido (apenas números)");
        }
    }

    private void validarNome(String nome){
        if(nome==null || nome.equals("")){
            throw new ValidacaoException("Nome obrigatório");
        }
        if(nome.length()>100){
            throw new ValidacaoException("Nome excede 100 caracteres");
        }
    }

    private void validarDescricao(String descricao){
        if(descricao==null || descricao.equals("")){
            throw new ValidacaoException("Nome obrigatório");
        }
        if(descricao.length()>500){
            throw new ValidacaoException("Nome excede 100 caracteres");
        }
    }

    private void validarPreco(double preco){
        if(preco<0){
            throw new ValidacaoException("Preço inválido (deve ser positivo)");
        }
    }

    public String getIdentificador(){
        return this.identificador;
    }
}
