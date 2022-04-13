package View;

import DataAcces.ClientDAO;
import Model.Clients;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Interface for clients view
 * All clients are displayed into a list
 * Selected client will be modified by user
 */
public class ClientEditView {

    private JLabel titleLabel;
    private JButton exitButton;
    private JButton editButton;
    JFrame frame11 = new JFrame("All Clients");
    DefaultListModel v = new DefaultListModel();
    JList clientsList;

    public ClientEditView() {

        titleLabel = new JLabel ("Clients edit view");
        v = ClientDAO.viewClients();
        clientsList = new JList (v);
        exitButton = new JButton ("Exit");
        editButton = new JButton ("Edit");


        frame11.setSize(540, 480);
        frame11.setLayout(null);
        frame11.setVisible(true);
        frame11.setResizable(false);
        frame11.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

        exitButton.setFocusable(false);

        frame11.add(titleLabel);
        frame11.add(clientsList);
        frame11.add(exitButton);
        frame11.add(editButton);


        titleLabel.setBounds (190, 15, 150, 25);
        clientsList.setBounds (25, 60, 465, 315);
        exitButton.setBounds (80, 390, 105, 35);
        exitButton.setBounds (80, 390, 105, 35);
        editButton.setBounds (300, 390, 105, 35);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame11.dispose();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] x = clientsList.getSelectedValue().toString().split(" ");
                Clients client = new Clients(x[1],x[2],x[6],Integer.parseInt(x[4]));
                new ClientEdit(client);
                frame11.dispose();
            }
        });

    }


}
