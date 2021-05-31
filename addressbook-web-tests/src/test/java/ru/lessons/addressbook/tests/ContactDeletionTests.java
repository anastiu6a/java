package ru.lessons.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lessons.addressbook.model.ContactData;
import ru.lessons.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

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
    Contacts before = app.contact().all();
    ContactData deleteContact = before.iterator().next();
    int index = before.size() -1;
    app.contact().delete(deleteContact);
    Contacts after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() -1);
    assertThat(after, equalTo(before.without(deleteContact)));

  }


}
