package UI;

import Controller.*;
import Domain.*;
import Repository.*;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    public ArztController arztController;
    public PatientController patientController;
    public MedikamenteController medikamentController;
    public OperationController operationController;
    public SpezialisierungController spezialisierungController;
    public KrankheitController krankheitController;
    public UserInterface(ArztController arztController, PatientController patientController, MedikamenteController medikamentController, OperationController operationController, SpezialisierungController spezialisierungController, KrankheitController krankheitController) {
        this.arztController = arztController;
        this.patientController = patientController;
        this.medikamentController = medikamentController;
        this.operationController = operationController;
        this.spezialisierungController = spezialisierungController;
        this.krankheitController = krankheitController;
    }

    public static void Menu() {
        System.out.println("1. Doctor.");
        System.out.println("2. Patient.");
        System.out.println("3. Drug.");
        System.out.println("4. Operation.");
        System.out.println("5. Speciality.");
        System.out.println("6. Illness.");
        System.out.println("7. Office.");
        System.out.println("8. Consult.");
        System.out.println("9. Hospital.");
    }

    public static void Menu2() {
        System.out.println("Who uses the database?");
        System.out.println("1. Patient");
        System.out.println("2. Hospital staff");
        System.out.println("Enter your choice: ");
    }

     public static void Menu3() {
        System.out.println("1. Add.");
        System.out.println("2. Update.");
        System.out.println("3. Delete.");
        System.out.println("4. See all.");
        System.out.println("What do you pick?");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean stop = false;
        while (!stop) {
            Menu2();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("First we need to get to know you.");
                    String name1 = scanner.nextLine();
                    break;
                case 2:
                    Menu3();
                    int choice2 = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice2) {
                        case 1:
                            Menu();
                            int choice3 = scanner.nextInt();
                            scanner.nextLine();
                            switch (choice3) {
                                case 1:
                                    addDoctor();
                                    break;
                                case 2:
                                    addPatient();
                                    break;
                                case 3:
                                    addDrug();
                                    break;
                                case 4:
                                    addOperation();
                                    break;
                                case 5:
                                    addSpeciality();
                                    break;
                                case 6:
                                    addIllness();
                                    break;
                                default:
                                    System.out.println("Invalid choice.\n");
                                    break;
                            }
                            break;
                        case 2:
                            Menu();
                            int choice5 = scanner.nextInt();
                            scanner.nextLine();
                            switch (choice5) {
                                case 1:
                                    updateDoctor();
                                    break;
                                case 2:
                                    updatePatient();
                                    break;
                                case 3:
                                    updateDrug();
                                    break;
                                case 4:
                                    updateOperation();
                                    break;
                                case 5:
                                    updateSpeciality();
                                    break;
                                case 6:
                                    updateIllness();
                                    break;
                                default:
                                    System.out.println("Invalid choice.\n");
                                    break;
                            }
                            break;
                        case 3:
                            Menu();
                            int choice6 = scanner.nextInt();
                            scanner.nextLine();
                            switch (choice6) {
                                case 1:
                                    deleteDoctor();
                                    break;
                                case 2:
                                    deletePatient();
                                    break;
                                case 3:
                                    deleteDrug();
                                    break;
                                case 4:
                                    deleteOperation();
                                    break;
                                case 5:
                                    deleteSpeciality();
                                    break;
                                case 6:
                                    deleteIllness();
                                    break;
                                default:
                                    System.out.println("Invalid choice.\n");
                                    break;
                            }
                            break;
                        case 4:
                            Menu();
                            int choice4 = scanner.nextInt();
                            scanner.nextLine();
                            switch (choice4) {
                                case 1:
                                    showDoctor();
                                    break;
                                case 2:
                                    showPatient();
                                    break;
                                case 3:
                                    showDrug();
                                    break;
                                case 4:
                                    showOperation();
                                    break;
                                case 5:
                                    showSpeciality();
                                    break;
                                case 6:
                                    showIllness();
                                    break;
                                default:
                                    System.out.println("Invalid choice.\n");
                                    break;
                            }
                            break;

                        default:
                            System.out.println("Invalid choice.\n");
                            break;
                    }
                    break;
                default:
                    System.out.println("Invalid choice.\n");
                    break;
            }
        }
        String answer = "-";
        while (!answer.equals("no") && !answer.equals("yes")) {
            System.out.println("\nWant to continue? (yes/ no)\n");
            answer = scanner.nextLine();
            if (answer.equals("no")) {
                System.out.println("Bye.\n");
                stop = true;
            } else if (!answer.equals("yes")) {
                System.out.println("Answer not valid. Try again.\n");
            }
        }
    }
    public void addDoctor () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID Doctor: ");
        int arztID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name Doctor: ");
        String name = scanner.nextLine();
        System.out.print("Vorname Doctor: ");
        String vorname = scanner.nextLine();
        System.out.print("Geburstdatum Doctor: ");
        String geburstdatum = scanner.nextLine();
        System.out.print("KrankenhausID Doctor: ");
        int KrankenhausID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Kontakttelefon Doctor: ");
        String kontakttelefon = scanner.nextLine();
        System.out.print("SpecialityID Doctor: ");
        int spezialisierungID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("OfficeID Doctor: ");
        int kabinettID = scanner.nextInt();
        scanner.nextLine();
        arztController.addArzt(arztID, name, vorname, geburstdatum, KrankenhausID, kontakttelefon, spezialisierungID, kabinettID);

    }

    public void updateDoctor(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID of the Doctor you want to change: ");
        int arztID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name Doctor: ");
        String name = scanner.nextLine();
        System.out.print("Vorname Doctor: ");
        String vorname = scanner.nextLine();
        System.out.print("Geburstdatum Doctor: ");
        String geburstdatum = scanner.nextLine();
        System.out.print("KrankenhausID Doctor: ");
        int KrankenhausID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Kontakttelefon Doctor: ");
        String kontakttelefon = scanner.nextLine();
        System.out.print("SpecialityID Doctor: ");
        int spezialisierungID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("OfficeID Doctor: ");
        int kabinettID = scanner.nextInt();
        scanner.nextLine();
        arztController.updateArzt(arztID, name, vorname, geburstdatum, KrankenhausID, kontakttelefon, spezialisierungID, kabinettID);
    }

    public void deleteDoctor(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID von den Doctor den du loschen willst: ");
        int arztID = scanner.nextInt();
        scanner.nextLine();
        arztController.deleteArzt(arztID);
        System.out.println("Gut geloscht.");
    }

    public void addPatient(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID von Patient ");
        int patientID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name Patient: ");
        String name = scanner.nextLine();
        System.out.print("Vorname Patient: ");
        String vorname = scanner.nextLine();
        System.out.print("Geburstdatum Patient: ");
        String geburstdatum = scanner.nextLine();
        System.out.print("Kontakttelefon Patient: ");
        String kontakttelefon = scanner.nextLine();
        System.out.print("GesundheitskarteID Patient: ");
        int gesundheitskarteID = scanner.nextInt();
        scanner.nextLine();
        patientController.addPatient(patientID,name, vorname, geburstdatum, kontakttelefon, gesundheitskarteID);
    }

    public void updatePatient(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID of the patient you want to change: ");
        int patientID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name Patient: ");
        String name = scanner.nextLine();
        System.out.print("Vorname Patient: ");
        String vorname = scanner.nextLine();
        System.out.print("Geburstdatum Patient: ");
        String geburstdatum = scanner.nextLine();
        System.out.print("Kontakttelefon Patient: ");
        String kontakttelefon = scanner.nextLine();
        System.out.print("GesundheitskarteID Patient: ");
        int gesundheitskarteID = scanner.nextInt();
        scanner.nextLine();
        patientController.updatePateint(patientID,name, vorname, geburstdatum, kontakttelefon, gesundheitskarteID);
    }

    public void deletePatient(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID von Patient: ");
        int patientID = scanner.nextInt();
        scanner.nextLine();
        patientController.deletePateint(patientID);
        System.out.println("Gut geloscht.");
    }

    public void showDoctor(){
        for (Arzt arzt : arztController.readAll()) {
            System.out.println(arzt.toString());
        }
    }
    public void showPatient() {
        for (Patient patient : patientController.readAll()) {
            System.out.println(patient.toString());
        }
    }

    public void addDrug(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID Medikament ");
        int medikamentID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name Medikament: ");
        String name = scanner.nextLine();
        System.out.print("Verabreichungsweg Medikament: ");
        String verabreichungsweg = scanner.nextLine();
        System.out.print("Menge Lagen Medikament ");
        int mengeLagen = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Verfallsdatum Medikament: ");
        String verfallsdatum = scanner.nextLine();
        medikamentController.addMedikament(medikamentID, name, verabreichungsweg, mengeLagen, verfallsdatum);
    }

    public void deleteDrug(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID Medikament ");
        int medikamentID = scanner.nextInt();
        scanner.nextLine();
        medikamentController.deleteMedikament(medikamentID);
        System.out.println("Gut geloscht.");
    }

    public void updateDrug(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID of the drug you want to change: ");
        int medikamentID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name Medikament: ");
        String name = scanner.nextLine();
        System.out.print("Verabreichungsweg Medikament: ");
        String verabreichungsweg = scanner.nextLine();
        System.out.print("Menge Lagen Medikament ");
        int mengeLagen = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Verfallsdatum Medikament: ");
        String verfallsdatum = scanner.nextLine();
        medikamentController.updateMedikament(medikamentID, name, verabreichungsweg, mengeLagen, verfallsdatum);
    }

    public void showDrug(){
        for (Medikament medikament : medikamentController.readall()) {
            System.out.println(medikament.toString());
        }
    }


    public void addOperation(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("PatientID Operation: ");
        int patientID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("DoctorID Operation: ");
        int arztID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Datum Operation: ");
        String datum = scanner.nextLine();
        System.out.print("KrankenheitID Operation: ");
        int krankenheitID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name Operation: ");
        String name = scanner.nextLine();
        System.out.print("DrugID Doctor: ");
        int medikamentID = scanner.nextInt();
        scanner.nextLine();
        operationController.addOperation(patientID, arztID, datum, krankenheitID, name, medikamentID);
    }

    public void updateOperation(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("PatientID of the operation you want to change: ");
        int patientID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("DoctorID of the operation you want to change: ");
        int arztID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Datum of the operation you want to change: ");
        String datum = scanner.nextLine();
        System.out.print("KrankenheitID Operation: ");
        int krankenheitID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name Operation: ");
        String name = scanner.nextLine();
        System.out.print("DrugID Doctor: ");
        int medikamentID = scanner.nextInt();
        scanner.nextLine();
        operationController.updateOperation(patientID, arztID, datum, krankenheitID, name, medikamentID);
    }

    public void deleteOperation(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("PatientID of the operation you want to delete: ");
        int patientID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("DoctorID of the operation you want to delete: ");
        int arztID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Datum of the operation you want to delete: ");
        String datum = scanner.nextLine();
        operationController.deleteOperation(patientID, arztID, datum);
    }

    public void showOperation(){
        for(Operation operation : operationController.readAll()){
            System.out.println(operation.toString());
        }
    }
    public void addSpeciality() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID Spezialisierung ");
        int spezialisierungID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name Spezialisierung: ");
        String name = scanner.nextLine();
        spezialisierungController.addSpezialisierung(spezialisierungID, name);
    }

    public void updateSpeciality(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID Spezialisierung ");
        int spezialisierungID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name Spezialisierung: ");
        String name = scanner.nextLine();
        spezialisierungController.updateSpezialiserung(spezialisierungID, name);
    }

    public void deleteSpeciality(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID Spezialisierung ");
        int spezialisierungID = scanner.nextInt();
        scanner.nextLine();
        spezialisierungController.deleteSpezialisierung(spezialisierungID);
        System.out.println("Gut geloscht.");
    }

    public void showSpeciality(){
        for(Spezialisierung spezialisierung : spezialisierungController.readAll()){
            System.out.println(spezialisierung.toString());
        }
    }

    public void addIllness() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID Krankheit ");
        int krankheitID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name Krankheit: ");
        String name = scanner.nextLine();
        krankheitController.addKrankheit(krankheitID, name);
    }
    public void showIllness(){
        for(Krankheit krankheit : krankheitController.readAll()){
            System.out.println(krankheit.toString());
        }
    }
    public void updateIllness(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID Krankheit you want to change");
        int krankheitID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Name Krankheit: ");
        String name = scanner.nextLine();
        krankheitController.updateKrankheit(krankheitID, name);
    }
    public void deleteIllness(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID Krankheit you want to delete ");
        int krankheitID = scanner.nextInt();
        scanner.nextLine();
        krankheitController.deleteKrankheit(krankheitID);
        System.out.println("Gut geloscht.");
    }
}