/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author aluno
 */
public class Cliente {
    private int clicodigo;
    private String nome;
    private String cpf;
    private String cnpj;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private String telefone;

    public Cliente(int clicodigo, String nome, String cpf, String cnpj, String estado, String cidade, String bairro, String rua, String telefone) {
        this.clicodigo = clicodigo;
        this.nome = nome;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.telefone = telefone;
    }

    
    public int getClicodigo() {
        return clicodigo;
    }

    public void setClicodigo(int clicodigo) {
        this.clicodigo = clicodigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
