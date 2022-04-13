package View;

import BusinessLogic.ProductBBL;
import DataAcces.ProductDAO;
import Model.Products;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * In this interface the user can edit a product by modify values in one or more fields
 */
public class ProductEdit {

    private JLabel titleLabel;
    private JLabel nameLabel;
    private JTextField nameText;
    private JLabel priceLabel;
    private JTextField priceText;
    private JButton editButton;
    private JTextField stockText;
    private JLabel stockLabel;
    JFrame frame13 = new JFrame("Product Edit");

    public ProductEdit(Products product) {

        titleLabel = new JLabel ("Product Edit");
        nameLabel = new JLabel ("Product name:");
        nameText = new JTextField (0);
        priceLabel = new JLabel ("Product price:");
        priceText = new JTextField (0);
        editButton = new JButton ("Edit");
        stockText = new JTextField();
        stockLabel = new JLabel("Stock");

        frame13.setSize(480,280);
        frame13.setLayout(null);
        frame13.setVisible(true);
        frame13.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        editButton.setFocusable(false);

        frame13.add(titleLabel);
        frame13.add(nameLabel);
        frame13.add(nameText);
        frame13.add(priceLabel);
        frame13.add(priceText);
        frame13.add(editButton);
        frame13.add(stockLabel);
        frame13.add(stockText);

        priceText.setText(String.valueOf(product.getProductPrice()));
        nameText.setText(product.getProductName());
        stockText.setText(String.valueOf(product.getProductStock()));

        titleLabel.setBounds (200, 25, 100, 25);
        nameLabel.setBounds (15, 100, 100, 25);
        nameText.setBounds (100, 100, 115, 25);
        priceLabel.setBounds (240, 100, 100, 25);
        priceText.setBounds (325, 100, 110, 25);
        editButton.setBounds (185, 185, 100, 35);
        stockLabel.setBounds(130,135,100,25);
        stockText.setBounds(200,135,115,25);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Object> z = new ArrayList<Object>();
                z.add(getName());
                z.add(getPrice());
                z.add(getStock());
                ProductBBL.editProduct(product,z);
                frame13.dispose();
            }
        });
    }

    public float getPrice(){
        return Float.parseFloat(priceText.getText());
    }
    public String getName(){
        return String.valueOf(nameText.getText());
    }
    public int getStock(){ return Integer.parseInt(stockText.getText());}

}
