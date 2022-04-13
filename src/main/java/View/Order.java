package View;

import BusinessLogic.ProductBBL;
import DataAcces.OrderDAO;
import DataAcces.ProductDAO;
import Model.Clients;
import Model.Products;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Here, the selected customer by user will place an order
 * Selected products with quantities will be placed into basket list
 * By pressing the button Place Order a bill will be generated as a txt file with order id in name
 */
public class Order extends JPanel {

    private JLabel titleLabel;
    private JList productsList;
    private JList basketList;
    private JButton addButton;
    private JButton removeButton;
    private JLabel totalLabel;
    private JLabel sumaLabel;
    private JButton orderButton;
    private JTextField quantityText;
    private JLabel quantityLabel;
    JFrame frame8 = new JFrame("Order");
    DefaultListModel v = new DefaultListModel();
    DefaultListModel d = new DefaultListModel();
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Order(Clients clients) {

        titleLabel = new JLabel ("Order");
        v = ProductDAO.viewProducts();
        final float[] s = {0};
        productsList = new JList<>(v);
        basketList = new JList(d);
        addButton = new JButton ("Add");
        removeButton = new JButton ("Remove");
        totalLabel = new JLabel ("Total:");
        sumaLabel = new JLabel ("0 lei");
        orderButton = new JButton ("Place order");
        quantityLabel = new JLabel("Quantity");
        quantityText = new JTextField();

        //adjust size and set layout
        frame8.setSize(850, 480);
        frame8.setLayout(null);
        frame8.setVisible(true);
        frame8.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

        //add components
        frame8.add(titleLabel);
        frame8.add(productsList);
        frame8.add(basketList);
        frame8.add(addButton);
        frame8.add(removeButton);
        frame8.add(totalLabel);
        frame8.add(sumaLabel);
        frame8.add(orderButton);
        frame8.add(quantityLabel);
        frame8.add(quantityText);

       //set component bounds (only needed by Absolute Positioning)
        titleLabel.setBounds (375, 15, 100, 25);
        productsList.setBounds (25, 60, 245, 350);
        basketList.setBounds (515, 60, 300, 350);
        addButton.setBounds (335, 130, 100, 25);
        removeButton.setBounds (335, 175, 100, 25);
        totalLabel.setBounds (375, 380, 45, 25);
        sumaLabel.setBounds (410, 380, 80, 25);
        orderButton.setBounds (325, 310, 125, 40);
        quantityText.setBounds(370,235,100,25);
        quantityLabel.setBounds(315,230,65,30);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] y =v.getElementAt(productsList.getSelectedIndex()).toString().split(" ");
                if(Integer.parseInt(quantityText.getText()) <= Integer.parseInt(y[y.length -1])) {
                    Products product = new Products(y[1], Float.parseFloat(y[3]), Integer.parseInt(y[5]));
                    d.addElement(y[0]+" "+y[1]+" "+ y[2] +" "+ y[3] + " Cantitate: " + Integer.parseInt(quantityText.getText()));
                    for (int i = 1; i <= Integer.parseInt(quantityText.getText()); i++) {
                        String x[] = v.getElementAt(productsList.getSelectedIndex()).toString().split(" ");
                        s[0] += Float.parseFloat(x[3]);
                        OrderDAO.insertIntoOrder(product);
                    }
                }else{
                    JOptionPane.showMessageDialog(frame8,"Stoc indisponibil!");
                }
                v = ProductDAO.viewProducts();
                sumaLabel.setText(String.valueOf(df.format(s[0])));

            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.remove(basketList.getSelectedIndex());
                float s = 0;
                for(int i = 0 ; i < d.size(); i ++){
                    String[] x = d.get(i).toString().split(" ");
                    s+= Float.parseFloat(x[3]);
                }
                sumaLabel.setText(String.valueOf(df.format(s)));
            }
        });

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderDAO.placeOrder(d,clients);
                frame8.dispose();
            }
        });
    }

}
