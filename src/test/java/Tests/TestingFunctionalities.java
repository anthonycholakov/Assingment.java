package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TestingFunctionalities extends BaseTest {

    @Test
    @DisplayName("Creating new record in the table")
    protected void addNewForecast() {

        // Declaring all the selectors
        final By addNewRecordButtonSelector = By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div/div[1]/button[1]");
        final By inputDateFieldFromCalendarSelector = By.xpath("//span[@class='k-icon k-i-calendar']");
        final By todaySelector = By.xpath("//span[@class='k-nav-today']");
        final By inputTemperatureInCelsiusSelector = By.xpath("//td[@data-col-index='2']/div/span/input[@class='k-input k-formatted-value']");
        final By inputSummarySelector = By.cssSelector(".k-textbox");
        final By updateButtonSelector = By.xpath("//td[@class='k-command-cell   ']/span/button[@class='k-button telerik-blazor k-button-icontext']/span[@class='k-icon k-i-save ']");
        final By summaryCellSelector = By.xpath("//tr[@class='k-master-row  ' and @data-render-row-index='1']/td[@data-col-index='4']");


        //      Clicking on the the Add New Forecast icon
        WebElement addNewRecordButton = driver.findElement(addNewRecordButtonSelector);
        addNewRecordButton.click();

        //      Choosing the current date from calendar
        WebElement inputDateFieldFromCalendar = driver.findElement(inputDateFieldFromCalendarSelector);
        inputDateFieldFromCalendar.click();

        WebElement today = driver.findElement(todaySelector);
        today.click();

        //      Typing a value for degrees in Celsius
        WebElement inputTemperatureInCelsius = driver.findElement(inputTemperatureInCelsiusSelector);
        inputTemperatureInCelsius.clear();
        inputTemperatureInCelsius.sendKeys("55");

        //      Typing a custom message
        WebElement inputSummary = driver.findElement(inputSummarySelector);
        String summaryMessage = "This is a custom record";
        inputSummary.sendKeys(summaryMessage);

        //      Updating the row in the table
        WebElement updateButton = driver.findElement(updateButtonSelector);
        updateButton.click();

        WebElement summaryCell = driver.findElement(summaryCellSelector);


        //      Comparing the message of input with the actual Summary message from the updated record
        Assertions.assertEquals(summaryMessage, summaryCell.getText());
    }

    @Test
    @DisplayName("Edit and Saving")
    protected void edit() {

        //Declaring all the selectors
        final By editButtonSelector = By.xpath("//tr[@data-render-row-index='1']/td[@colspan='1']/span/button[@class='k-button telerik-blazor k-button-icontext k-primary']");
        final By dateFieldSelector = By.xpath("//span/span/input[@class='k-input']");
        final By inputTemperatureInCelsiusSelector = By.xpath("//td[@class=' k-grid-edit-cell ' and @data-col-index='2']/div/span/input");
        final By inputSummarySelector = By.cssSelector(".k-textbox");
        final By updateButtonSelector = By.xpath("//td[@class='k-command-cell   ']/span/button[@class='k-button telerik-blazor k-button-icontext']/span[@class='k-icon k-i-save ']");
        final By summaryCellSelector = By.xpath("//tr[@class='k-master-row  ' and @data-render-row-index='1']/td[@data-col-index='4']");
        final By temperatureCellSelector = By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div/div[4]/div[2]/div[1]/div/table/tbody/tr[1]/td[3]");
        final By dateCellSelector = By.xpath("//tr[@data-render-row-index='1' and @aria-rowindex='2']/td[@colspan='1' and @data-col-index='1']");

        //Clicking Edit button
        WebElement editButton = driver.findElement(editButtonSelector);
        editButton.click();

        //Entering custom date
        WebElement dateField = driver.findElement(dateFieldSelector);
        dateField.clear();
        String dateToEdit = "15102021";
        dateField.sendKeys(dateToEdit);

        //Entering custom temperature in Celsius
        WebElement inputTemperatureInCelsius = driver.findElement(inputTemperatureInCelsiusSelector);
        inputTemperatureInCelsius.click();
        inputTemperatureInCelsius.sendKeys(Keys.BACK_SPACE);
        inputTemperatureInCelsius.sendKeys(Keys.BACK_SPACE);
        inputTemperatureInCelsius.sendKeys(Keys.BACK_SPACE);
        String editTemperature = "55,0";
        inputTemperatureInCelsius.sendKeys(editTemperature);

        //Entering custom summary message for the record
        WebElement inputSummary = driver.findElement(inputSummarySelector);
        inputSummary.clear();
        String editSummary = "This record is edited";
        inputSummary.sendKeys(editSummary);

        //Clicking Update button
        WebElement updateButton = driver.findElement(updateButtonSelector);
        updateButton.click();

        //Checking the editing
        WebElement summaryCell = driver.findElement(summaryCellSelector);
        WebElement temperatureCell = driver.findElement(temperatureCellSelector);
        WebElement dateCell = driver.findElement(dateCellSelector);

        String dateCellMessage = "петък, 15 окт 2021";

        Assertions.assertEquals(editSummary, summaryCell.getText());
        Assertions.assertEquals(editTemperature, temperatureCell.getText());
        Assertions.assertEquals(dateCellMessage, dateCell.getText());

    }
}
