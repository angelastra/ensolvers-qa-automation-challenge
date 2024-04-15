package qachallenge.pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToDoItemPage extends BasePage {

    //Locators
    String createNewToDoItemLink = "//a[@href='/to-do-item/new']";
    String toDoTitleInput = "//input[@id='to-do-item-title']";
    String toDoDescriptionInput = "//input[@id='to-do-item-description']";
    String toDoFolderSelect = "//select[@id='to-do-item-folder']";
    String saveNewItemButton = "//button[@id='save-entity']";
    String newToDoItemCreatedAlert = "//div[contains(text(),'A new toDoItem is created')]";
    String updatedToDoItemAlert = "//div[contains(text(),'A toDoItem is updated')]";
    String deletedToDoItemAlert = "//div[contains(text(),'A toDoItem is deleted')]";
    String toDoItemsTableRows = "//table/tbody/tr";
    String deleteButton = "//button[@data-cy='entityConfirmDeleteButton']";
    String viewToDoItemData = "//dl/dd";
    WebDriver driver;
    String toDoItemTitle;
    String toDoItemDescription;
    String toDoFolderItem;
    String toDoItemId;

    public ToDoItemPage(WebDriver driver,String toDoItemTitle,String toDoItemDescription,String toDoFolderItem) {
        super(driver);
        this.driver = driver;
        this.toDoItemTitle = toDoItemTitle;
        this.toDoItemDescription = toDoItemDescription;
        this.toDoFolderItem = toDoFolderItem;
    }

    public ToDoItemPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void createNewToDoItem(){
        clickElement(createNewToDoItemLink);
        write(toDoTitleInput, toDoItemTitle);
        write(toDoDescriptionInput, toDoItemDescription);
        selectFromDropdownByVisibleText(toDoFolderSelect, toDoFolderItem);
        clickElement(saveNewItemButton);
    }

    public boolean newToDoItemCreatedAlertIsDisplayed(){
        return elementIsDisplayed(newToDoItemCreatedAlert);
    }

    public boolean updatedToDoItemAlertIsDisplayed(){
        return elementIsDisplayed(updatedToDoItemAlert);
    }

    public boolean deletedToDoItemAlertIsDisplayed(){
        return elementIsDisplayed(deletedToDoItemAlert);
    }

    public boolean verifyToDoItemInformationInTable()
    {
        List<WebElement> todoItemsRows = bringAllElements(toDoItemsTableRows);
        //Improve these lines of code with filter method from Java
        for (WebElement row : todoItemsRows) 
        {
            String toDoItemTitleR = row.findElement(By.xpath("//td[2]")).getText();
            String toDoItemDescriptionR = row.findElement(By.xpath("//td[3]")).getText();
            String toDoItemFolderR = row.findElement(By.xpath("//td[4]")).getText();

            if(toDoItemTitleR.equals(toDoItemTitle) && toDoItemDescriptionR.equals(toDoItemDescription) && toDoItemFolderR.equals(toDoFolderItem)) return true;
        }
        return false;
    }

    public void editToDoItem(String toDoItemTitle,String toDoItemDescription,String toDoFolderItem,String id)
    {
        List<WebElement> todoItemsRows = bringAllElements(toDoItemsTableRows);
        //Improve these lines of code with filter method from Java
        //This cycle maybe can be encapsulated in a function
        for (WebElement row : todoItemsRows) 
        {
            String toDoItemId = row.findElement(By.xpath("//td[1]/a")).getAttribute("href");
            if(toDoItemId.contains(id))
            {
                row.findElement(By.xpath("//td[5]/div/a/span[text()='Edit']")).click(); //Maybe the xpath can be saved in a variable
                break;
            }
        }

        write(toDoTitleInput, toDoItemTitle);
        write(toDoDescriptionInput, toDoItemDescription);
        selectFromDropdownByVisibleText(toDoFolderSelect, toDoFolderItem);
        clickElement(saveNewItemButton);
        //Assign new values to the variables that will be verify
        this.toDoItemTitle = toDoItemTitle;
        this.toDoItemDescription = toDoItemDescription;
        this.toDoFolderItem = toDoFolderItem;

    }

    public void deleteToDoItem(String id)
    {
        List<WebElement> todoItemsRows = bringAllElements(toDoItemsTableRows);
        //Improve these lines of code with filter method from Java
        //This cycle maybe can be encapsulated in a function
        for (WebElement row : todoItemsRows) 
        {
            String toDoItemId = row.findElement(By.xpath("//td[1]/a")).getAttribute("href");
            if(toDoItemId.contains(id))
            {
                row.findElement(By.xpath("//td[5]/div/a/span[text()='Delete']")).click(); //Maybe the xpath can be saved in a variable
                break;
            }
        }
        clickElement(deleteButton);
    }
    
    public void viewToDoItem(String id)
    {
        this.toDoItemId = id;
        List<WebElement> todoItemsRows = bringAllElements(toDoItemsTableRows);
        //Improve these lines of code with filter method from Java
        //This cycle maybe can be encapsulated in a function
        for (WebElement row : todoItemsRows) 
        {
            String toDoItemId = row.findElement(By.xpath("//td[1]/a")).getAttribute("href");
            if(toDoItemId.contains(id))
            {
                this.toDoItemTitle = row.findElement(By.xpath("//td[2]")).getText();
                this.toDoItemDescription = row.findElement(By.xpath("//td[3]")).getText();
                this.toDoFolderItem = row.findElement(By.xpath("//td[4]")).getText();
                row.findElement(By.xpath("//td[5]/div/a/span[text()='View']")).click(); //Maybe the xpath can be saved in a variable
                break;
            }
        }
    }

    public boolean verifyToDoItemView(){
        List<WebElement> todoItemDataView = bringAllElements(viewToDoItemData);
        //Improve these lines of code with filter method from Java
        if(todoItemDataView.get(0).getText().equals(toDoItemId) &&
        todoItemDataView.get(1).getText().equals(toDoItemTitle) &&
        todoItemDataView.get(2).getText().equals(toDoItemDescription) &&
        todoItemDataView.get(4).getText().equals(toDoFolderItem)) return true;
        
        return false;
    }
}
