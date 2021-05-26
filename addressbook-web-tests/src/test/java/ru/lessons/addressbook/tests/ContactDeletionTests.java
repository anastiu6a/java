package ru.lessons.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lessons.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {

    app.contact().returnToHomepage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("Test-name").withLastname("Test-last-name").withMobile("+18888888888").withEmail("test@test.com").withAddress("Test-address"));
    }
  }

  @Test
  public void testContactDeletion() {

    app.contact().returnToHomepage();
    List<ContactData> before = app.contact().list();
    int index = before.size() -1;
    app.contact().delete(index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() -1);
    before.remove(index);
    Assert.assertEquals(before, after);

  }


}
