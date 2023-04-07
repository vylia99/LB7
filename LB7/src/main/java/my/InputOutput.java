package my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputOutput {
    ArrayList<Patient> patients;
    Logic logic;

    public InputOutput() {
        logic = new Logic();
    }
    public void printPatient(List<Patient> patients) {
        for (Patient p: patients) {
            System.out.println(p);
        }
    }

    public void printFilterDiagnosis(List<Patient> patients) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть діагноз");
        String st = scanner.nextLine();
        System.out.println(st);
      printPatient(logic.filterDiagnosis(patients, st));
    }

    public void printFilterNumberMedCart(List<Patient> patients) {
        Scanner c = new Scanner(System.in);
        System.out.println("Введіть початок інтервалу");
        int numLow = c.nextInt();
        System.out.println("Введіть кінець інтервалу");
        int numUp = c.nextInt();
        printPatient(logic.filterNumberMedCart(patients,numLow, numUp));
    }

    public void printFilterPhone(List<Patient> patients) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введіть початкову цифру номеру телефону");
        int f = s.nextInt();
        List<Patient> list = logic.filterPhone(patients, f);
        System.out.println(list.size());
        printPatient(list);
    }

    public void printDiagnosis(List<Patient> patients) {
        System.out.println(logic.filterDiagnosis(patients));;

    }
}

