package main.java.br.com.gaalv.controller;

import main.java.br.com.gaalv.model.Despesa;
import main.java.br.com.gaalv.model.enums.TipoDespesa;
import main.java.br.com.gaalv.model.enums.TipoPagamento;
import main.java.br.com.gaalv.service.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public Despesa cadastrarDespesa(LocalDate data, String descricao, BigDecimal valor,
                                    TipoPagamento pagamento, TipoDespesa tipo, String obs) {
        Despesa novaDespesa = new Despesa(data, descricao, valor, pagamento, tipo, obs);
        service.salvar(novaDespesa);
        return novaDespesa;
    }

    public void deletarDespesa(UUID idDespesa) {
        service.deletar(idDespesa);
    }

    public Despesa atualizarDespesa(UUID idDespesa, LocalDate data, String descricao, BigDecimal valor,
                                    TipoPagamento pagamento, TipoDespesa tipo, String obs) {
        Despesa despesaAtualizada = new Despesa(idDespesa, data, descricao, valor, pagamento, tipo, obs);
        service.atualizar(despesaAtualizada);
        return despesaAtualizada;
    }

    public List<Despesa> listarDespesas() { return service.listarTodas(); }
}