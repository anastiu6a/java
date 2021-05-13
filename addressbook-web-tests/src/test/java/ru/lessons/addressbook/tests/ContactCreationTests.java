package ru.lessons.addressbook.tests;

import org.testng.annotations.Test;
import ru.lessons.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.getContactHelper().initContactCreation();
    app.getContactHelper().createContact(new ContactData("Test-name", "Test-last-name", "+18888888888", "test@test.com", "Test-address"));
    app.getNavigationHelper().returnToHomepage();
    app.logout();
  }

}
