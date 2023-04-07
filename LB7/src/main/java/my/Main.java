package my;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
   List<Patient> patients;
    String file;
    public static void main(String[] args) {
        Main prog = new Main();
        prog.run();

    }

    private void run() {
        Logic logic = new Logic();
        InputOutput printAll = new InputOutput();


        while (true){
            while (true){
                System.out.println("1: Додати запис до файлу");
                System.out.println("2: Вивести зміст файлу на екран");
                System.out.println("3: Вивести список пацієнтів, які мають указаний діагноз в порядку зростання номерів медичної картки");
                System.out.println("4: Вивести список пацієнтів, номер медичної карти у яких знаходиться в заданому інтервалі");
                System.out.println("5: Вивести кількість та список пацієнтів, номер телефона яких починається з вказаної цифри");
                System.out.println("6: Вивести список діагнозів пацієнтів (без повторів) із вказанням кількості пацієнтів, " +
                        "що мають цей діагноз у порядку спадання цієї кількості.");
                System.out.println("0: Вийти з програми");
                Scanner sc = new Scanner(System.in);
                int k = sc.nextInt();
                int q;
                String file ;
                switch (k){
                    case 0:
                        System.out.println("Роботу завершенно");
                        System.exit(0);
                        break;
                    case 1:
                        System.out.println("Введіть кількість паціентів");
                        q = sc.nextInt();
                        List<Patient> temp = logic.addToList(q);
                        System.out.println("Введіть назву файлу");
                        this.file = sc.next();
                        Path path = Paths.get(this.file);
                        if (!Files.exists(path, new LinkOption[0])){
                            logic.writeToFile(path, temp);
                        }   else {
                            logic.addToFile(path, temp);}
                        break;
                    case 2:
                        System.out.println("Введіть назву файлу");
                        file = sc.next();
                        System.out.println("Зміст файлу");
                        patients = logic.readFromFile(file);
                        printAll.printPatient(patients);
                        break;
                    case 3:
                        System.out.println("Введіть назву файлу");
                        file = sc.next();
                        patients = logic.readFromFile(file);
                        printAll.printFilterDiagnosis(patients);
                        break;
                    case 4:
                        System.out.println("Введіть назву файлу");
                        file = sc.next();
                        patients = logic.readFromFile(file);
                        printAll.printFilterNumberMedCart(patients);
                    case  5:
                        System.out.println("Введіть назву файлу");
                        file = sc.next();
                        patients = logic.readFromFile(file);
                        printAll.printFilterPhone(patients);
                    case 6:
                        System.out.println("Введіть назву файлу");
                        file = sc.next();
                        patients = logic.readFromFile(file);
                        printAll.printDiagnosis(patients);
                }   }
        }
    }


}