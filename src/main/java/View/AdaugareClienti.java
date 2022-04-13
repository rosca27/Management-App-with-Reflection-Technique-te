/**
 * This package contains all interfaces
 */
package View;

import BusinessLogic.ClientBBL;
import Model.Clients;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * In this interface the user can insert a client by inserting values in all fields
 */
public class AdaugareClienti extends JPanel {

    private JLabel titleLabel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel ageLabel;
    private JLabel eMailLabel;
    private JTextField nameText;
    private JTextField surnameText;
    private JComboBox ageCombo;
    private JTextField eMailText;
    public JButton addButton;
    JFrame frame4 = new JFrame("Clients Add");

    public AdaugareClienti() {

        String[] ageComboItems = {"12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"};


        titleLabel = new JLabel ("Clients Add");
        nameLabel = new JLabel ("Name:");
        surnameLabel = new JLabel ("Surname:");
        ageLabel = new JLabel ("Age:");
        eMailLabel = new JLabel ("e-Mail:");
        nameText = new JTextField ();
        surnameText = new JTextField ();
        ageCombo = new JComboBox (ageComboItems);
        eMailText = new JTextField (5);
        addButton = new JButton ("Add");

        frame4.setSize(500,300);
        frame4.setLayout(null);
        frame4.setResizable(false);
        frame4.setVisible(true);
        frame4.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

        addButton.setFocusable(false);

        frame4.add(titleLabel);
        frame4.add(nameLabel);
        frame4.add(surnameLabel);
        frame4.add(ageLabel);
        frame4.add(eMailLabel);
        frame4.add(nameText);
        frame4.add(surnameText);
        frame4.add(ageCombo);
        frame4.add(eMailText);
        frame4.add(addButton);

        titleLabel.setBounds (175, 25, 100, 25);
        nameLabel.setBounds (40, 80, 45, 25);
        surnameLabel.setBounds (240, 80, 100, 25);
        ageLabel.setBounds (40, 145, 35, 25);
        eMailLabel.setBounds (240, 145, 100, 25);
        nameText.setBounds (90, 80, 115, 25);
        surnameText.setBounds (310, 80, 115, 25);
        ageCombo.setBounds (95, 145, 70, 25);
        eMailText.setBounds (310, 145, 115, 25);
        addButton.setBounds (180, 195, 100, 35);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Clients client = new Clients(getName(),getSurname(),getEMail(),getAge());
                ClientBBL.addNewClient(client);
                frame4.dispose();
            }
        });

    }

    public String getName(){
        return nameText.getText().toString();
    }

    public String getSurname(){
        return surnameText.getText().toString();
    }

    public int getAge(){
        return Integer.parseInt((String) Objects.requireNonNull(ageCombo.getSelectedItem()));
    }

    public String getEMail(){
        return String.valueOf(eMailText.getText());
    }
}
