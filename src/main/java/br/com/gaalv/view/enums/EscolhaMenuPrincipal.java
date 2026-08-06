package br.com.gaalv.view.enums;

public enum EscolhaMenuPrincipal implements OpcaoMenu {
    ADICIONAR(1, "Adicionar"),
    REMOVER(2, "Remover"),
    ATUALIZAR(3, "Atualizar"),
    LISTAR(4, "Listar"),
    SAIR(5, "Sair");

    private final int id;
    private final String descricao;

    EscolhaMenuPrincipal(int id, String descricao) { this.id = id; this.descricao = descricao; }

    @Override
    public int getId() { return id; }
    @Override
    public String getDescricao() { return descricao; }
}
