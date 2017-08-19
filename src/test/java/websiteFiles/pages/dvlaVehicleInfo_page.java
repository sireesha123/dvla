package websiteFiles.pages;

import com.google.common.collect.Iterables;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import websiteFiles.openDriver;
import websiteFiles.stepDefinitions.dvla;
import websiteFiles.utils.fileDetails;
import websiteFiles.utils.vehicleDetails;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class dvlaVehicleInfo_page {

    String regNumber = new String();
    String make = new String();
    String color = new String();


    @FindBy(css = ".intro .button")
    private WebElement startButton;

    @FindBy(id = "Vrm")
    private WebElement registrationEntry;


    @FindBy(css = ".button")
    private WebElement continueButton;

    @FindBy(css = ".list-summary-item")
    private List<WebElement> summaryItems;


    openDriver OD = new openDriver();

    public void clickStartButton() {
        startButton.click();
    }


    public void verifyVehicleDetails() throws IOException, InvalidFormatException {


        HashMap<String, vehicleDetails> vehicledetails = readExcelData();
        String[] actualMake;
        String[] actualColor;

        for (String regNumber : vehicledetails.keySet()) {

            registrationEntry.sendKeys(regNumber);
            continueButton.click();
            actualMake = summaryItems.get(1).getText().split("\\n");
            actualColor = summaryItems.get(2).getText().split("\\n");
            assertEquals(vehicledetails.get(regNumber).getMake(), actualMake[1]);
            assertEquals(vehicledetails.get(regNumber).getColor(), actualColor[1]);
            OD.driver.navigate().back();

        }

    }


    private HashMap<String, vehicleDetails> readExcelData() throws IOException, InvalidFormatException {

        HashMap<String, vehicleDetails> vehicledetails = null;
        dvla fd = new dvla();
        HashMap<String, fileDetails> sizesByExtension = fd.fileDetails();
        for (String ext : sizesByExtension.keySet()) {
            if (ext.equals("xlsx")) {


                String FILE_NAME;

                List sheetData = new ArrayList();
                FileInputStream fis = null;

                InputStream inp = null;
                FILE_NAME = sizesByExtension.get(ext).fileName;
                String Directory = System.getProperty("user.dir") + "/src/main/resources/testData";


                inp = new FileInputStream(Directory + "/" + FILE_NAME);

                Workbook wb = WorkbookFactory.create(inp);
                Sheet sheet = wb.getSheetAt(0);
                Header header = sheet.getHeader();

                int rowsCount = sheet.getLastRowNum();


                vehicledetails = new HashMap<String, vehicleDetails>();
                for (int i = 1; i <= rowsCount; i++) {
                    Row row = sheet.getRow(i);
                    int colCounts = row.getLastCellNum();
                    for (int j = 0; j < colCounts; j++) {
                        Cell cell = row.getCell(j);
                        if (j == 0) {

                            regNumber = cell.getStringCellValue();
                        } else if (j == 1) {
                            make = cell.getStringCellValue();
                        } else {
                            color = cell.getStringCellValue();
                        }
                    }
                    vehicledetails.put(regNumber, new vehicleDetails(make, color));

                }

            }

        }
        return vehicledetails;

    }


}
