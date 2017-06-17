package example.charlesparasa.model;

import java.io.Serializable;

/**
 * Created by charlesparasa on 17/06/17.
 */

public class Products implements Serializable {

    private String productID;
    private String productName;
    private String shopAddress;

    public String getproductID() {
        return productID;
    }

    public void setproductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public Products() {
    }

    public Products(String productID, String productName, String shopAddress) {
        this.productID = productID;
        this.productName = productName;
        this.shopAddress = shopAddress;
    }
}
