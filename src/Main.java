
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaJugo ventana = new VentanaJugo();
            ventana.setVisible(true);
        });
    }
}
