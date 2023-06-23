package db;

import model.Contact;
import model.Phone;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    List<Phone>phones = new ArrayList<>();
    List<Contact>contacts = new ArrayList<>();

    public DataBase() {
    }

    public DataBase(List<Phone> phones, List<Contact>contacts) {
        this.phones = phones;
        this.contacts = contacts;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
