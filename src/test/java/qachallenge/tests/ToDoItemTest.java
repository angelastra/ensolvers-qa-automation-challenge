package qachallenge.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qachallenge.pages.ToDoItemPage;
import qachallenge.testComponents.BaseTest;

public class ToDoItemTest extends BaseTest {


    @BeforeMethod
    public void accessToDoItemsPage(){
        homePage.clickOnManageToDoItemsButton();
    }

    @Test
    public void createToDoItemTest(){
        ToDoItemPage toDoItemsPage = new ToDoItemPage(driver,"Go to the supermarket","Go to BAE to buy some products","1");
        toDoItemsPage.createNewToDoItem();
        Assert.assertTrue(toDoItemsPage.newToDoItemCreatedAlertIsDisplayed(),"Unable to find the alert about the created to do item");
        Assert.assertTrue(toDoItemsPage.verifyToDoItemInformationInTable(),"The created to do item doesnt appear in the table");
    }

    @Test
    public void editToDoItemTest(){
        ToDoItemPage toDoItemPage = new ToDoItemPage(driver);
        //Posibility of not pass arguments to maintain the same information or part of it
        toDoItemPage.editToDoItem("Pay services", "Pay water service and gas service", "1","1");
        Assert.assertTrue(toDoItemPage.updatedToDoItemAlertIsDisplayed(),"Unable to find the alert about the edited to do item");
        Assert.assertTrue(toDoItemPage.verifyToDoItemInformationInTable(),"The information about the updated to do item doesnt match in the table");
    }


    @Test
    public void deleteToDoItemTest(){
        ToDoItemPage toDoItemPage = new ToDoItemPage(driver);
        toDoItemPage.deleteToDoItem("1");
        Assert.assertTrue(toDoItemPage.deletedToDoItemAlertIsDisplayed(),"Unable to find the alert about the deleted to do item");
        //Assert.assertTrue(toDoItemPage.verifyToDoItemInformationInTable(),"The information about the updated to do item doesnt match in the table");
    }

    @Test
    public void viewToDoItemTest(){
        ToDoItemPage toDoItemPage = new ToDoItemPage(driver);
        //Posibility of not pass arguments to maintain the same information or part of it
        toDoItemPage.viewToDoItem("1");
        Assert.assertTrue(toDoItemPage.verifyToDoItemView(),"The information in the view page doesnt match with the information in the To Do Items Page"); 
    }
}
