package poo;

import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private Telefone telefones = null;
    private Email emails = null;
    private LocalDate dataNasc = null;

    public String nome(){
        return this.nome;
    }

    public String sobrenome(){
        return this.sobrenome;
    }

    public Pessoa(String nome, String sobrenome, LocalDate dataNasc){
        //if(nome.isEmpty()) throw new IllegalArgumentException();
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.dataNasc = dataNasc;
        this.telefones = new Telefone();
        this.emails = new Email();
    }

    public boolean addTelefone(String rotulo, String numero){ return this.telefones.add(rotulo, numero); }

    public boolean addEmail(String rotulo, String email){
        return this.emails.add(rotulo, email);
    }

    public boolean removeTelefone(String rotulo){
        return this.telefones.remove(rotulo);
    }

    public boolean removeEmail(String rotulo){
        return this.emails.remove(rotulo);
    }

    public boolean updateTelefone(String rotulo, String numero){
        return this.telefones.update(rotulo, numero);
    }

    public boolean updateEmail(String rotulo, String email){
        return this.emails.update(rotulo, email);
    }

    @Override
    public String toString() {
        return  "\nnome = " + nome +
                "\nsobrenome = " + sobrenome +
                "\ntelefones = " + telefones +
                "\nemails = " + emails;
    }
}