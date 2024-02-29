/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| pdavila0113@gmail.com      BaphomeT-T  |
|----------------------------------------|
Autor : BaphomeT-T
Fecha : 25.feb.2k24
*/

package BusinessLogic.Entities;

public class Herviboro extends ZPAlimento{

    @Override
    public void zpAlimento() {
        System.out.println("Comiendo comida hervibora");
    }

    @Override
    public String toString() {
        // Implementación específica de toString para un hervíboro
        return "Herviboro";
    }
}
