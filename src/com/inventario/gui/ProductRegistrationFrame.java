package com.inventario.gui;

import javax.swing.*;
import java.awt.*;
import com.inventario.model.*;

public class ProductRegistrationFrame extends JFrame {
    private JTextField nameField, priceField, quantityField;
    private JButton saveButton;
    private JTable productTable;
    private ProductTableModel tableModel;

    public ProductRegistrationFrame(){
        setTitle("Registro de productos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents(){
        // Panel para los campos de entrada
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Nombre:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Precio:"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        inputPanel.add(new JLabel("Cantidad:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);

        saveButton = new JButton("Guardar");
        saveButton.addActionListener(e -> saveProduct());

        inputPanel.add(saveButton);

        //Tabla para mostrar productos
        tableModel = new ProductTableModel();
        productTable = new JTable(tableModel);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(productTable), BorderLayout.CENTER);

    }
    private void saveProduct(){
        //lógica de guardado
        String name = nameField.getText();
        double price;
        int quantity;

        try {
            price = Double.parseDouble(priceField.getText());
            quantity = Integer.parseInt(quantityField.getText());
            int id = tableModel.getRowCount() + 1; // ID simple basado en la cantidad de filas
            Product product = new Product(id, name, price, quantity);
            tableModel.addProduct(product);
            nameField.setText("");
            priceField.setText("");
            quantityField.setText("");
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Por favor, ingrese valores válidos para precio y cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
