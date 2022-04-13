package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * This is the main interface for client
 * Here, the user can choose the operation to make on products
 */
public class ProductView extends JPanel {

    private JLabel titleLabel;
    private JButton addButton;
    private JButton viewButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton exitButton;
    JFrame frame3 = new JFrame("Product");

    public ProductView() {


        titleLabel = new JLabel ("Product");
        addButton = new JButton ("Add Product");
        viewButton = new JButton ("View Products");
        editButton = new JButton ("Edit Product");
        deleteButton = new JButton ("Delete Product");
        exitButton = new JButton ("Exit");


        frame3.setSize(520, 330);
        frame3.setLayout(null);
        frame3.setVisible(true);
        frame3.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

        frame3.add(titleLabel);
        frame3.add(addButton);
        frame3.add(viewButton);
        frame3.add(editButton);
        frame3.add(deleteButton);
        frame3.add(exitButton);


        titleLabel.setBounds (210, 20, 100, 25);
        addButton.setBounds (80, 85, 130, 50);
        viewButton.setBounds (255, 85, 130, 50);
        editButton.setBounds (255, 165, 130, 50);
        deleteButton.setBounds (80, 165, 130, 50);
        exitButton.setBounds (185, 240, 105, 35);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProductAdd();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AllProducts();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProductRemove();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame3.dispose();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProductEditView();
            }
        });
    }
}
