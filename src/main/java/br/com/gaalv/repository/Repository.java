package br.com.gaalv.repository;

import br.com.gaalv.model.Despesa;

import java.util.List;
import java.util.UUID;

public interface Repository {
    public boolean salvar(Despesa despesa);

    public boolean remover(UUID idDespesa);

    public boolean atualizar(Despesa despesa);

    public boolean existe(UUID idDespesa);

    public List<Despesa> listarTodas();
}