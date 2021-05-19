package ru.lessons.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.lessons.addressbook.model.ContactData;
import ru.lessons.addressbook.model.GroupData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().returnToHomepage();
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Test-name", "Test-last-name", "+18888888888", "test@test.com", "Test-address"));
    }
    app.getNavigationHelper().returnToHomepage();
    app.getContactHelper().selectContact(0);
    app.getContactHelper().initContactDeletion();
    app.getNavigationHelper().returnToHomepage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before -1);
  }
}
