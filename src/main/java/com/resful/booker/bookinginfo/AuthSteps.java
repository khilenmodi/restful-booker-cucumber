package com.resful.booker.bookinginfo;


import com.resful.booker.constants.EndPoint;
import com.resful.booker.model.AuthPojo;
import com.resful.booker.params.Headers;
import com.resful.booker.utils.TestUtils;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

/**
 * Created by Jay Vaghani
 */
public class AuthSteps {

    @Step("Get auth token with username: {0} and password: {1}")
    public String getAuthToken(String username, String password) {
        AuthPojo authPojo = AuthPojo.getAuthRequest(username, password);
        return SerenityRest.given().log().ifValidationFails()
                .header(Headers.CONTENT_TYPE, "application/json")
                .body(TestUtils.jsonToString(authPojo))
                .when()
                .post(EndPoint.AUTH)
                .then().log().ifValidationFails()
                .statusCode(200).extract().path("token");
    }
}
