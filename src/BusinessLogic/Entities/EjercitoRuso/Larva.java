package BusinessLogic.Entities.EjercitoRuso;

import BusinessLogic.Entities.ZPAlimento;

public class Larva extends Hormiga{

    @Override
    public boolean comer(ZPAlimento alimento) {
        // TODO Auto-generated method stub
        return false;
    }

    public Larva(String tipo) {
        super(tipo);
    }

    public void consumirAlimento(String tipoAlimento) {
        if (tipoAlimento.equalsIgnoreCase("Herbivoro")) {
            System.out.println("Larva transformada en Rastreadora");
            // Se transforma en Rastreadora
            setTipo("Rastreadora");
        } else {
            System.out.println("Alimento incorrecto. La larva muere.");
            // La larva muere
            setTipo("Muerta");
        }
    }
}
