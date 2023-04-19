package my;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Logic {
    public Logic() {
    }




    public List <Patient> readFromFile(String file){
        List <Patient> patients = new ArrayList<>(100);
        String str="";
        Path path = Paths.get(file);
        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNext()) {
                str = scanner.nextLine();
                String[] strs = str.trim().split("\\|");
                patients.add(new Patient(Integer.parseInt(strs[0]), strs[1], strs[2], strs[3],
                        strs[4], strs[5], Integer.parseInt(strs[6]), strs[7]));
            }

    }catch (IOException ignored) {
        }
        return patients;
    }
    public void writeToFile(Path file, List<Patient> patients){
        try (BufferedWriter bfr = Files.newBufferedWriter(file)){
            for (Patient p: patients){
                bfr.write(p.createString());
            }
        }catch (IOException ignored){
        }
    }
    public void addToFile(Path file, List<Patient> patients){
        try (BufferedWriter bfr=Files.newBufferedWriter(file, StandardOpenOption.APPEND)){
            for (Patient p: patients){
                bfr.write(p.createString());
            }
        }catch (IOException ignored){
        }
    }
    public List<Patient> addToList(int q){
        List<Patient> patients = new ArrayList<>();

        for (int i=0; i<q; i++){
            patients.add(scannerPatient()) ;
        }
        return patients;
    }
    public List<Patient> filterDiagnosis(List<Patient> patients, String diagnosis) { //указаний діагноз в порядку зростання номерів медичної картки
        List<Patient> temp = new ArrayList<>();

        for (Patient p: patients) {
            if (Objects.equals(p.getDiagnosis(), diagnosis)) {
                temp.add(p);
            }
        }
        temp.sort(Comparator.comparingInt(Patient::getNumberMedCart));
        return temp;

    }
    public List<Patient> filterNumberMedCart(List<Patient> patients, int numberLow, int numberUp) { //номер медичної карти у яких знаходиться в заданому інтервалі
        List<Patient> temp = new ArrayList<>();

        for(Patient p: patients) {
            if (numberLow <= p.getNumberMedCart() && numberUp >= p.getNumberMedCart()) {
                temp.add(p);
            }
        }

        return temp;
    }
    public List<Patient> filterPhone(List<Patient> patients, int phone) { //фільтер номер телефона яких починається з вказаної цифри
        List<Patient> temp = new ArrayList<>();

        for(Patient p: patients) {
            char c = p.getPhone().charAt(0);
            int n = c - '0';
            if (n==phone){
                temp.add(p);
            }

        }
        return temp;
    }
    public List<String> filterDiagnosis(List<Patient> patients){ //список діагнозів пацієнтів із вказанням кількості пацієнтів
        Map<String, Integer> diagnosis = new HashMap<>();

        for(Patient p: patients) {
            String diagnoz = p.getDiagnosis();

            diagnosis.put(diagnoz, diagnosis.getOrDefault(diagnoz, 0) + 1);
        }
        List<Map.Entry<String, Integer>>sorted = new ArrayList<>(diagnosis.entrySet());
        sorted.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        List<String> temp = new ArrayList<>(0);
        for (Map.Entry<String, Integer>entry : sorted){
            temp.add(entry.getKey() + " - " + entry.getValue());
        }

        return temp;
    }

    public Patient scannerPatient(){
        Scanner s = new Scanner(System.in);
        System.out.println("Введіть id");
        int id = s.nextInt();
        System.out.println("Введіть прізвище");
        String surname = s.next();
        System.out.println("Введіть ім'я");
        String name = s.next();
        System.out.println("Введіть ім'я по-батькові");
        String fatherName = s.next();
        System.out.println("Введіть адресу");
        String address = s.next();
        System.out.println("Введіть номер телефону");
        String phone = s.next();
        System.out.println("Введіть номер медичної картки");
        int numberMedCart = s.nextInt();
        System.out.println("Введіть діагноз");
        String diagnosis = s.next();
        return new Patient(id, surname, name, fatherName, address, phone, numberMedCart, diagnosis);
    }

}
