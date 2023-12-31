package com.nopcommerce.demo.steps;


import com.nopcommerce.demo.propertyreader.PropertyReader;
import com.nopcommerce.demo.utility.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Utility {
   @Before
    public void SetUp(){
        selectBrowser(PropertyReader.getInstance().getProperty("browser"));

    }
   @After
    public void tearDown(Scenario scenario){
       if (scenario.isFailed()){
           final  byte[] Screenshot =getScreenShot();
           scenario.attach(Screenshot,"image/png",scenario.getName());
       }
       closeBrowser();
    }
}
