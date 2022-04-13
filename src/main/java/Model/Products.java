package Model;

/**
 * In this class is made the object for product
 * Fields are productName, productPrice, productStock
 * Also getters and setters are made for each attribute
 */
public class Products {
    private String productName;
    private float productPrice;
    private int productStock;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public Products(String name, float price, int stock) {
        this.productName = name;
        this.productPrice = price;
        this.productStock = stock;
    }
}
