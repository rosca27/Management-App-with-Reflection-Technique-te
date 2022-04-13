package View;

import BusinessLogic.ClientBBL;
import DataAcces.ClientDAO;
import Model.Clients;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Interface for clients view
 * All clients are displayed into a list
 * Selected client by user will be removed
 */
public class ClientRemove extends JPanel {

    private JLabel titleLabel;
    private JButton removeButton;
    JFrame frame5 = new JFrame("ClientRemove");
    DefaultListModel v = new DefaultListModel();
    JList clientsList;

    public ClientRemove() {

        titleLabel = new JLabel ("Client Remove");
        v = ClientDAO.viewClients();
        clientsList = new JList (v);
        removeButton = new JButton ("Remove");


        frame5.setSize(470, 480);
        frame5.setLayout(null);
        frame5.setVisible(true);
        frame5.setResizable(false);
        frame5.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

        removeButton.setFocusable(false);

        frame5.add(titleLabel);
        frame5.add(clientsList);
        frame5.add(removeButton);


        titleLabel.setBounds (2000, 15, 100, 25);
        clientsList.setBounds (25, 60, 400, 315);
        removeButton.setBounds (195, 385, 105, 35);

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] x=clientsList.getSelectedValue().toString().split(" ");
                Clients client = new Clients(x[1],x[2],x[6],Integer.parseInt(x[4]));
                ClientBBL.removeClient(client);
                frame5.dispose();
            }
        });
    }


}
