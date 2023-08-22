package com.resful.booker.cucumbersteps;

import com.resful.booker.bookinginfo.AuthSteps;
import com.resful.booker.bookinginfo.BookingSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

public class MyStepdefs {

    static ValidatableResponse response;
    static String firstname;
    static String lastname;
    static int  totalprice;
    static boolean depositpaid;
    static String checkin;
    static String  checkout;
    static String additionalneeds;

    static String username = "admin";
    static String password = "password123";
    static int bookingId;
    static String token;
    @Steps
    AuthSteps authSteps;
    @Steps
    BookingSteps bookingSteps;
    @Given("^user open url \"([^\"]*)\"$")
    public void userOpenUrl(String arg0)  {
        System.out.println();
    }


    @When("^user should get all the bookingIDs with the following details firstname \"([^\"]*)\"  lastname \"([^\"]*)\" totalprice \"([^\"]*)\"  deposit \"([^\"]*)\" checkin\"([^\"]*)\" checkout \"([^\"]*)\" additionalneeds \"([^\"]*)\"$")
    public void userShouldGetAllTheBookingIDsWithTheFollowingDetailsFirstnameLastnameTotalpriceDepositCheckinCheckoutAdditionalneeds(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6)  {
        bookingSteps.getAllBookingIds();
    }
    @And("^user make a POST request with the following field firstname \"([^\"]*)\"  lastname \"([^\"]*)\" totalprice \"([^\"]*)\"  deposit \"([^\"]*)\" checkin\"([^\"]*)\" checkout \"([^\"]*)\" additionalneeds \"([^\"]*)\"$")
    public void userMakeAPOSTRequestWithTheFollowingFieldFirstnameLastnameTotalpriceDepositCheckinCheckoutAdditionalneeds(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6)  {
      response = bookingSteps.createBooking(firstname,lastname,totalprice,depositpaid,checkin,checkout,additionalneeds);
    }

    @Then("^the response status code should be \"([^\"]*)\"$")
    public void theResponseStatusCodeShouldBe(String arg0)  {
       response.statusCode(201);
    }


    @And("^user make the UPDATE request with the following field firstname \"([^\"]*)\"  lastname \"([^\"]*)\" totalprice \"([^\"]*)\"  deposit \"([^\"]*)\" checkin\"([^\"]*)\" checkout \"([^\"]*)\" additionalneeds \"([^\"]*)\"$")
    public void userMakeTheUPDATERequestWithTheFollowingFieldFirstnameLastnameTotalpriceDepositCheckinCheckoutAdditionalneeds(String arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6)  {
        token = authSteps.getAuthToken(username, password);
        response = bookingSteps.updateBooking(bookingId,firstname,lastname,totalprice,depositpaid,checkin,checkout,additionalneeds,token);

    }

    @Then("^the booking is updated with the correct \"([^\"]*)\"$")
    public void theBookingIsUpdatedWithTheCorrect(String arg0)  {
        response.statusCode(200);
    }

    @And("^user make the partial booking update with the following field firstname \"([^\"]*)\" lastname \"([^\"]*)\"$")
    public void userMakeThePartialBookingUpdateWithTheFollowingFieldFirstnameLastname(String arg0, String arg1)  {
        token = authSteps.getAuthToken(username, password);
       response = bookingSteps.updatePartialBooking(bookingId,firstname,lastname,totalprice,depositpaid,checkin,checkout,additionalneeds,token);
    }

    @Then("^the booking is  then partially updated with the correct \"([^\"]*)\"$")
    public void theBookingIsThenPartiallyUpdatedWithTheCorrect(String arg0)  {
        response.statusCode(200);
    }

    @And("^a user deletes the booking with \"([^\"]*)\"$")
    public void aUserDeletesTheBookingWith(String arg0)  {
        token = authSteps.getAuthToken(username, password);
        response = bookingSteps.deleteBookingWithBookingId(bookingId,token);
    }

    @And("^the booking is successfully deleted$")
    public void theBookingIsSuccessfullyDeleted() {
        response = bookingSteps.getBookingWithBookingId(bookingId);
    }

    @Then("^the response status code is (\\d+)$")
    public void theResponseStatusCodeIs(int arg0) {
        response.statusCode(201);
    }
}
