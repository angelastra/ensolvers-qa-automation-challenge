package qachallenge.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qachallenge.pages.FolderPage;
import qachallenge.testComponents.BaseTest;

public class FolderTest extends BaseTest {

    @BeforeMethod
    public void accessFoldersPage(){
        homePage.clickOnManageFoldersButton();
    }

    @Test
    public void createFolderTest(){
        FolderPage folderPage = new FolderPage(driver, "House Tasks");
        folderPage.createNewFolder();
        Assert.assertTrue(folderPage.newFolderCreatedAlertIsDisplayed());
        Assert.assertTrue(folderPage.verifyFolderInformationInTable());
    }

    @Test
    public void editFolderTest(){
        FolderPage folderPage = new FolderPage(driver);
        folderPage.editFolder("3","Job Tasks");
        Assert.assertTrue(folderPage.updatedFolderAlertIsDisplayed(),"Unable to find the alert about the edited to do item");
        Assert.assertTrue(folderPage.verifyFolderInformationInTable(),"The information about the updated folder doesnt match in the table");
    }


    @Test
    public void deleteFolderTest(){
        FolderPage folderPage = new FolderPage(driver);
        folderPage.deleteFolder("3");
        Assert.assertTrue(folderPage.deletedToDoItemAlertIsDisplayed(),"Unable to find the alert about the deleted to do item");
        //Assert.assertTrue(toDoItemPage.verifyToDoItemInformationInTable(),"The information about the updated to do item doesnt match in the table");
    }

    @Test
    public void viewFolderTest(){
         FolderPage folderPage = new FolderPage(driver);
         folderPage.viewFolderData("4");
        Assert.assertTrue(folderPage.verifyFolderViewData(),"The information in the view page doesnt match with the information in the To Do Items Page"); 
    }
}
