package ru.lessons.addressbook.tests;

import org.testng.annotations.*;
import ru.lessons.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("Test0", null, null));
  }

}
