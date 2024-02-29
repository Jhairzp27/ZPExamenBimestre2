package BusinessLogic.Entities;

public class Herviboro extends ZPAlimento{

    @Override
    public void zpAlimento() {
        System.out.println("Comiendo hervioro");
    }

    @Override
    public String toString() {
        // Implementación específica de toString para un hervíboro
        return "Herviboro";
    }
}
