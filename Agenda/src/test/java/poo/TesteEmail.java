package poo;

import org.junit.Assert;
import org.junit.Test;

public class TesteEmail {
    @Test
    public void add(){
        Email e = new Email();
        Assert.assertFalse("Email inválido", e.add("pessoal", "camilla@gmail"));
        Assert.assertFalse("Email inválido", e.add("pessoal", "@gmail.com"));
        Assert.assertFalse("Email inválido", e.add("pessoal", "camillagmail.com"));
        Assert.assertTrue("Email válido", e.add("pessoal", "CAMILLA@gmail.com"));
        Assert.assertFalse("Rótulo duplicado", e.add("pessoal", "camilla@gmail.com"));
    }
    @Test
    public void remove(){
        Email e = new Email();
        e.add("pessoal", "camilla@gmail.com");
        Assert.assertFalse("Rótulo inexistente", e.remove("trabalho"));
        Assert.assertTrue("Remoção válida", e.remove("pessoal"));
    }
    @Test
    public void update(){
        Email e = new Email();
        e.add("pessoal", "camilla@gmail.com");
        Assert.assertFalse("Rótulo inexistente", e.update("trabalho", "novo@gmail.com"));
        Assert.assertTrue("Update válido", e.update("pessoal", "novo@gmail.com"));
    }
}