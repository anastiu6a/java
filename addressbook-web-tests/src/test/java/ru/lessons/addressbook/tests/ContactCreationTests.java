package ru.lessons.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.lessons.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.contact().returnToHomepage();
    List<ContactData> before = app.contact().list();
    app.contact().initContactCreation();
    ContactData contact = new ContactData("Test-name", "Test-last-name", "+18888888888", "test@test.com", "Test-address");
    app.contact().create(contact);
    app.contact().returnToHomepage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() +1);
    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

  }

}
