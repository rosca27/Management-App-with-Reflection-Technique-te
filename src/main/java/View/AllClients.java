package View;

import DataAcces.ClientDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Interface for clients view
 * All clients are displayed into a list
 */
public class AllClients extends JPanel {

    private JLabel titleLabel;
    private JButton exitButton;
    JFrame frame6 = new JFrame("All Clients");
    DefaultListModel v = new DefaultListModel();
    JList clientsList;

    public AllClients() {

        titleLabel = new JLabel ("Clients View");
        v = ClientDAO.viewClients();
        clientsList = new JList (v);
        exitButton = new JButton ("Exit");


        frame6.setSize(540, 480);
        frame6.setLayout(null);
        frame6.setVisible(true);
        frame6.setResizable(false);
        frame6.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

        exitButton.setFocusable(false);

        frame6.add(titleLabel);
        frame6.add(clientsList);
        frame6.add(exitButton);


        titleLabel.setBounds (190, 15, 150, 25);
        clientsList.setBounds (25, 60, 465, 315);
        exitButton.setBounds (200, 390, 105, 35);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame6.dispose();
            }
        });
    }
}
