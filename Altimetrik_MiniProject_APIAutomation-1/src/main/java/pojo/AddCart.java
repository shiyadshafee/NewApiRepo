package pojo;

import java.util.List;

public class AddCart {

    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<pojo.Products> getProducts() {
        return Products;
    }

    public void setProducts(List<pojo.Products> products) {
        Products = products;
    }

    private List<Products> Products;




}
