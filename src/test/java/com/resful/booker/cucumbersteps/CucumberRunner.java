package com.resful.booker.cucumbersteps;

import com.resful.booker.testbase.TestBase;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by Jay
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features =  "src/test/java/resources/feature")
public class CucumberRunner extends TestBase {

}
