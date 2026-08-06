package br.com.gaalv.model.enums;

import br.com.gaalv.view.enums.OpcaoMenu;

public enum TipoDespesa implements OpcaoMenu {
    ALIMENTACAO(1, "Alimentação"),
    TRANSPORTE(2, "Transporte"),
    GASTO_FIXO(3, "Gastos Fixo"),
    LAZER(4, "Lazer"),
    MORADIA(5, "Moradia"),
    ESTUDOS(6, "Estudos"),
    OUTROS(7, "Outras Categorias");

    private final int id;
    private final String descricao;

    TipoDespesa(int id, String descricao) { this.id = id; this.descricao = descricao; }

    @Override
    public int getId() { return id; }
    @Override
    public String getDescricao() { return descricao; }
}