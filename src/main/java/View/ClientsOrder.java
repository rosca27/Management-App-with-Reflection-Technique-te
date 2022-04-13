package View;

import DataAcces.ClientDAO;
import Model.Clients;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Interface for clients view
 * All clients are displayed into a list
 * Selected client will make an order
 */
public class ClientsOrder extends JPanel {

    private JLabel titleLabel;
    private JButton orderButton;
    JFrame frame14 = new JFrame("All Clients");
    DefaultListModel v = new DefaultListModel();
    JList clientsList;

    public ClientsOrder() {

        titleLabel = new JLabel ("Clients View");
        v = ClientDAO.viewClients();
        clientsList = new JList (v);
        orderButton = new JButton ("To order");


        frame14.setSize(540, 480);
        frame14.setLayout(null);
        frame14.setVisible(true);
        frame14.setResizable(false);
        frame14.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

        orderButton.setFocusable(false);

        frame14.add(titleLabel);
        frame14.add(clientsList);
        frame14.add(orderButton);


        titleLabel.setBounds (190, 15, 150, 25);
        clientsList.setBounds (25, 60, 465, 315);
        orderButton.setBounds (200, 390, 105, 35);
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] x=clientsList.getSelectedValue().toString().split(" ");
                Clients client = new Clients(x[1],x[2],x[6],Integer.parseInt(x[4]));
                new Order(client);
                frame14.dispose();
            }
        });
    }
}
