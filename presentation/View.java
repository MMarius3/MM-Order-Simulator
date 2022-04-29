package presentation;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
/**
 * @author Macean Marius
 * @since Apr 06, 2021
 */
public class View {

    public JFrame clientFrame, productFrame, orderFrame;
    public JPanel clientMainPanel, clientFirstPanel, clientSecondPanel, clientThirdPanel,
                  productMainPanel, productFirstPanel, productSecondPanel, productThirdPanel,
                  orderMainPanel, orderFirstPanel, orderSecondPanel, orderThirdPanel;
    public JTextField clientIDText, clientNameText, clientAddressText, clientEmailText, clientAgeText,
                      productIDText, productNameText, productPriceText, productMaterialText, productStockText,
                      orderClientIDText, orderProductIDText, orderQuantityText;
    public JButton addClient, editClient, deleteClient, viewClients,
                   addProduct, editProduct, deleteProduct, viewProducts,
                   addOrder, viewOrders;
    public JLabel clientLabel, productLabel, orderLabel;

    public View() { GUI(); }

    private void GUI() {
        clientFrame = new JFrame("Clients");
        clientFrame.setSize(700, 900);
        clientFrame.setLayout(new GridLayout(1, 1));
        clientMainPanel = new JPanel();
        clientMainPanel.setBackground(Color.darkGray);
        clientFirstPanel = new JPanel();
        clientFirstPanel.setBackground(Color.darkGray);

        GridLayout clientOp = new GridLayout(9,1);
        clientFirstPanel.setLayout(clientOp);
        addClient = this.createSimpleButton("add new client");
        editClient = this.createSimpleButton("edit client");
        deleteClient = this.createSimpleButton("delete client");
        viewClients = this.createSimpleButton("show clients");
        clientFirstPanel.add(addClient);
        clientFirstPanel.add(editClient);
        clientFirstPanel.add(deleteClient);
        clientFirstPanel.add(viewClients);

        clientIDText = new JTextField(5);
        clientFirstPanel.add(new JLabel("<html><font color='white'>ID: </font></html>", JLabel.LEFT));
        clientFirstPanel.add(clientIDText);
        clientNameText = new JTextField(5);
        clientFirstPanel.add(new JLabel("<html><font color='white'>Name: </font></html>", JLabel.LEFT));
        clientFirstPanel.add(clientNameText);
        clientAddressText = new JTextField(5);
        clientFirstPanel.add(new JLabel("<html><font color='white'>Address: </font></html>", JLabel.LEFT));
        clientFirstPanel.add(clientAddressText);
        clientEmailText = new JTextField(5);
        clientFirstPanel.add(new JLabel("<html><font color='white'>Email: </font></html>", JLabel.LEFT));
        clientFirstPanel.add(clientEmailText);
        clientAgeText = new JTextField(5);
        clientFirstPanel.add(new JLabel("<html><font color='white'>Age: </font></html>", JLabel.LEFT));
        clientFirstPanel.add(clientAgeText);

        clientSecondPanel = new JPanel();
        clientSecondPanel.setLayout(new FlowLayout());
        clientSecondPanel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.darkGray));
        clientSecondPanel.setBackground(Color.darkGray);

        clientLabel = new JLabel("", JLabel.LEFT);
        clientLabel.setPreferredSize(new Dimension(333,70));
        clientLabel.setText("<html><font color='FFFFFF'>CLIENTS</font></html>");
        clientSecondPanel.add(clientLabel);

        clientThirdPanel = new JPanel();
        clientThirdPanel.setLayout(new FlowLayout());
        clientThirdPanel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.darkGray));
        clientThirdPanel.setBackground(Color.darkGray);

        clientMainPanel.add(clientFirstPanel);
        clientMainPanel.add(clientSecondPanel);
        clientMainPanel.add(clientThirdPanel);
        clientFrame.add(clientMainPanel);

        productFrame = new JFrame("Products");
        productFrame.setSize(700, 700);
        productFrame.setLayout(new GridLayout(1, 1));
        productMainPanel = new JPanel();
        productMainPanel.setBackground(Color.darkGray);
        productFirstPanel = new JPanel();
        productFirstPanel.setBackground(Color.darkGray);

        GridLayout productOp = new GridLayout(9,1);
        productFirstPanel.setLayout(productOp);
        addProduct = this.createSimpleButton("add new product");
        editProduct = this.createSimpleButton("edit product");
        deleteProduct = this.createSimpleButton("delete product");
        viewProducts = this.createSimpleButton("show products");
        productFirstPanel.add(addProduct);
        productFirstPanel.add(editProduct);
        productFirstPanel.add(deleteProduct);
        productFirstPanel.add(viewProducts);

        productIDText = new JTextField(5);
        productFirstPanel.add(new JLabel("<html><font color='white'>ID: </font></html>", JLabel.LEFT));
        productFirstPanel.add(productIDText);
        productNameText = new JTextField(5);
        productFirstPanel.add(new JLabel("<html><font color='white'>Name: </font></html>", JLabel.LEFT));
        productFirstPanel.add(productNameText);
        productPriceText = new JTextField(5);
        productFirstPanel.add(new JLabel("<html><font color='white'>Price: </font></html>", JLabel.LEFT));
        productFirstPanel.add(productPriceText);
        productMaterialText = new JTextField(5);
        productFirstPanel.add(new JLabel("<html><font color='white'>Material: </font></html>", JLabel.LEFT));
        productFirstPanel.add(productMaterialText);
        productStockText = new JTextField(5);
        productFirstPanel.add(new JLabel("<html><font color='white'>Stock: </font></html>", JLabel.LEFT));
        productFirstPanel.add(productStockText);

        productSecondPanel = new JPanel();
        productSecondPanel.setLayout(new FlowLayout());
        productSecondPanel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.darkGray));
        productSecondPanel.setBackground(Color.darkGray);

        productLabel = new JLabel("", JLabel.LEFT);
        productLabel.setPreferredSize(new Dimension(333,70));
        productLabel.setText("<html><font color='FFFFFF'>PRODUCTS</font></html>");
        productSecondPanel.add(productLabel);

        productThirdPanel = new JPanel();
        productThirdPanel.setLayout(new FlowLayout());
        productThirdPanel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.darkGray));
        productThirdPanel.setBackground(Color.darkGray);

        productMainPanel.add(productFirstPanel);
        productMainPanel.add(productSecondPanel);
        productMainPanel.add(productThirdPanel);
        productFrame.add(productMainPanel);

        orderFrame = new JFrame("Orders");
        orderFrame.setSize(700, 700);
        orderFrame.setLayout(new GridLayout(1, 1));
        orderMainPanel = new JPanel();
        orderMainPanel.setBackground(Color.darkGray);
        orderFirstPanel = new JPanel();
        orderFirstPanel.setBackground(Color.darkGray);

        GridLayout orderOp = new GridLayout(5,1);
        orderFirstPanel.setLayout(orderOp);
        addOrder = this.createSimpleButton("add new order");
        orderFirstPanel.add(addOrder);
        viewOrders = this.createSimpleButton("view orders");
        orderFirstPanel.add(viewOrders);

        orderClientIDText = new JTextField(5);
        orderFirstPanel.add(new JLabel("<html><font color='white'>Client ID: </font></html>", JLabel.LEFT));
        orderFirstPanel.add(orderClientIDText);
        orderProductIDText = new JTextField(5);
        orderFirstPanel.add(new JLabel("<html><font color='white'>Product ID: </font></html>", JLabel.LEFT));
        orderFirstPanel.add(orderProductIDText);
        orderQuantityText = new JTextField(5);
        orderFirstPanel.add(new JLabel("<html><font color='white'>Quantity: </font></html>", JLabel.LEFT));
        orderFirstPanel.add(orderQuantityText);

        orderSecondPanel = new JPanel();
        orderSecondPanel.setLayout(new FlowLayout());
        orderSecondPanel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.darkGray));
        orderSecondPanel.setBackground(Color.darkGray);

        orderLabel = new JLabel("", JLabel.LEFT);
        orderLabel.setPreferredSize(new Dimension(333,70));
        orderLabel.setText("<html><font color='FFFFFF'>ORDERS</font></html>");
        orderSecondPanel.add(orderLabel);

        orderThirdPanel = new JPanel();
        orderThirdPanel.setLayout(new FlowLayout());
        orderThirdPanel.setBorder(BorderFactory.createMatteBorder(1, 5, 1, 1, Color.darkGray));
        orderThirdPanel.setBackground(Color.darkGray);

        orderMainPanel.add(orderFirstPanel);
        orderMainPanel.add(orderSecondPanel);
        orderMainPanel.add(orderThirdPanel);
        orderFrame.add(orderMainPanel);
    }

    private JButton createSimpleButton(String text) {
        JButton button = new JButton("<html><p style='font-size:21px;font-family:Helvetica;'>"+text+"</p></html>");
        button.setForeground(Color.yellow);
        button.setBackground(Color.darkGray);
        Border line = BorderFactory.createLineBorder(Color.darkGray);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        button.setBorder(compound);
        return button;
    }

    public void orderManagementPanel() {
        addClient.setActionCommand("addClient");
        editClient.setActionCommand("editClient");
        deleteClient.setActionCommand("deleteClient");
        viewClients.setActionCommand("viewClients");
        addProduct.setActionCommand("addProduct");
        editProduct.setActionCommand("editProduct");
        deleteProduct.setActionCommand("deleteProduct");
        viewProducts.setActionCommand("viewProducts");
        addOrder.setActionCommand("addOrder");
        viewOrders.setActionCommand("viewOrders");
        addClient.addActionListener(new Controller(this));
        editClient.addActionListener(new Controller(this));
        deleteClient.addActionListener(new Controller(this));
        viewClients.addActionListener(new Controller(this));
        addProduct.addActionListener(new Controller(this));
        editProduct.addActionListener(new Controller(this));
        deleteProduct.addActionListener(new Controller(this));
        viewProducts.addActionListener(new Controller(this));
        addOrder.addActionListener(new Controller(this));
        viewOrders.addActionListener(new Controller(this));
        clientFrame.setVisible(true);
        productFrame.setVisible(true);
        orderFrame.setVisible(true);
    }
}
