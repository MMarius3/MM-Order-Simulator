package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;

import bll.OrderBLL;
import dao.ClientDAO;
import model.Client;
import dao.ProductDAO;
import model.Product;
import dao.OrderDAO;
import model.Order;

import javax.swing.*;
/**
 * @author Macean Marius
 * @since Apr 06, 2021
 */
public class Controller implements ActionListener {
    View panel;

    public Controller(View panel) {
        this.panel = panel;
    }
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("addClient")) {
            String name = panel.clientNameText.getText();
            String address = panel.clientAddressText.getText();
            String email = panel.clientEmailText.getText();
            int age = Integer.parseInt(panel.clientAgeText.getText());
            Client client = new Client(name, address, email, age);
            ClientDAO clientDAO = new ClientDAO();
            Client clientInserted = clientDAO.insert(client);
            String clientInsertedDisplay = retrieveProperties(clientInserted);
            panel.clientLabel.setText("<html><p style='color:yellow;font-family:Helvetica;font-weight:100;line-height:15px;'><b>The client with: " + clientInsertedDisplay + " was inserted successfully!</b></p></html>");
        } else if (command.equals("editClient")) {
            int id = Integer.parseInt(panel.clientIDText.getText());
            String name = null;
            String address = null;
            String email = null;
            int age = 0;
            ClientDAO clientDAO = new ClientDAO();
            Client t = clientDAO.findById(id);
            int fieldNr = 0;
            for (Field field : t.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value;
                try {
                    fieldNr++;
                    value = field.get(t);
                    if (fieldNr == 2) { name = value.toString(); }
                    else if (fieldNr == 3) { address = value.toString(); }
                    else if (fieldNr == 4) { email = value.toString(); }
                    else if (fieldNr == 5) { age = Integer.parseInt(value.toString()); }
                } catch (IllegalArgumentException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            }
            if (!panel.clientNameText.getText().isEmpty()) {
                name = panel.clientNameText.getText();
            }
            if (!panel.clientAddressText.getText().isEmpty()) {
                address = panel.clientAddressText.getText();
            }
            if (!panel.clientEmailText.getText().isEmpty()) {
                email = panel.clientEmailText.getText();
            }
            if (!panel.clientAgeText.getText().isEmpty()) {
                age = Integer.parseInt(panel.clientAgeText.getText());
            }
            Client client = new Client(id, name, address, email, age);
            ClientDAO clientDAO1 = new ClientDAO();
            Client clientUpdated = clientDAO1.update(client);
            String clientUpdatedDisplay = retrieveProperties(clientUpdated);
            panel.clientLabel.setText("<html><p style='color:yellow;font-family:Helvetica;font-weight:100;line-height:15px;'><b>The client with: " + clientUpdatedDisplay + " was updated successfully!</b></p></html>");
        } else if (command.equals("deleteClient")) {
            int id = Integer.parseInt(panel.clientIDText.getText());
            ClientDAO clientDaoDelete = new ClientDAO();
            Client clientDeleted = clientDaoDelete.delete(id);
            String clientDeletedDisplay = retrieveProperties(clientDeleted);
            panel.clientLabel.setText("<html><p style='color:yellow;font-family:Helvetica;font-weight:100;line-height:15px;'><b>The client with: " + clientDeletedDisplay + " was deleted successfully!</b></p></html>");
        } else if (command.equals("viewClients")) {
            ClientDAO clientDAO = new ClientDAO();
            List<Client> list = clientDAO.findAll();
            String[][] clientData = new String[20][7];
            int numberOfRow = 0;
            for (Client client : list) {
                int fieldNr = 0;
                for (Field field : client.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    Object value;
                    try {
                        value = field.get(client);
                        clientData[numberOfRow][fieldNr] = value.toString();
                        fieldNr++;
                    } catch (IllegalArgumentException ex) {
                        ex.printStackTrace();
                    } catch (IllegalAccessException ex) {
                        ex.printStackTrace();
                    }
                }
                numberOfRow++;
            }
            String[] clientColumnNames = {"ID", "Name", "Address", "Email", "Age"};
            JTable clientTable = new JTable(clientData, clientColumnNames);
            clientTable.setBounds(30,40,200,150);
            JScrollPane clientScroll = new JScrollPane(clientTable);
            panel.clientThirdPanel.add(clientScroll);
        } else if (command.equals("addProduct")) {
            String name = panel.productNameText.getText();
            int price = Integer.parseInt(panel.productPriceText.getText());
            String material = panel.productMaterialText.getText();
            int stock = Integer.parseInt(panel.productStockText.getText());
            Product product = new Product(name, price, material, stock);
            ProductDAO productDAO = new ProductDAO();
            Product productInserted = productDAO.insert(product);
            String productInsertedDisplay = retrieveProperties(productInserted);
            panel.productLabel.setText("<html><p style='color:yellow;font-family:Helvetica;font-weight:100;line-height:15px;'><b>The product with: " + productInsertedDisplay + " was inserted successfully!</b></p></html>");
        } else if (command.equals("editProduct")) {
            int id = Integer.parseInt(panel.productIDText.getText());
            String name = null;
            int price = 0;
            String material = null;
            int stock = 0;
            ProductDAO productDAO = new ProductDAO();
            Product t = productDAO.findById(id);
            int fieldNr = 0;
            for (Field field : t.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object value;
                try {
                    fieldNr++;
                    value = field.get(t);
                    if (fieldNr == 2) { name = value.toString(); }
                    else if (fieldNr == 3) { price = Integer.parseInt(value.toString()); }
                    else if (fieldNr == 4) { material = value.toString(); }
                    else if (fieldNr == 5) { stock = Integer.parseInt(value.toString()); }
                } catch (IllegalArgumentException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            }
            if (!panel.productNameText.getText().isEmpty()) {
                name = panel.productNameText.getText();
            }
            if (!panel.productPriceText.getText().isEmpty()) {
                price = Integer.parseInt(panel.productPriceText.getText());
            }
            if (!panel.productMaterialText.getText().isEmpty()) {
                material = panel.productMaterialText.getText();
            }
            if (!panel.productStockText.getText().isEmpty()) {
                stock = Integer.parseInt(panel.productStockText.getText());
            }
            Product product = new Product(id, name, price, material, stock);
            ProductDAO productDAO1 = new ProductDAO();
            Product productUpdated = productDAO1.update(product);
            String productUpdatedDisplay = retrieveProperties(productUpdated);
            panel.productLabel.setText("<html><p style='color:yellow;font-family:Helvetica;font-weight:100;line-height:15px;'><b>The product with: " + productUpdatedDisplay + " was updated successfully!</b></p></html>");
        } else if (command.equals("deleteProduct")) {
            int id = Integer.parseInt(panel.productIDText.getText());
            ProductDAO productDaoDelete = new ProductDAO();
            Product productDeleted = productDaoDelete.delete(id);
            String productDeletedDisplay = retrieveProperties(productDeleted);
            panel.productLabel.setText("<html><p style='color:yellow;font-family:Helvetica;font-weight:100;line-height:15px;'><b>The product with: " + productDeletedDisplay + " was deleted successfully!</b></p></html>");
        } else if (command.equals("viewProducts")) {
            ProductDAO productDAO = new ProductDAO();
            List<Product> list = productDAO.findAll();
            String[][] productData = new String[20][7];
            int numberOfRow = 0;
            for (Product product : list) {
                int fieldNr = 0;
                for (Field field : product.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    Object value;
                    try {
                        value = field.get(product);
                        productData[numberOfRow][fieldNr] = value.toString();
                        fieldNr++;
                    } catch (IllegalArgumentException ex) {
                        ex.printStackTrace();
                    } catch (IllegalAccessException ex) {
                        ex.printStackTrace();
                    }
                }
                numberOfRow++;
            }
            String[] productColumnNames = {"ID", "Name", "Price", "Material", "Stock"};
            JTable productTable = new JTable(productData, productColumnNames);
            productTable.setBounds(30,40,200,150);
            JScrollPane productScroll = new JScrollPane(productTable);
            panel.productThirdPanel.add(productScroll);
        } else if (command.equals("addOrder")) {
            int clientID = Integer.parseInt(panel.orderClientIDText.getText());
            int productID = Integer.parseInt(panel.orderProductIDText.getText());
            int quantity = Integer.parseInt(panel.orderQuantityText.getText());
            OrderBLL orderBLL = new OrderBLL();
            int goodOrder = orderBLL.insert(productID, clientID, quantity);
            if (goodOrder == 0) {
                panel.orderLabel.setText("<html><p style='color:yellow;font-family:Helvetica;font-weight:100;line-height:15px;'><b>The order was inserted successfully!</b></p></html>");

            } else if (goodOrder == 1) {
                panel.orderLabel.setText("<html><p style='color:yellow;font-family:Helvetica;font-weight:100;line-height:15px;'><b>Product out of stock!</b></p></html>");
            } else {
                panel.orderLabel.setText("<html><p style='color:yellow;font-family:Helvetica;font-weight:100;line-height:15px;'><b>Not enough product in stock!</b></p></html>");
            }
        } else if (command.equals("viewOrders")) {
            OrderDAO orderDAO = new OrderDAO();
            List<Order> list = orderDAO.findAll();
            String[][] orderData = new String[20][7];
            int numberOfRow = 0;
            for (Order order : list) {
                int fieldNr = 0;
                for (Field field : order.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    Object value;
                    try {
                        value = field.get(order);
                        orderData[numberOfRow][fieldNr] = value.toString();
                        fieldNr++;
                    } catch (IllegalArgumentException ex) {
                        ex.printStackTrace();
                    } catch (IllegalAccessException ex) {
                        ex.printStackTrace();
                    }
                }
                numberOfRow++;
            }
            String[] orderColumnNames = {"ID", "Date", "Price", "Client ID", "Product ID"};
            JTable orderTable = new JTable(orderData, orderColumnNames);
            orderTable.setBounds(30,40,200,150);
            JScrollPane orderScroll = new JScrollPane(orderTable);
            panel.orderThirdPanel.add(orderScroll);
        }
    }

    private String retrieveProperties(Object object) {
        StringBuilder sb = new StringBuilder();
        boolean firstField = true;
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value;
            try {
                if (firstField) {
                    firstField = false;
                } else {
                    value = field.get(object);
                    sb.append(" " + field.getName() + " = " + value + ", ");
                }

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
