package ru.lessons.addressbook;


import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupForm(new GroupData("Test0", "Test1", "Test2"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
