package poo;

import java.util.ArrayList;

public class Agenda {
    private ArrayList<Pessoa> listaDePessoas;

    private boolean posiçãoValida(int posição){
        if(listaDePessoas.size() == 0) return false;
        return posição<listaDePessoas.size();
    }

    public Agenda(){
        this.listaDePessoas = new ArrayList<>();
    }

    public boolean addPessoa(Pessoa pessoa){
        return this.listaDePessoas.add(pessoa);
    }

    public boolean removePessoa(String nome, String sobrenome){
        for (Pessoa p : listaDePessoas) {
            if((p.nome().equals(nome)) && (p.sobrenome().equals(sobrenome))){
                int pos = listaDePessoas.indexOf(p);
                listaDePessoas.remove(pos);
                return true;
            }
        }
        return false;
    }

    public boolean addTelefone(String rotulo, String numero, int plndex){
        if(!posiçãoValida(plndex)) return false;
        return listaDePessoas.get(plndex).addTelefone(rotulo, numero);
    }

    public boolean addEmail(String rotulo, String email, int plndex){
        if(!posiçãoValida(plndex)) return false;
        return listaDePessoas.get(plndex).addEmail(rotulo, email);
    }

    public boolean updateTelefone(String rotulo, String numero, int plndex){
        if(!posiçãoValida(plndex)) return false;
        return listaDePessoas.get(plndex).updateTelefone(rotulo, numero);
    }

    public boolean updateEmail(String rotulo, String email, int plndex){
        if(!posiçãoValida(plndex)) return false;
        return listaDePessoas.get(plndex).updateEmail(rotulo, email);
    }

    public boolean removeTelefone(String rotulo, int plndex){
        if(!posiçãoValida(plndex)) return false;
        return listaDePessoas.get(plndex).removeTelefone(rotulo);
    }

    public boolean removeEmail(String rotulo, int plndex){
        if(!posiçãoValida(plndex)) return false;
        return listaDePessoas.get(plndex).removeEmail(rotulo);
    }

    @Override
    public String toString() {
        return "Agenda{ \n" +
                listaDePessoas +
                "\n}";
    }
}