package poo;

import java.util.HashMap;

public class Telefone {
    private HashMap <String, String> tabelaDeTelefones;

    private boolean validacaoTelefone(String numero){
        String telefoneER = "^[1-9]{2}([9][1-9][0-9]{7}|[1-9][0-9]{7})$";
        return numero.matches(telefoneER);
    }

    public Telefone(){
        tabelaDeTelefones = new HashMap<>();
    }

    public boolean add(String rotulo, String numero){
        if(!this.validacaoTelefone(numero)) return false;
        if(tabelaDeTelefones.containsKey(rotulo)) return false;
        tabelaDeTelefones.put(rotulo, numero);
        return true;
    }

    public boolean remove(String rotulo){
        if(!tabelaDeTelefones.containsKey(rotulo)) return false;
        tabelaDeTelefones.remove(rotulo);
        return true;
    }

    public boolean update(String rotulo, String numero){
        if(!this.validacaoTelefone(numero)) return false;
        if(!this.tabelaDeTelefones.containsKey(rotulo)) return false;
        tabelaDeTelefones.put(rotulo, numero);
        return true;
    }

    @Override
    public String toString() {
        return "Telefone{" +
                "tabelaDeTelefones=" + tabelaDeTelefones +
                '}';
    }
}