package br.com.gaalv.service;

import br.com.gaalv.model.Despesa;
import br.com.gaalv.repository.Repository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

public class Service {
    private final Repository repository;

    public Service(Repository repository) { this.repository = repository; }

    public boolean isValida(Despesa despesa) {
        if(despesa == null) return false;
        if(despesa.getDescricao() == null || despesa.getDescricao().isBlank()) return false;
        if(despesa.getValor() == null || despesa.getValor().signum() <= 0) return false;
        if(despesa.getData() == null) return false;
        if(despesa.getTipoPagamento() == null) return false;
        return !(despesa.getTipo() == null);
    }

    public void salvar(Despesa despesa) {
        if(!isValida(despesa)) throw new IllegalArgumentException("Despesa inválida: " + despesa);

        repository.salvar(despesa);
    }

    public void deletar(UUID idDespesa) {
        if(!repository.existe(idDespesa)) throw new NoSuchElementException("Despesa não encontrada: " + idDespesa);

        repository.remover(idDespesa);
    }

    public void atualizar(Despesa despesa) {
        if(!isValida(despesa)) throw new IllegalArgumentException("Despesa inválida: " + despesa);
        if(!repository.existe(despesa.getId())) throw new NoSuchElementException("Despesa não encontrada: " + despesa.getId());

        repository.atualizar(despesa);
    }

    public List<Despesa> listarTodas() { return List.copyOf(repository.listarTodas()); }
}
