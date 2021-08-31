package Tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddNewForecastRecord extends BaseTest{

    private final By addNewRecordButtonSelector = By.xpath("/html/body/div[1]/div[2]/div/div/div[1]/div/div[1]/button[1]");
    private final By inputDateFieldFromCalendarSelector = By.xpath("//span[@class='k-icon k-i-calendar']");
    private final By todaySelector = By.xpath("//span[@class='k-nav-today']");
    private final By inputTemperatureInCelsiusSelector = By.xpath("//td[@data-col-index='2']/div/span/input[@class='k-input k-formatted-value']");
    private final By inputSummarySelector = By.cssSelector(".k-textbox");
    private final By updateButtonSelector = By.xpath("//td[@class='k-command-cell   ']/span/button[@class='k-button telerik-blazor k-button-icontext']/span[@class='k-icon k-i-save ']");
    private final By summaryCellSelector = By.xpath("//tr[@class='k-master-row  ' and @data-render-row-index='1']/td[@data-col-index='4']");

    @Test
    @DisplayName("Creating new record in the table")
    protected void addNewForecast() {
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

}
