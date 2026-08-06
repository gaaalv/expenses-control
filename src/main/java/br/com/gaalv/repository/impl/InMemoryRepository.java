package main.java.br.com.gaalv.repository.impl;

import main.java.br.com.gaalv.model.Despesa;
import main.java.br.com.gaalv.repository.Repository;

import java.util.*;

public class InMemoryRepository implements Repository {
    private final Map<UUID, Despesa> database = new HashMap<>();

    @Override
    public boolean salvar(Despesa despesa) { return database.put(despesa.getId(), despesa) == null; }

    @Override
    public boolean remover(UUID idDespesa) { return database.remove(idDespesa) != null; }

    @Override
    public boolean atualizar(Despesa despesa) { return database.put(despesa.getId(), despesa) != null; }

    @Override
    public boolean existe(UUID idDespesa) { return database.containsKey(idDespesa); }

    @Override
    public List<Despesa> listarTodas() {
        return database.values()
                .stream()
                .sorted(
                        Comparator.comparing(Despesa::getData)
                                .thenComparing(Despesa::getDescricao))
                .toList();
    }
}