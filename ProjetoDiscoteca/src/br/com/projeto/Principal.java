package br.com.projeto;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Principal {

    static List<Musica> musicas = new ArrayList<>();

    public static void main(String[] args) {
        Arquivo inter = new Arquivo();
        Musica m = null;
        int opMenuMusica;
        int opMusica;
        boolean opcao = true;
        JOptionPane.showMessageDialog(null, ".......BEM VINDO A NOSSA DISCOTECA!!!......");
        while (opcao) {

            opMenuMusica = Integer.parseInt(JOptionPane.showInputDialog("....MENU....\n"
                    + "1 - Cadastrar\n"
                    + "2 - Opções de Musica\n"
                    + "3 - Sair"));

            switch (opMenuMusica) {
                // Cadastrando genero, musica, titulo e letra
                case 1: {
                    m = new Musica();
                    m.setMusica();
                    musicas.add(m);
                    if (inter.salvar(m)) {
                        JOptionPane.showMessageDialog(null, "Musica salva!");
                    }
                    JOptionPane.showMessageDialog(null, "Cadastrado com sucesso..\n"
                            + "Numeros de cadastrados: \n" + musicas.size()); // size tamanho da lista
                    break;
                } // fim do caso 1

                case 2: {
                    opMusica = Integer.parseInt(JOptionPane.showInputDialog("....MENU....\n"
                            + "1 - Exibir Letra\n"
                            + "2 - Remover\n"
                            + "3 - Voltar"));

                    switch (opMusica) {
                        // Exibindo a letra da musica selecionada
                        case 1: {
                            String parteNome = JOptionPane.showInputDialog("Digite uma parte da musica que você deseja: ");
                            List<Musica> selecionada = exibeLetra(parteNome);
                            String txt = "Musicas encontradas\n";
                            for (int i = 0; i < selecionada.size(); i++) {
                                txt += i + 1 + " - " + selecionada.get(i).getTituloMusica() + "\n";
                            } // fim do for

                            JOptionPane.showMessageDialog(null, txt);
                            int numeroMus = Integer.parseInt(JOptionPane.showInputDialog("Selecione um numero da musica\n"));
                            String musicSelect = selecionada.get(numeroMus - 1).getLetraMusica();
                            JOptionPane.showMessageDialog(null, "A letra da musica é: \n" + musicSelect);
                            break;
                        } // fim do caso 1

                        case 2: { // Removendo uma musica
                            String parteNome = JOptionPane.showInputDialog("Digite uma parte da musica que você deseja remover: ");
                            List<Musica> musicasSelecionadas = exibeLetra(parteNome);
                            String txt = "Musicas encontradas\n";
                            for (int i = 0; i < musicasSelecionadas.size(); i++) {
                                txt += i + 1 + " - " + musicasSelecionadas.get(i).getTituloMusica() + "\n";
                            } // fim do for
                            int numeroMusRemove = Integer.parseInt(JOptionPane.showInputDialog("Qual musica você quer remover? \n" + txt));
                            musicas.remove(numeroMusRemove - 1);
                            if (inter.excluir(m)) {
                                JOptionPane.showMessageDialog(null, "Musica removida!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Musica não encontrada!");
                            }
                            for (Musica musc : musicas) {
                                JOptionPane.showMessageDialog(null, "Musicas restantes: \n" + musicas.size());
                                
                            } // fim do for
                            break;
                        } // fim do caso 2

                        // Voltar ao menu inicial
                        case 3: {
                            break;
                        } // fim do caso 3

                    } // fim do switch
                    break;

                } // fim do caso 2
                // Sair
                case 3: {
                    opcao = false;
                    break;
                } // fim do caso 3

            } // fim do witch
        }// fim do while
    } // fim do main

    private static List<Musica> exibeLetra(String parteNome) { // Exibindo letra da musica selecionada
        List<Musica> listaPesquisa = new ArrayList<>();
        for (Musica musics : musicas) {
            if (musics.getNomeBanda().contains(parteNome)) {
                listaPesquisa.add(musics);
            } // fim do if
        } // fim do for
        return listaPesquisa;

    } // fim do metodo

} // fim da principal
