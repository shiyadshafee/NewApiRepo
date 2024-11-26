package helpers;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pojo.AddCart;
import pojo.Products;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CartOperations {

    static CommonUtils utils = new CommonUtils();
    private static final Logger logger = LogManager.getLogger(CartOperations.class);
    static String UserID = null;
    static Response addCartResponse =null;

    static Response deleteCartResponse =null;


    public static Response addCartFunction() {

        try {
            AddCart addCart = new AddCart();
            addCart.setUserId(1);
            Products prods1 = new Products();
            Products prods2 = new Products();
            prods1.setId(144);
            prods2.setId(98);
            prods1.setQuantity(4);
            prods2.setQuantity(1);

            List<Products> prodsList = new ArrayList<Products>();
            prodsList.add(prods1);
            prodsList.add(prods2);
            addCart.setProducts(prodsList);

            addCartResponse = given().spec(utils.requestSpecification()).log().all().body(addCart).when().post("/add").then()
                    .spec(utils.ResponseSpecification()).log().all().extract().response();

           UserID =  utils.getJsonNodeValue(addCartResponse,"userId");
           logger.info("User ID value is:" +UserID);



        } catch (IOException e) {
            logger.error("Error in adding the cart details" + e.getMessage() + e.getCause());
        }
        return addCartResponse;
    }

    public static Response DeleteCartFunction()
    {
        try {
            deleteCartResponse =given().spec(utils.requestSpecification()).pathParam("UserID",UserID).log().all().when().delete("/{UserID}").then()
                    .spec(utils.ResponseSpecification()).log().all().extract().response();

        } catch (IOException e) {
            logger.error("Error in deleting the cart details" + e.getMessage() + e.getCause());
        }
        return deleteCartResponse;


    }
}

