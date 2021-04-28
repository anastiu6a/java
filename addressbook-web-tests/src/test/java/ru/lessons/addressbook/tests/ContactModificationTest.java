package ru.lessons.addressbook.tests;

import org.testng.annotations.Test;
import ru.lessons.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification() {

    app.getNavigationHelper().returnToHomepage();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("test1", "test2","test3","test4", "test5"));
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().returnToHomepage();
  }

}
