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
        //
    }
}
