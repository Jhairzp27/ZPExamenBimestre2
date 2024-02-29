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
        String rutaArchivo = "C:\\Users\\Zack_\\ZPExamenBimestre2\\src\\setAlimento.txt";

        // Crear la lista de larvas con alimentos asignados
        List<Hormiga> larvas = crearListaLarvas(rutaArchivo);

        // Mostrar el SplashAntBot
        SplashAntBot.show();

    }

    private static List<Hormiga> crearListaLarvas(String rutaArchivo) {
      List<String> alimentosDisponibles = leerAlimentosDesdeArchivo(rutaArchivo);
      List<Hormiga> larvas = new ArrayList<>();
      Random random = new Random();
      for (int i = 0; i < 40; i++) {
          String tipoAlimento = alimentosDisponibles.get(random.nextInt(alimentosDisponibles.size()));
          Larva larva = new Larva(tipoAlimento); // Crear instancia de Larva
          larvas.add(larva);
          System.out.println("Larva " + (i+1) + " comiendo \"" + tipoAlimento + "\"");
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
}
