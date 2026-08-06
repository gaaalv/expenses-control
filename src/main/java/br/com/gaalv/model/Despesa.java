package main.java.br.com.gaalv.model;

import main.java.br.com.gaalv.model.enums.TipoDespesa;
import main.java.br.com.gaalv.model.enums.TipoPagamento;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Despesa {
    private final UUID id;
    private LocalDate data;
    private String descricao;
    private BigDecimal valor;
    private TipoPagamento tipoPagamento;
    private TipoDespesa tipo;
    private String observacao;

    public Despesa(LocalDate data, String descricao, BigDecimal valor,
                   TipoPagamento tipoPagamento, TipoDespesa tipo, String observacao) {
        this.id = UUID.randomUUID();
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
        this.tipo = tipo;
        this.observacao = observacao;
    }

    public Despesa(UUID id, LocalDate data, String descricao, BigDecimal valor,
                   TipoPagamento tipoPagamento, TipoDespesa tipo, String observacao) {
        this.id = id;
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
        this.tipo = tipo;
        this.observacao = observacao;
    }

    public UUID getId() { return id; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public TipoPagamento getTipoPagamento() { return tipoPagamento; }
    public void setTipoPagamento(TipoPagamento tipoPagamento) { this.tipoPagamento = tipoPagamento; }

    public TipoDespesa getTipo() { return tipo; }
    public void setTipo(TipoDespesa tipo) { this.tipo = tipo; }

    public String getObservacao() { return observacao; }
    public void setObservacao(String observacao) { this.observacao = observacao; }
}

