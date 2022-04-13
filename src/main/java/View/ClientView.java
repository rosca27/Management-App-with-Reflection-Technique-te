package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * This is the main interface for client
 * Here, the user can choose the operation to make on clients
 */
public class ClientView extends JPanel{

    private JLabel titleLabel;
    private JButton addButton;
    private JButton viewButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton exitButton;
    JFrame frame2 = new JFrame("Product");

    public ClientView() {


        titleLabel = new JLabel ("Client");
        addButton = new JButton ("Add Client");
        viewButton = new JButton ("View Clients");
        editButton = new JButton ("Edit Clients");
        deleteButton = new JButton ("Delete Clients");
        exitButton = new JButton ("Exit");


        frame2.setSize(520, 330);
        frame2.setLayout(null);
        frame2.setVisible(true);
        frame2.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

        frame2.add(titleLabel);
        frame2.add(addButton);
        frame2.add(viewButton);
        frame2.add(editButton);
        frame2.add(deleteButton);
        frame2.add(exitButton);


        titleLabel.setBounds (210, 20, 100, 25);
        addButton.setBounds (80, 85, 130, 50);
        viewButton.setBounds (255, 85, 130, 50);
        editButton.setBounds (255, 165, 130, 50);
        deleteButton.setBounds (80, 165, 130, 50);
        exitButton.setBounds (185, 240, 105, 35);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdaugareClienti();
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AllClients();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClientRemove();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClientEditView();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.dispose();
            }
        });

    }

}
