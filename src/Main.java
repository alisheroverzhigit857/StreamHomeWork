import db.DataBase;
import enums.Brand;
import implClass.ContactServiceImpl;
import implClass.PhoneServiceImpl;
import model.Contact;
import model.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*Жаны проект тузунуз.
        3 пакет тузунуз model, db, service.
                model пакеттин ичине Phone жана Contact деген класс тузунуз.
        Phone (id, name, brand, contacts(List)) полелери болуш керек.
                Contact (name, phoneNumber).
                db пакеттин ичинде DataBase класс бар, свойствасы катары телефондордун листин алат, бул класс бизге база данных болот.
                service пакет ичинде PhoneService жана ContactService interface тер болот.
        Ушул 2 interface ти implements кылган 2 класс тузунуз(PhoneServiceImpl жана ContactServiceImpl)ушул 2 класстын ичине
        свойства катары биздин DataBase класс келсин жана маалыматтарды ошол жактан алып, сактап, очуруп жана башка манипуляция кылсак болот
        PhoneService methods :
        - String addPhone(Phone phone);
        // with stream
        - Phone getPhoneById(int phoneId);
        // with stream
        - Phone updatePhoneNameById(int phoneId, String newName);
        // with stream
        - List<Phone> getAllPhones();
        // with stream
        - List<Phone> getAllPhonesByBrand(String brand);
        - void deletePhoneById(int phoneId);
        10. ContactService methods :
        - String addContactToPhone(int phoneId, Contact contact);
        // with stream (телефонду phoneId мн табып, ичинен контантактардын арасынан contactName мн табып кайтарып берсин)
        - Contact findContactByName(int phoneId, String contactName);
        // with stream
        - Contact findContactByPhoneNumber(int phoneId, String phoneNumber);
        // with stream (телефонду phoneId мн табып, ичинен контантактарды аттарын осуу тартибинде чыгарып берсин)
        -List<Contact>sortContactsByName(int phoneId);
        - void deleteContactByNameFromPhone(int phoneId, String contactName);*/

        List<Contact>contacts = new ArrayList<>(
                List.of(new Contact("Manas bayke","0221346578"),
                        new Contact("Aizada","0779876523"),
                        new Contact("Zhanuzak bayke","0774098799")));

        Phone phone = new Phone(1L,"IPhone", Brand.APPLE,contacts);
        List<Phone>phones = new ArrayList<>(
                List.of(
                        new Phone(1L,"IPhone", Brand.APPLE,contacts),
                        new Phone(2L,"Samsung A5", Brand.SAMSUNG,contacts)));

        DataBase dataBase = new DataBase();
        PhoneServiceImpl phoneService = new PhoneServiceImpl(dataBase);
        ContactServiceImpl contactService = new ContactServiceImpl(dataBase);
        while (true){
            int a = new Scanner(System.in).nextInt();
            switch (a){
                case 1:
                    System.out.println("Save method!");
                    System.out.println(phoneService.addPhone(phone));
                    break;
                case 2:
                    System.out.println("Save phones!");
                    System.out.println(phoneService.addPhones(phones));
                    break;
                case 3:
                    System.out.println("Get phone by ID!");
                    System.out.println(phoneService.getPhoneById(1L));
                    break;
                case 4:
                    System.out.println("Up date method!");
                    System.out.println("Write new name!");
                    String newName = new Scanner(System.in).nextLine();
                    phoneService.updatePhoneNameById(1L,newName);
                    break;
                case 5:
                    System.out.println("Get all method!");
                    System.out.println(phoneService.getAllPhones());
                    break;
                case 6:
                    System.out.println("Get all Phones by brand");
                    System.out.println(phoneService.getAllPhonesByBrand(Brand.APPLE));
                    break;
                case 7:
                    System.out.println("Delet Phones!");
                    phoneService.deletePhoneById(2L);
                    break;
                case 8:
                    System.out.println("Add contact to phone!");
                   // String name = new Scanner(System.in).nextLine();
                    contactService.addContactToPhone(1L, new Contact("BAKTULAN","4345342"));
                    break;
                case 9:
                    System.out.println("Find contact by name!");
                    System.out.println(contactService.findContactByName(1L, "Zhanuzak bayke"));
                    break;
                case 10:
                    System.out.println("Find contact by phone number!");
                    System.out.println(contactService.findContactByPhoneNumber(1L, "0779876523"));
                    break;
                case 11:
                    System.out.println("Delete method!");
                    contactService.deleteContactByNameFromPhone(1L,"Aizada");
                    break;
                case 12:
                    System.out.println("Sort contact by name!");
                    System.out.println(contactService.sortContactsByName(1L));
            }
        }
    }
}


















