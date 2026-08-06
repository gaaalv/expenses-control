package main.java.br.com.gaalv.model.enums;

import main.java.br.com.gaalv.view.enums.OpcaoMenu;

public enum TipoPagamento implements OpcaoMenu {
    DEBITO(1, "Débito"),
    CREDITO(2, "Crédito"),
    PIX(3, "Pix"),
    DINHEIRO(4, "Dinheiro");

    private final int id;
    private final String descricao;

    TipoPagamento(int id, String descricao) { this.id = id; this.descricao = descricao; }

    @Override
    public int getId() { return id; }
    @Override
    public String getDescricao() { return descricao; }
}