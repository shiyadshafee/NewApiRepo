package apiTestCases;

import helpers.CartOperations;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ValidateCartsFunctions {
    SoftAssert softAssert = new SoftAssert();
    private static final Logger logger = LogManager.getLogger(ValidateCartsFunctions.class);

    @Test()
    public void addCartFunction() {
        logger.info("*****Adding the cart details*****");
        Response response = CartOperations.addCartFunction();
        logger.info("*****Getting the status code*****");
        int statusCode = response.getStatusCode();
        logger.info("The response code is " + statusCode);
        logger.info("*****Validating the status code*****");
        softAssert.assertEquals(statusCode, 200);
    }

    @Test(dependsOnMethods = {"addCartFunction"})
    public void deleteCartFunction() {
        logger.info("*****Deleting the cart details*****");
        Response response = CartOperations.DeleteCartFunction();
        logger.info("*****Getting the status code*****");
        int statusCode = response.getStatusCode();
        logger.info("The response code is " + statusCode);
        logger.info("*****Validating the status code*****");
        softAssert.assertEquals(statusCode, 200);

    }
}
