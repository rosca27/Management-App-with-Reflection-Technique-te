package View;

import DataAcces.ProductDAO;
import Model.Products;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Interface for products view
 * All products are displayed into a list
 */
public class AllProducts extends JPanel {

    private JLabel titleLabel;
    private JButton exitButton;
    JFrame frame7 = new JFrame("All Products");
    DefaultListModel v = new DefaultListModel();
    JList clientsList;

    public AllProducts() {

        titleLabel = new JLabel ("Products View");
        v = ProductDAO.viewProducts();
        clientsList = new JList (v);
        exitButton = new JButton ("Exit");


        frame7.setSize(430, 480);
        frame7.setLayout(null);
        frame7.setVisible(true);
        frame7.setResizable(false);
        frame7.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

        exitButton.setFocusable(false);

        frame7.add(titleLabel);
        frame7.add(clientsList);
        frame7.add(exitButton);


        titleLabel.setBounds (160, 15, 100, 25);
        clientsList.setBounds (25, 60, 365, 315);
        exitButton.setBounds (145, 385, 105, 35);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame7.dispose();
            }
        });

    }
}
