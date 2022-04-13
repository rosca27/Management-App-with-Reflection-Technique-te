package View;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the main interface
 * From here the user can choose between products, order or clients
 */
public class MainView  extends JPanel {
    private JButton clientButton;
    private JButton orderButton;
    private JButton productButton;
    private JButton exitButton;
    private JLabel titleLabel;
    JFrame frame = new JFrame("Main View");

    public MainView() {


        clientButton = new JButton ("Client");
        orderButton = new JButton ("Order");
        productButton = new JButton ("Product");
        exitButton = new JButton ("Exit");
        titleLabel = new JLabel ("Management Application");


        frame.setSize(510, 320);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(clientButton);
        frame.add(orderButton);
        frame.add(productButton);
        frame.add(exitButton);
        frame.add(titleLabel);


        clientButton.setBounds (30, 110, 115, 50);
        orderButton.setBounds (195, 110, 110, 50);
        productButton.setBounds (340, 110, 125, 50);
        exitButton.setBounds (195, 215, 110, 35);
        titleLabel.setBounds (175, 35, 155, 25);

        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClientView();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProductView();
            }
        });

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClientsOrder();
            }
        });

    }

}
