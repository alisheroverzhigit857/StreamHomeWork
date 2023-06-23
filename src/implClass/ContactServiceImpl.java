package implClass;

import db.DataBase;
import model.Contact;
import model.Phone;
import service.ContactService;

import java.util.Comparator;
import java.util.List;

public class ContactServiceImpl implements ContactService {

    private DataBase dataBase;

    public ContactServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addContactToPhone(Long phoneId, Contact contact) {
        for (Phone p : dataBase.getPhones()) {
            if (p.getId().equals(phoneId)){
                    if (p.getContacts()!=null)
                        p.getContacts().add(contact);
                    }
        }
        return "Successfully added";
    }

    @Override
    public Contact findContactByName(Long phoneId, String contactName) {
        List<Phone> list = dataBase.getPhones().stream().filter(phone -> phone.getId().equals(phoneId)).toList();
        List<Contact> list1 = list.get(0).getContacts().stream().filter(contact -> contact.getName().equalsIgnoreCase(contactName)).toList();
      Contact contact = new Contact();
        for (Contact c : list1) {
            if (c.getName().equalsIgnoreCase(contactName)){
                contact.setName(c.getName());
                contact.setPhoneNumber(c.getPhoneNumber());
            }
        }
        return contact;
    }

    @Override
    public Contact findContactByPhoneNumber(Long phoneId, String phoneNumber) {
        List<Phone> list = dataBase.getPhones().stream().filter(phone -> phone.getId().equals(phoneId)).toList();
        List<Contact> list1 = list.get(0).getContacts().stream().filter(contact -> contact.getPhoneNumber().equalsIgnoreCase(phoneNumber)).toList();
       Contact contact = new Contact();
        for (Contact c : list1) {
            if (c.getPhoneNumber().equalsIgnoreCase(phoneNumber)){
                contact.setName(c.getName());
                contact.setPhoneNumber(c.getPhoneNumber());
            }
        }
        return contact;
    }

    @Override
    public List<Contact> sortContactsByName(Long phoneId) {
        List<Phone> list = dataBase.getPhones().stream().filter(phone -> phone.getId().equals(phoneId)).toList();
        List<Contact> list1 = list.get(0).getContacts().stream().sorted(Comparator.comparing(Contact::getName)).toList();

        return list1;
    }

    @Override
    public void deleteContactByNameFromPhone(Long phoneId, String contactName) {
        List<Phone> list = dataBase.getPhones().stream().filter(phone -> phone.getId().equals(phoneId)).toList();
        list.forEach(phone -> phone.getContacts().removeIf(contact -> contact.getName().equalsIgnoreCase(contactName)));
        System.out.println("Is deleted!");
    }
}
