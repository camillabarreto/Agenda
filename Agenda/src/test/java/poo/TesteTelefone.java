package poo;

import org.junit.Assert;
import org.junit.Test;

public class TesteTelefone {
    @Test
    public void add(){
        Telefone t = new Telefone();
        Assert.assertFalse("Telefone sem DDD", t.add("casa", "933335555"));
        Assert.assertFalse("Telefone sem DDD", t.add("casa", "33335555"));
        Assert.assertFalse("DDD inválido", t.add("casa", "00933335555"));
        Assert.assertFalse("DDD inválido", t.add("casa", "04933335555"));
        Assert.assertFalse("DDD inválido", t.add("casa", "40933335555"));
        Assert.assertFalse("DDD inválido", t.add("casa", "0033335555"));
        Assert.assertFalse("DDD inválido", t.add("casa", "0433335555"));
        Assert.assertFalse("DDD inválido", t.add("casa", "4033335555"));
        Assert.assertFalse("8º digito inválido", t.add("casa", "48903335555"));
        Assert.assertFalse("9º digito inválido", t.add("casa", "48093335555"));
        Assert.assertFalse("8º digito inválido", t.add("casa", "4803335555"));
        Assert.assertFalse("Quantidade de dígitos inválidos", t.add("casa", "489333555555"));
        Assert.assertTrue("Número válido", t.add("casa", "4832580081"));
        Assert.assertTrue("Número válido", t.add("celular", "48998060571"));
        Assert.assertFalse("Rótulo duplicado", t.add("celular", "45998060571"));
    }
    @Test
    public void remove(){
        Telefone t = new Telefone();
        t.add("trabalho", "4833335555");
        Assert.assertFalse("Rótulo inexistente", t.remove("casa"));
        Assert.assertTrue("Remoção válida", t.remove("trabalho"));
    }
    @Test
    public void update(){
        Telefone t = new Telefone();
        t.add("casa", "4833335555");
        Assert.assertFalse("Rótulo inexistente", t.update("trabalho", "4833335555"));
        Assert.assertTrue("Update válido", t.update("casa", "4533335555"));
    }
}