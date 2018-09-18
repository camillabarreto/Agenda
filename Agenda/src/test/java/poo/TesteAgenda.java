package poo;

import org.junit.Test;
import org.junit.Assert;
import java.time.LocalDate;

public class TesteAgenda {
    @Test
    public void addPessoa(){
        Agenda a = new Agenda();
        Pessoa p = new Pessoa("Camilla", "Barreto", LocalDate.now());
        Assert.assertTrue("Adição válida", a.addPessoa(p));
    }
    @Test
    public void removePessoa(){
        Agenda a = new Agenda();
        Pessoa p1 = new Pessoa("Camilla", "Barreto", LocalDate.now());
        Pessoa p2 = new Pessoa("Gabriela", "Barreto", LocalDate.now());
        a.addPessoa(p1);
        Assert.assertFalse("Pessoa inexistente", a.removePessoa("Gabriela", "Barreto"));
        Assert.assertTrue("Remoção válida", a.removePessoa("Camilla", "Barreto"));
    }
    @Test
    public void addTelefone(){
        Agenda a = new Agenda();
        Pessoa p = new Pessoa("Camilla", "Barreto", LocalDate.now());
        Assert.assertFalse("Index inválido", a.addTelefone("casa", "4833335555", 0));
        a.addPessoa(p);
        Assert.assertTrue("Index válido", a.addTelefone("casa", "4833335555", 0));
    }
    @Test
    public void addEmail(){
        Agenda a = new Agenda();
        Pessoa p = new Pessoa("Camilla", "Barreto", LocalDate.now());
        Assert.assertFalse("Index inválido", a.addEmail("pessoal", "camilla@gmail.com", 0));
        a.addPessoa(p);
        Assert.assertTrue("Index válido", a.addEmail("pessoal", "camilla@gmail.com", 0));
    }
    @Test
    public void updateTelefone(){
        Agenda a = new Agenda();
        Pessoa p = new Pessoa("Camilla", "Barreto", LocalDate.now());
        a.addPessoa(p);
        a.addTelefone("casa", "4533335555", 0);
        Assert.assertFalse("DDD inválido", a.updateTelefone("casa", "4033335555", 0));
        Assert.assertFalse("Rótulo inexistente", a.updateTelefone("trabalho", "4533335555", 0));
        Assert.assertFalse("Index inválido", a.updateTelefone("casa", "4533335555", 1));
        Assert.assertTrue("Update válido", a.updateTelefone("casa", "4833335555", 0));
    }
    @Test
    public void updateEmail(){
        Agenda a = new Agenda();
        Pessoa p = new Pessoa("Camilla", "Barreto", LocalDate.now());
        a.addPessoa(p);
        a.addEmail("pessoal", "camilla@gmail.com", 0);
        Assert.assertFalse("Email inválido", a.updateEmail("pessoal", "camilla@gmail", 0));
        Assert.assertFalse("Rótulo inexistente", a.updateEmail("trabalho", "camilla@gmail.com", 0));
        Assert.assertFalse("Index inválido", a.updateEmail("pessoal", "camilla02@gmail.com", 1));
        Assert.assertTrue("Update válido", a.updateEmail("pessoal", "camilla02@gmail.com", 0));
    }
    @Test
    public void removeTelefone(){
        Agenda a = new Agenda();
        Pessoa p = new Pessoa("Camilla", "Barreto", LocalDate.now());
        a.addPessoa(p);
        a.addTelefone("casa", "4533335555", 0);
        Assert.assertFalse("Index inválido", a.removeTelefone("casa",1));
        Assert.assertFalse("Rótulo inexistente", a.removeTelefone("trabalho",0));
        Assert.assertTrue("Remoção válida", a.removeTelefone("casa",0));
    }
    @Test
    public void removeEmail(){
        Agenda a = new Agenda();
        Pessoa p = new Pessoa("Camilla", "Barreto", LocalDate.now());
        a.addPessoa(p);
        a.addEmail("pessoal", "camilla@gmail.com", 0);
        Assert.assertFalse("Index inválido", a.removeEmail("pessoal",1));
        Assert.assertFalse("Rótulo inexistente", a.removeEmail("trabalho",0));
        Assert.assertTrue("Remoção válida", a.removeEmail("pessoal",0));
    }
}