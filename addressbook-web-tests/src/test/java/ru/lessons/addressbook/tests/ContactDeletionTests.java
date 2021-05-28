package ru.lessons.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lessons.addressbook.model.ContactData;

import java.util.Set;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {

    app.contact().returnToHomepage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("Test-name").withLastname("Test-last-name").withMobile("+18888888888").withEmail("test@test.com").withAddress("Test-address"));
    }
  }

  @Test
  public void testContactDeletion() {

    app.contact().returnToHomepage();
    Set<ContactData> before = app.contact().all();
    ContactData deleteContact = before.iterator().next();
    int index = before.size() -1;
    app.contact().delete(deleteContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() -1);
    before.remove(deleteContact);
    Assert.assertEquals(before, after);

  }


}
