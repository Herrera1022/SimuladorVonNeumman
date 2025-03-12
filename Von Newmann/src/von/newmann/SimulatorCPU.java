/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package von.newmann;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author juanh
 */
public class SimulatorCPU extends javax.swing.JFrame {
    private JTextArea infoInstrucciones, salidaPrograma;
    private JButton botonEjecutar;
    private JComboBox<String> selectorPrograma;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   

    public SimulatorCPU() {
        setTitle("Simulador de CPU");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Panel de información de instrucciones
        infoInstrucciones = new JTextArea();
        infoInstrucciones.setEditable(false);
        infoInstrucciones.setFont(new Font("Monospaced", Font.PLAIN, 14));
        infoInstrucciones.setText("""
                                  Informaci\u00f3n de instrucciones
                                  +--------------------------+
                                  | Inst | D  | Comentario  |
                                  +--------------------------+
                                  | 0000 | +  | Suma        |
                                  | 0001 | -  | Resta       |
                                  | 0010 | *  | Producto    |
                                  | 0011 | ^  | Exponente   |
                                  | 0100 | &  | Operador AND|
                                  | 0101 | |  | Operador OR |
                                  | 0110 | M  | Mover a mem |
                                  | 0111 | \u2026  | Finalizar   |
                                  +--------------------------+
                                  """);
        add(new JScrollPane(infoInstrucciones), BorderLayout.NORTH);
        
        // Panel de selección de programa
        String[] programas = {
                "5 + 11",
                "(1 + 1) ^ 5",
                "01001011 OR 01010101",
                "01001011 AND 01010101",
                "255 + 1",
                "((2 ^ 2) + 2) ^ 2",
                "(8 - 3) ^ 3"
        };
        selectorPrograma = new JComboBox<>(programas);
        add(selectorPrograma, BorderLayout.CENTER);
        
        // Panel de ejecución y salida
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BorderLayout());
        botonEjecutar = new JButton("Ejecutar");
        salidaPrograma = new JTextArea(5, 30);
        salidaPrograma.setEditable(false);
        
        botonEjecutar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarPrograma();
            }
        });
        
        panelInferior.add(botonEjecutar, BorderLayout.NORTH);
        panelInferior.add(new JScrollPane(salidaPrograma), BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    private void ejecutarPrograma() {
        String programaSeleccionado = (String) selectorPrograma.getSelectedItem();
        String resultado = "";
        int acumulador;
        
        switch (programaSeleccionado) {
            case "5 + 11":
                acumulador = 5;
                acumulador += 11;
                resultado = "5 + 11 = " + acumulador;
                break;
            case "(1 + 1) ^ 5":
                acumulador = 1 + 1;
                acumulador = (int) Math.pow(acumulador, 5);
                resultado = "(1 + 1) ^ 5 = " + acumulador;
                break;
            case "01001011 OR 01010101":
                acumulador = Integer.parseInt("01001011", 2) | Integer.parseInt("01010101", 2);
                resultado = "01001011 OR 01010101 = " + String.format("%08d", Integer.parseInt(Integer.toBinaryString(acumulador)));
                break;
            case "01001011 AND 01010101":
                acumulador = Integer.parseInt("01001011", 2) & Integer.parseInt("01010101", 2);
                resultado = "01001011 AND 01010101 = " + String.format("%08d", Integer.parseInt(Integer.toBinaryString(acumulador)));
                break;
            case "255 + 1":
                acumulador = 255;
                acumulador += 1;
                resultado = (acumulador > 255) ? "255 + 1 = OVERFLOW" : "255 + 1 = " + acumulador;
                break;
            case "((2 ^ 2) + 2) ^ 2":
                acumulador = (int) Math.pow(2, 2);
                acumulador += 2;
                acumulador = (int) Math.pow(acumulador, 2);
                resultado = "((2 ^ 2) + 2) ^ 2 = " + acumulador;
                break;
            case "(8 - 3) ^ 3":
                acumulador = 8 - 3;
                acumulador = (int) Math.pow(acumulador, 3);
                resultado = "(8 - 3) ^ 3 = " + acumulador;
                break;
        }
        
        salidaPrograma.setText(resultado);
    }

    public static void main(String[] args) {
        SimulatorCPU simulatorCPU = new SimulatorCPU();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
