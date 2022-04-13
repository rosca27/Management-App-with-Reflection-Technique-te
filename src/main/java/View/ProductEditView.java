package View;

import DataAcces.ProductDAO;
import Model.Products;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Interface for product view
 * All products are displayed into a list
 * Selected product by user will be modified
 */
public class ProductEditView {

    private JLabel titleLabel;
    private JButton exitButton;
    private JButton editButton;
    JFrame frame13 = new JFrame("All Clients");
    DefaultListModel v = new DefaultListModel();
    JList productsList;

    public ProductEditView() {

        titleLabel = new JLabel ("Product edit view");
        v = ProductDAO.viewProducts();
        productsList = new JList (v);
        exitButton = new JButton ("Exit");
        editButton = new JButton ("Edit");


        frame13.setSize(540, 480);
        frame13.setLayout(null);
        frame13.setVisible(true);
        frame13.setResizable(false);
        frame13.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

        exitButton.setFocusable(false);

        frame13.add(titleLabel);
        frame13.add(productsList);
        frame13.add(exitButton);
        frame13.add(editButton);


        titleLabel.setBounds (190, 15, 150, 25);
        productsList.setBounds (25, 60, 465, 315);
        exitButton.setBounds (80, 390, 105, 35);
        exitButton.setBounds (80, 390, 105, 35);
        editButton.setBounds (300, 390, 105, 35);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame13.dispose();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] x = productsList.getSelectedValue().toString().split(" ");
                Products product = new Products(x[1],Float.parseFloat(x[3]),Integer.parseInt(x[x.length-1]));
                frame13.dispose();
                new ProductEdit(product);
            }
        });

    }

}
