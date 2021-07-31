package br.com.supera.game.store.model.enums;

public enum StatusEnum {

    PENDENTE(1L, "Pendente"),
    QUITADO(2L, "Quitado"),
    CANCELADO(3L, "Cancelado");

    private Long cod;
    private String description;

    private StatusEnum(Long cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public Long getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    public static StatusEnum toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (StatusEnum x : StatusEnum.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }

        }

        throw new IllegalArgumentException("Id Inválido: " + cod);

    }
}
