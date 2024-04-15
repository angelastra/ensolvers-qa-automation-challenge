package qachallenge.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FolderPage extends BasePage{

    //Locators
    String createNewFolderLink = "//a[@href='/folder/new']";
    String folderNameInput = "//input[@id='folder-name']";
    String saveNewItemButton = "//button[@id='save-entity']";
    String newFolderCreatedAlert = "//div[contains(text(),'A new folder is created')]";
    String updatedFolderAlert = "//div[contains(text(),'A folder is updated')]";
    String deletedFolderAlert = "//div[contains(text(),'A folder is deleted')]";
    String folderTableRows = "//table/tbody/tr";
    String deleteButton = "//button[@data-cy='entityConfirmDeleteButton']";
    String viewFolderData = "//dl/dd";

    WebDriver driver;
    String folderTitle;
    String folderId;

    public FolderPage(WebDriver driver, String folderTitle) {
        super(driver);
        this.driver = driver;
        this.folderTitle= folderTitle;
    }

    public FolderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void createNewFolder(){
        clickElement(createNewFolderLink);
        write(folderNameInput, folderTitle);
        clickElement(saveNewItemButton);
    }

    public boolean newFolderCreatedAlertIsDisplayed(){
        return elementIsDisplayed(newFolderCreatedAlert);
    }

    public boolean updatedFolderAlertIsDisplayed() {
        return elementIsDisplayed(updatedFolderAlert);
    }
    
    public boolean deletedToDoItemAlertIsDisplayed() {
        return elementIsDisplayed(deletedFolderAlert);
    }

    public boolean verifyFolderInformationInTable()
    {
        List<WebElement> folderRows = bringAllElements(folderTableRows);
        //Improve these lines of code with filter method from Java
        for (WebElement row : folderRows) 
        {
            String folderTitleR = row.findElement(By.xpath("//td[2]")).getText();
            if(folderTitleR.equals(this.folderTitle)) return true;
        }
        return false;
    }

    public void editFolder(String folderId, String folderTitle) {
        List<WebElement> folderRoWebElements = bringAllElements(folderTableRows);
        //Improve these lines of code with filter method from Java
        //This cycle maybe can be encapsulated in a function
        for (WebElement row : folderRoWebElements) 
        {
            String folderIdR = row.findElement(By.xpath("//td[1]/a")).getAttribute("href");
            if(folderIdR.contains(folderId))
            {
                row.findElement(By.xpath("//td[3]/div/a/span[text()='Edit']")).click(); //Maybe the xpath can be saved in a variable
                break;
            }
        }

        write(folderNameInput, folderTitle);
        clickElement(saveNewItemButton);
        //Assign new values to the variables that will be verify
        this.folderTitle = folderTitle;
    }

    public void deleteFolder(String id) {
        List<WebElement> folderRows = bringAllElements(folderTableRows);
        //Improve these lines of code with filter method from Java
        //This cycle maybe can be encapsulated in a function
        for (WebElement row : folderRows) 
        {
            String folderId = row.findElement(By.xpath("//td[1]/a")).getAttribute("href");
            if(folderId.contains(id))
            {
                row.findElement(By.xpath("//td[3]/div/a/span[text()='Delete']")).click(); //Maybe the xpath can be saved in a variable
                break;
            }
        }
        clickElement(deleteButton);
    }

    public void viewFolderData(String folderId) {
        this.folderId = folderId;
        List<WebElement> folderRoWebElements = bringAllElements(folderTableRows);
        //Improve these lines of code with filter method from Java
        //This cycle maybe can be encapsulated in a function
        for (WebElement row : folderRoWebElements) 
        {
            String toDoItemId = row.findElement(By.xpath("//td[1]/a")).getAttribute("href");
            if(toDoItemId.contains(folderId))
            {
                this.folderTitle = row.findElement(By.xpath("//td[2]")).getText();

                row.findElement(By.xpath("//td[3]/div/a/span[text()='View']")).click(); //Maybe the xpath can be saved in a variable
                break;
            }
        }

    }

    public boolean verifyFolderViewData() {
        List<WebElement> folderDataView = bringAllElements(viewFolderData);
        //Improve these lines of code with filter method from Java
        if(folderDataView.get(0).getText().equals(folderId) &&
            folderDataView.get(1).getText().equals(this.folderTitle)) return true;
        return false;
    }

}
