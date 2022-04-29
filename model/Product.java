package model;

/**
 * @author Macean Marius
 * @since Apr 06, 2021
 */
public class Product {
    private int id;
    private String name;
    private int price;
    private String material;
    private int stock;

    public Product() {
    }

    public Product(int id, String name, int price, String material, int stock) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.material = material;
        this.stock = stock;
    }

    public Product(String name, int price, String material, int stock) {
        super();
        this.name = name;
        this.price = price;
        this.material = material;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", material=" + material + ", stock=" + stock
                + "]";
    }

}
