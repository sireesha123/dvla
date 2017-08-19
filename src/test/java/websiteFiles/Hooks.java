package websiteFiles;


import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    openDriver OD = new openDriver();

    @Before
    public void startBrowser(){
        OD.openDriver();

    }



    @After
    public void  endBrowser(){
        OD.closeBrowser();

    }
}
