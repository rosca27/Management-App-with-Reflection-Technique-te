package View;

import BusinessLogic.ProductBBL;
import DataAcces.ProductDAO;
import Model.Products;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * In this interface the user can insert a product by inserting values in all fields
 */
public class ProductAdd extends JPanel {
    private JLabel titleLabel;
    private JLabel nameLabel;
    private JTextField nameText;
    private JLabel priceLabel;
    private JTextField priceText;
    private JButton addButton;
    private JTextField stockText;
    private JLabel stockLabel;
    JFrame frame9 = new JFrame("Product add");

    public ProductAdd() {

        titleLabel = new JLabel ("Product Add");
        nameLabel = new JLabel ("Product name:");
        nameText = new JTextField ();
        priceLabel = new JLabel ("Product price:");
        priceText = new JTextField ();
        addButton = new JButton ("Add");
        stockText = new JTextField();
        stockLabel = new JLabel("Stock");

        frame9.setSize(480,280);
        frame9.setLayout(null);
        frame9.setVisible(true);
        frame9.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        addButton.setFocusable(false);

        frame9.add(titleLabel);
        frame9.add(nameLabel);
        frame9.add(nameText);
        frame9.add(priceLabel);
        frame9.add(priceText);
        frame9.add(addButton);
        frame9.add(stockLabel);
        frame9.add(stockText);


        titleLabel.setBounds (200, 25, 100, 25);
        nameLabel.setBounds (15, 100, 100, 25);
        nameText.setBounds (100, 100, 115, 25);
        priceLabel.setBounds (240, 100, 100, 25);
        priceText.setBounds (325, 100, 115, 25);
        stockText.setBounds(200,135,115,25);
        stockLabel.setBounds(130,135,100,25);
        addButton.setBounds (185, 185, 100, 35);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Products product = new Products(getName(),getPrice(), getSock());
                ProductBBL.addProduct(product);
                frame9.dispose();
            }
        });
    }

    public float getPrice(){
        return Float.parseFloat(priceText.getText());
    }
    public int getSock() {return Integer.parseInt(stockText.getText());}
    public String getName(){
        return String.valueOf(nameText.getText());
    }

}
