
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaJugo extends JFrame {
    private GestorJugos gestorJugos;
    private JTextArea areaDeTexto;
    private JComboBox<String> listaJugos;
    private JLabel etiquetaPrecio;

    public VentanaJugo() {
        gestorJugos = new GestorJugos();
        setTitle("Ventas de Jugos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Configuración de colores
        getContentPane().setBackground(Color.PINK);
        areaDeTexto = new JTextArea();
        areaDeTexto.setEditable(false);
        areaDeTexto.setBackground(Color.PINK);
        areaDeTexto.setForeground(Color.BLACK);
        JScrollPane panelDesplazable = new JScrollPane(areaDeTexto);
        add(panelDesplazable, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel();
        panelInferior.setBackground(Color.PINK);
        String[] jugos = {"Fresa", "Guanábana", "Mango"};
        listaJugos = new JComboBox<>(jugos);
        JButton botonVender = new JButton("Vender Jugo");
        etiquetaPrecio = new JLabel("Precio: $0");

        panelInferior.add(new JLabel("Selecciona tu jugo:"));
        panelInferior.add(listaJugos);
        panelInferior.add(botonVender);
        panelInferior.add(etiquetaPrecio);
        add(panelInferior, BorderLayout.SOUTH);

        botonVender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jugoSeleccionado = (String) listaJugos.getSelectedItem();
                gestorJugos.registrarVenta(jugoSeleccionado);
                actualizarPantalla(jugoSeleccionado);
            }
        });

        actualizarPantalla(null);
    }

    private void actualizarPantalla(String jugoSeleccionado) {
        areaDeTexto.setText(gestorJugos.obtenerResumenVentas());
        if (jugoSeleccionado != null) {
            etiquetaPrecio.setText("Precio: $" + gestorJugos.obtenerPrecio(jugoSeleccionado));
        }
    }
}
