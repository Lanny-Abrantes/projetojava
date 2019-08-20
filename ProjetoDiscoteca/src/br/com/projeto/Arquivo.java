package br.com.projeto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Arquivo implements Inter {

    protected File arquivo;
    protected String caminho = "C:\\JAVAPRO\\Discoteca.txt";

    public Arquivo() { //construtor
        this.arquivo = new File(caminho);
        if (!this.arquivo.exists()) {
            try {
                this.arquivo.createNewFile();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                        "Erro",
                        "Erro ao criar o arquivo" + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            } 
        } // fim do if
    } // fim do construtor 

    @Override
    public boolean salvar(Musica musica) {
        try {
            List<Musica> lista = get(); // declara um objeto lista com uma lista de contatos no metodo get
            lista.add(musica); //adiciona um novo contato
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
            out.writeObject(lista); // jogou no arquivo
            out.close(); // fechou
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Erro",
                    "Erro ao salvar a musica" + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }// fim do metodo 

    @Override
    public boolean excluir(Musica musica) {
        List<Musica> lista = get();
        lista.remove(musica);
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
            out.writeObject(lista);
            out.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Erro",
                    "Erro ao atualizar a musica" + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }// fim do metodo 

    @Override
    public List<Musica> get() {
        ObjectInputStream in = null;
        List<Musica> lista;
        if (arquivo.length() > 0) {
            try {
                in = new ObjectInputStream(new FileInputStream(arquivo));
                lista = (ArrayList<Musica>) in.readObject();
                in.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,
                        "Erro",
                        "Erro ao acessar o arquivo" + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } // fim do if 
        else {
            lista = new ArrayList<>(); // retorna lista vacia
        } // fim do else
        return lista;
    } // fim do metodo

    @Override
    public boolean atualizar(Musica musica) {
        List<Musica> lista = get();
        for (Musica mus : lista) {
            if (mus.getTituloMusica().equals(musica.getTituloMusica())) {
                mus.setNomeBanda(musica.getNomeBanda());
                mus.setGenero(musica.getGenero());
                mus.setLetraMusica(musica.getLetraMusica());
            }
        }
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo));
            out.writeObject(lista);
            out.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,
                    "Erro",
                    "Erro ao atualizar a musica" + ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
