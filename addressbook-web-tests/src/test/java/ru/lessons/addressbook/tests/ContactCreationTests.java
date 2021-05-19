package ru.lessons.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.lessons.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getNavigationHelper().returnToHomepage();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().initContactCreation();
    app.getContactHelper().createContact(new ContactData("Test-name", "Test-last-name", "+18888888888", "test@test.com", "Test-address"));
    app.getNavigationHelper().returnToHomepage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before +1);
    app.logout();
  }

}
