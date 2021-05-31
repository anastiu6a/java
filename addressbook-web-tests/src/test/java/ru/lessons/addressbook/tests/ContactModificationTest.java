package ru.lessons.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lessons.addressbook.model.ContactData;
import ru.lessons.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().returnToHomepage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("Test-name").withLastname("Test-last-name").withMobile("+18888888888").withEmail("test@test.com").withAddress("Test-address"));
    }
  }

  @Test
  public void testContactModification() {

    Contacts before = app.contact().all();
    ContactData modifyContact = before.iterator().next();
    ContactData contact = new ContactData()
            .withId(modifyContact.getId()).withFirstname("Test-name").withLastname("Test-last-name").withMobile("+18888888888").withEmail("test@test.com").withAddress("Test-address");
    app.contact().modify(contact);
    Contacts after = app.contact().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifyContact).withAdded(contact)));
  }


}
