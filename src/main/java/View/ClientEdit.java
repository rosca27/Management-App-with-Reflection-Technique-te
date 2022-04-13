package View;

import BusinessLogic.ClientBBL;
import Model.Clients;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;
/**
 * Interface for editing a client
 */
public class ClientEdit {
    private JLabel titleLabel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel ageLabel;
    private JLabel eMailLabel;
    private JTextField nameText;
    private JTextField surnameText;
    private JComboBox ageCombo;
    private JTextField eMailText;
    private JButton editButton;
    JFrame frame12 = new JFrame("Clients Edit");

    public ClientEdit(Clients client) {

        String[] ageComboItems = {"12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"};


        titleLabel = new JLabel ("Clients Edit");
        nameLabel = new JLabel ("Name:");
        surnameLabel = new JLabel ("Surname:");
        ageLabel = new JLabel ("Age:");
        eMailLabel = new JLabel ("e-Mail:");
        nameText = new JTextField ();
        surnameText = new JTextField ();
        ageCombo = new JComboBox (ageComboItems);
        eMailText = new JTextField (5);
        editButton = new JButton ("Edit");

        frame12.setSize(500,300);
        frame12.setLayout(null);
        frame12.setResizable(false);
        frame12.setVisible(true);
        frame12.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

        editButton.setFocusable(false);

        frame12.add(titleLabel);
        frame12.add(nameLabel);
        frame12.add(surnameLabel);
        frame12.add(ageLabel);
        frame12.add(eMailLabel);
        frame12.add(nameText);
        frame12.add(surnameText);
        frame12.add(ageCombo);
        frame12.add(eMailText);
        frame12.add(editButton);

        titleLabel.setBounds (175, 25, 100, 25);
        nameLabel.setBounds (40, 80, 45, 25);
        surnameLabel.setBounds (240, 80, 100, 25);
        ageLabel.setBounds (40, 145, 35, 25);
        eMailLabel.setBounds (240, 145, 100, 25);
        nameText.setBounds (90, 80, 115, 25);
        surnameText.setBounds (310, 80, 115, 25);
        ageCombo.setBounds (95, 145, 70, 25);
        eMailText.setBounds (310, 145, 115, 25);
        editButton.setBounds (180, 195, 100, 35);

        eMailText.setText(client.getClienteMail());
        nameText.setText(client.getName());
        surnameText.setText(client.getClientSurname());
        ageCombo.setSelectedIndex(client.getAge()-12);

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Object> c = new ArrayList<>();
                c.add(getName());
                c.add(getSurname());
                c.add(getEMail());
                c.add(getAge());
                ClientBBL.editClient(client,c);
                frame12.dispose();
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
