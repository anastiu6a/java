package ru.lessons.addressbook.model;

public class ContactData {
  public final String firstname;
  public final String lastname;
  public final String mobile;
  public final String email;
  public final String address;

  public ContactData(String firstname, String lastname, String mobile, String email, String address) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.mobile = mobile;
    this.email = email;
    this.address = address;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getMobile() {
    return mobile;
  }

  public String getEmail() {
    return email;
  }

  public String getAddress() {
    return address;
  }
}
