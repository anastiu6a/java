package ru.lessons.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.lessons.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() throws Exception {
    app.contact().returnToHomepage();
    List<ContactData> before = app.contact().list();
    app.contact().initContactCreation();
    ContactData contact = new ContactData()
            .withFirstname("Test-name").withLastname("Test-last-name").withMobile("+18888888888").withEmail("test@test.com").withAddress("Test-address");
    app.contact().create(contact);
    app.contact().returnToHomepage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() +1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }

}
