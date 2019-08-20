package br.com.projeto;

import java.io.Serializable;
import javax.swing.JOptionPane;

public class Musica implements Serializable{

    //static List<Musica> musicas = new ArrayList<>();
    String nomeBanda, genero, tituloMusica, letraMusica;

    public Musica(String nomeBanda, String genero, String tituloMusica, String letraMusica) {
        this.nomeBanda = nomeBanda;
        this.genero = genero;
        this.tituloMusica = tituloMusica;
        this.letraMusica = letraMusica;
    }

    public Musica (){
    }

    public void setMusica() {
        JOptionPane.showMessageDialog(null, "....Cadastrando....");
        this.genero = JOptionPane.showInputDialog("Digite o genero da banda: ");
        this.nomeBanda = JOptionPane.showInputDialog("Digite o nome da banda: ");
        this.tituloMusica = JOptionPane.showInputDialog("Digite o titulo da musica: ");
        this.letraMusica = JOptionPane.showInputDialog("Digite a letra da musica: ");
    }

 public String getNomeBanda() {
        return nomeBanda;
    }

    public void setNomeBanda(String nomeBanda) {
        this.nomeBanda = nomeBanda;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTituloMusica() {
        return tituloMusica;
    }

    public void setTituloMusica(String tituloMusica) {
        this.tituloMusica = tituloMusica;
    }

    public String getLetraMusica() {
        return letraMusica;
    }

    public void setLetraMusica(String letraMusica) {
        this.letraMusica = letraMusica;
    }
    @Override
    public String toString() {
        return "Musica:\n" + "Nome = " + nomeBanda + "\nGenero = " + genero + "\nTitulo da Musica = " + tituloMusica + "\nLetra da Musica = " + letraMusica ;
    }

   
}
