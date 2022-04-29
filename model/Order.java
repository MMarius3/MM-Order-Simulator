package model;

/**
 * @author Macean Marius
 * @since Apr 06, 2021
 */
public class Order {
    private int id;
    private String purchaseDate;
    private int price;
    private int clientID;
    private int productID;

    public Order() {
    }

    public Order(int id, String purchaseDate, int price, int clientID, int productID) {
        super();
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.clientID = clientID;
        this.productID = productID;
    }

    public Order(String purchaseDate, int price, int clientID, int productID) {
        super();
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.clientID = clientID;
        this.productID = productID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", purchaseDate=" + purchaseDate + ", price=" + price + ", clientID=" + clientID + ", productID=" + productID
                + "]";
    }

}
