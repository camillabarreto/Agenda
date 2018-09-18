package poo;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class TestePessoa {
    @Test
    public void addTelefone(){
        Pessoa p = new Pessoa("Camilla", "Barreto", LocalDate.now());
        Assert.assertFalse("DDD inválido", p.addTelefone("casa", "4033335555"));
        Assert.assertFalse("8º dígito inválido", p.addTelefone("casa", "4803335555"));
        Assert.assertFalse("9º dígito inválido", p.addTelefone("casa", "48833335555"));
        Assert.assertFalse("8º dígito inválido", p.addTelefone("casa", "48903335555"));
        Assert.assertTrue("Adição válida", p.addTelefone("casa", "4833335555"));
        Assert.assertFalse("Rótulo já existe", p.addTelefone("casa", "4533335555"));
    }
    @Test
    public void addEmail(){
        Pessoa p = new Pessoa("Camilla", "Barreto", LocalDate.now());
        Assert.assertFalse("Email inválido", p.addEmail("pessoal", "@gmail.com"));
        Assert.assertFalse("Email inválido", p.addEmail("pessoal", "camillagmail.com"));
        Assert.assertFalse("Email inválido", p.addEmail("pessoal", "camilla@gmail"));
        Assert.assertFalse("Email inválido", p.addEmail("pessoal", "camilla@.com"));
        Assert.assertTrue("Email válido", p.addEmail("pessoal", "camilla@gmail.com"));
        Assert.assertFalse("Rótulo duplicado", p.addEmail("pessoal", "camilla@gmail.com"));
    }
    @Test
    public void removeTelefone(){
        Pessoa p = new Pessoa("Camilla", "Barreto", LocalDate.now());
        p.addTelefone("casa", "4833335555");
        Assert.assertFalse("Remoção inválida", p.removeTelefone("trabalho"));
        Assert.assertTrue("Remoção válida", p.removeTelefone("casa"));
    }
    @Test
    public void removeEmail(){
        Pessoa p = new Pessoa("Camilla", "Barreto", LocalDate.now());
        p.addEmail("pessoal", "camilla@gmail.com");
        Assert.assertFalse("Remoção inválida", p.removeEmail("trabalho"));
        Assert.assertTrue("Remoção válida", p.removeEmail("pessoal"));
    }
    @Test
    public void updateTelefone(){
        Pessoa p = new Pessoa("Camilla", "Barreto", LocalDate.now());
        p.addTelefone("casa", "4833335555");
        Assert.assertFalse("Rótulo inexistente", p.updateTelefone("trabalho", "4433335555"));
        Assert.assertFalse("DDD inválido", p.updateTelefone("casa", "4033335555"));
        Assert.assertFalse("8º dígito inválido", p.updateTelefone("casa", "4803335555"));
        Assert.assertFalse("9º dígito inválido", p.updateTelefone("casa", "48833335555"));
        Assert.assertFalse("8º dígito inválido", p.updateTelefone("casa", "48903335555"));
        Assert.assertTrue("Update válido", p.updateTelefone("casa", "4533335555"));
    }
    @Test
    public void updateEmail(){
        Pessoa p = new Pessoa("Camilla", "Barreto", LocalDate.now());
        p.addEmail("pessoal", "camilla@gmail.com");
        Assert.assertFalse("Rótulo inexistente", p.updateEmail("trabalho", "nome@gmail.com"));
        Assert.assertFalse("Email inválido", p.addEmail("pessoal", "@gmail.com"));
        Assert.assertFalse("Email inválido", p.addEmail("pessoal", "camillagmail.com"));
        Assert.assertFalse("Email inválido", p.addEmail("pessoal", "camilla@gmail"));
        Assert.assertFalse("Email inválido", p.addEmail("pessoal", "camilla@.com"));
        Assert.assertTrue("Update válido", p.updateEmail("pessoal", "nome@gmail.com"));
    }
}