package implClass;

import db.DataBase;
import enums.Brand;
import model.Phone;
import service.PhoneService;

import java.util.List;

public class PhoneServiceImpl implements PhoneService {
    private DataBase dataBase;

    public PhoneServiceImpl(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public String addPhone(Phone phone) {
        dataBase.getPhones().add(phone);
        return "Saved!";
    }

    @Override
    public String addPhones(List<Phone> phones) {
        dataBase.getPhones().addAll(phones);
        return "SAVED PHONES!";
    }

    @Override
    public Phone getPhoneById(Long phoneId) {
        return dataBase.getPhones().stream().filter(phone -> phone.getId() == phoneId).findFirst().orElse(null);

    }

    @Override
    public Phone updatePhoneNameById(Long phoneId, String newName) {
        List<Phone> list = dataBase.getPhones().stream().filter(phone -> phone.getId().equals(phoneId)).toList();
        list.forEach(phone -> phone.setName(newName));
        Phone phone = new Phone();
        for (Phone p : list) {
            if (p.getId().equals(phoneId)){
                phone.setId(p.getId());
                phone.setName(p.getName());
                phone.setBrand(p.getBrand());

            }
        }
       /* Optional<Phone> first = dataBase.getPhones().stream().filter(phone -> phone.getId() == phoneId).findFirst();
        if (first.isPresent()){
            Phone phone = first.get();
            phone.setName(newName);
            System.out.println("Озгортулду!");
            return phone;
        }*/
        return phone;
    }

    @Override
    public List<Phone> getAllPhones() {
        List<Phone> list = dataBase.getPhones().stream().toList();
        return list;
    }

    @Override
    public List<Phone> getAllPhonesByBrand(Brand brand) {
        List<Phone> list = dataBase.getPhones().stream().filter(phone -> phone.getBrand().equals(brand)).toList();
        return list;
    }

    @Override
    public void deletePhoneById(Long phoneId) {
        dataBase.getPhones().removeIf(phone -> phone.getId().equals(phoneId));
    }
}
