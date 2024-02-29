package BusinessLogic.Entities.EjercitoRuso;

import BusinessLogic.Entities.ZPIHormiga;

public abstract class Hormiga implements ZPIHormiga {
    private String tipo;
    private int codigoUnico;

    public Hormiga(String tipo) {
        this.tipo = tipo;
    }

    // Agregar un getter para obtener el tipo de alimento
    public String getTipo() {
        return tipo;
    }

    // Agregar un setter para establecer el tipo de alimento
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
