Feature: Testing different request on the restful booker app

  As a user i want to navigate to the herokuapp website

  Scenario Outline:Get all the bookingIds and create one bookingId as well as update bookingID with using same fields
    Given user open url "https://restful-booker.herokuapp.com/apidoc/index.html"
    When user should get all the bookingIDs with the following details firstname "<firstname>"  lastname "<lastname>" totalprice "<totalprice>"  deposit "<deposit>" checkin"<checkin>" checkout "<checkout>" additionalneeds "<additionalneeds>"
    And user make a POST request with the following field firstname "<firstname>"  lastname "<lastname>" totalprice "<totalprice>"  deposit "<deposit>" checkin"<checkin>" checkout "<checkout>" additionalneeds "<additionalneeds>"
    Then the response status code should be "<statuscode>"
    And user make the UPDATE request with the following field firstname "<firstname>"  lastname "<lastname>" totalprice "<totalprice>"  deposit "<deposit>" checkin"<checkin>" checkout "<checkout>" additionalneeds "<additionalneeds>"
    Then the booking is updated with the correct "<statuscode>"
    And user make the partial booking update with the following field firstname "<firstname>" lastname "<lastname>"
    Then the booking is  then partially updated with the correct "<statuscode>"
    And  a user deletes the booking with "bookingID"
    And the booking is successfully deleted
    Then the response status code is 201
    Examples:
      | firstname | lastname | totalprice | deposit | checkin    | checkout   | additionalneeds | statuscode |
      | Jim       | Brown    | 111        | true    | 2018-01-01 | 2019-01-01 | Breakfast       | 201        |
      | James     | Brown    | 111        | true    | 2018-01-01 | 2019-01-01 | Breakfast       | 200        |
      | Jammie    | Brown    |            |         |            |            |                 | 200        |







