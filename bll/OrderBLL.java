package bll;

import dao.OrderDAO;
import dao.ProductDAO;
import model.Order;
import model.Product;

import java.lang.reflect.Field;
import java.time.LocalDate;

/**
 * @author Macean Marius
 * @since Apr 06, 2021
 */
public class OrderBLL {

    public int insert(int productID, int clientID, int quantity) {
        LocalDate now = LocalDate.now();
        String purchaseDate = now.toString();
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.findById(productID);
        int productPrice = product.getPrice();
        String productName = product.getName();
        String productMaterial = product.getMaterial();
        int price = productPrice * quantity;
        System.out.println(price);
        int productStock = product.getStock();
        if (quantity <= productStock) {
            Order order = new Order(purchaseDate, price, clientID, productID);
            OrderDAO orderDAO = new OrderDAO();
            Order orderInserted = orderDAO.insert(order);
            Product toUpdateProduct = new Product(productID, productName, productPrice, productMaterial, productStock - quantity);
            Product updatedProduct = productDAO.update(toUpdateProduct);
            return 0;
        } else if (productStock == 0) {
            return 1;
        } else {
            return 2;
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
