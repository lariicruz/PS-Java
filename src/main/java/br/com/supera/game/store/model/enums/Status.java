package br.com.supera.game.store.model.enums;

public enum Status {

    PENDENTE(1, "Pendente"), QUITADO(2, "Quitado"), CANCELADO(3, "Cancelado");

    private Integer cod;
    private String description;

    private Status(Integer cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }
    public static Status toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (Status x : Status.values()) {
            if (cod.equals(x.getCod())) {
                return x;
            }

        }

        throw new IllegalArgumentException("Id Inválido: " + cod);

    }
}
