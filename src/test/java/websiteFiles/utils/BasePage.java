package websiteFiles.utils;

import websiteFiles.openDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {
    openDriver OD = new openDriver();
    public void openURL(String url){
        OD.driver.get(url);
    }

    public void implicitWait(){
        OD.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    public void threadWait(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
