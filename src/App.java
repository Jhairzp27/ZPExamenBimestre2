import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;

import BusinessLogic.Entities.EjercitoRuso.Hormiga;
import BusinessLogic.Entities.EjercitoRuso.Larva;
import UserInterface.Form.SplashAntBot;

public class App {
    public static void main(String[] args) throws Exception {

        try {
            UIManager.setLookAndFeel(new FlatAtomOneDarkIJTheme());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Ruta del archivo setAlimento.txt
        String rutaArchivo = "src\\setAlimento.txt";

        // Crear la lista de larvas con alimentos asignados
        List<Hormiga> larvas = crearListaLarvas(rutaArchivo);

        // Mostrar el SplashAntBot
        SplashAntBot.show();

        // Mostrar la información de las larvas
        mostrarInformacionLarvas(larvas);
    }

    private static List<Hormiga> crearListaLarvas(String rutaArchivo) {
        List<String> alimentosDisponibles = leerAlimentosDesdeArchivo(rutaArchivo);
        List<Hormiga> larvas = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 40; i++) {
            String tipoAlimento = alimentosDisponibles.get(random.nextInt(alimentosDisponibles.size()));
            Larva larva = new Larva(tipoAlimento); // Crear instancia de Larva
            larvas.add(larva);
            System.out.println("Larva " + (i + 1) + " comiendo \"" + tipoAlimento + "\"");
            larva.consumirAlimento(tipoAlimento); // Consumir alimento y aplicar transformación si es necesario
            alimentosDisponibles.remove(tipoAlimento); // Eliminar el alimento consumido
            actualizarArchivo(rutaArchivo, alimentosDisponibles); // Actualizar el archivo de alimentos
        }
        return larvas;
    }

    private static List<String> leerAlimentosDesdeArchivo(String rutaArchivo) {
        List<String> alimentos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                alimentos.add(linea.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return alimentos;
    }

    private static void actualizarArchivo(String rutaArchivo, List<String> alimentos) {
        // Lógica para actualizar el archivo con la lista de alimentos
    }

    private static void mostrarInformacionLarvas(List<Hormiga> larvas) {
        System.out.println("\nInformación de las larvas:");
        System.out.println("--------------------------------------------------");
        System.out.println("|  Id  | CodigoHormiga | ClasificacionHormiga | Comio | Estado | Recogio |");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < larvas.size(); i++) {
            Larva larva = (Larva) larvas.get(i);
            String clasificacion = larva.getTipo().equals("Rastreadora") ? "Rastreadora" : "Normal"; // Si el tipo de alimento es "Herviboro", la larva está normal, de lo contrario, está muerta
            String comio = larva.getTipo().equals("Muerta") ? "No" : "Sí"; // Si comió, la larva está viva, de lo contrario, está muerta
            String estado = larva.getTipo().equals("Muerta") ? "Muerta" : "Viva"; // Si comió, la larva está viva, de lo contrario, está muerta
            String recogio = larva.getTipo().equals("Rastreadora") ? "Sí" : "No"; // Indicar si la larva recogió alimento
        }
        System.out.println("--------------------------------------------------");
    }
}
