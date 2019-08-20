package br.com.projeto;

import java.util.List;

public interface Inter {

    public abstract boolean salvar(Musica musica);

    public abstract boolean atualizar(Musica musica);

    public abstract boolean excluir(Musica musica);

    public abstract List<Musica> get();
}
