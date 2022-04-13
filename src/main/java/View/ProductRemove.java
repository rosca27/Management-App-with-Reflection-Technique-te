package View;

import BusinessLogic.ProductBBL;
import DataAcces.ProductDAO;
import Model.Products;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Interface for product view
 * All products are displayed into a list
 * Selected product by user will be deleted
 */
public class ProductRemove extends JPanel {

    private JLabel titleLabel;
    private JButton removeButton;
    JFrame frame10 = new JFrame("Remove Product");
    DefaultListModel v = new DefaultListModel();
    JList productsList;

    public ProductRemove() {

        titleLabel = new JLabel ("Clients View");
        v = ProductDAO.viewProducts();
        productsList = new JList (v);
        removeButton = new JButton ("Remove");


        frame10.setSize(430, 480);
        frame10.setLayout(null);
        frame10.setVisible(true);
        frame10.setResizable(false);
        frame10.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

        removeButton.setFocusable(false);

        frame10.add(titleLabel);
        frame10.add(productsList);
        frame10.add(removeButton);


        titleLabel.setBounds (160, 15, 100, 25);
        productsList.setBounds (25, 60, 365, 315);
        removeButton.setBounds (145, 385, 105, 35);
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String x[] = productsList.getSelectedValue().toString().split(" ");
                Products product = new Products(x[1],Float.parseFloat(x[3]),5);
                ProductBBL.removeProduct(product);
                frame10.dispose();
            }
        });
    }

}
