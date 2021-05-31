package ru.lessons.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.lessons.addressbook.model.ContactData;
import ru.lessons.addressbook.model.Contacts;

import java.util.List;


public class ContactHelper extends BaseHelper {
  public ContactHelper (WebDriver wd) {
    super(wd);
  }
  public void submitContactCreation() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"),contactData.getFirstname());
    type(By.name("lastname"),contactData.getLastname());
    type(By.name("mobile"),contactData.getMobile());
    type(By.name("email"),contactData.getEmail());
    type(By.name("address"),contactData.getAddress());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[id ='"+ id +"']")).click();
  }

  public void initContactModificationById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  }

  public void submitContactModification() {
    click(By.xpath("(//input[@name='update'])[2]"));
  }

  public void initContactDeletion() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact);
    submitContactCreation();
  }

  public void modify(ContactData contact) {
    returnToHomepage();
    initContactModificationById(contact.getId());
    fillContactForm(contact);
    submitContactModification();
    returnToHomepage();
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    initContactDeletion();
    returnToHomepage();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element: elements){
      String firstname = element.findElement(By.xpath(".//td[3]")).getText();
      String lastname = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
    }
    return contacts;
  }

  public void returnToHomepage() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

}

