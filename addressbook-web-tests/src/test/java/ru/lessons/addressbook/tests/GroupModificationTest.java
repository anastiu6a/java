package ru.lessons.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lessons.addressbook.model.GroupData;
import ru.lessons.addressbook.model.Groups;


import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

public class GroupModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test2"));
    }
  }

  @Test
  public void testGroupModification() {

    Groups before = app.group().all();
    GroupData modifyGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifyGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
    app.group().modify(group);
    Groups after = app.group().all();
    assertEquals(after.size(), before.size());
    MatcherAssert.assertThat(after, equalTo(before.without(modifyGroup).withAdded(group)));

  }

}
