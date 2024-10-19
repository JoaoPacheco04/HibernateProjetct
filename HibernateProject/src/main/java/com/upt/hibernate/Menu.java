package com.upt.hibernate;
import java.util.Scanner;

public class Menu {
    HospitalManagementSystem manager = new HospitalManagementSystem();
    Scanner input = new Scanner(System.in);

    public void displayMenu() {
        int op;
        do {
            System.out.println("Choose an option:");
            System.out.println("1 - Manager");
            System.out.println("2 - Doctor");
            System.out.println("3 - Exit");
            op = input.nextInt();

            switch(op) {
                case 1:
                    managerMenu();
                    break;
                case 2:
                    doctorMenu();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while(op != 3);
    }

    private void managerMenu() {
        int opManager;
        do {
            System.out.println("***Manager Menu***");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Patient");
            System.out.println("3. Assign Doctor Shifts");
            System.out.println("4. View Doctor's Availability");
            System.out.println("5. View Doctor's Schedule");
            System.out.println("6. View Reports");
            System.out.println("7. Define Prices and Services");
            System.out.println("8. Replenish Stocks");
            System.out.println("9. View PatientRecords");
            System.out.println("10. Return to Main Menu");
            opManager = input.nextInt();

            switch(opManager) {
                case 1:
                    
                    break;
                case 2:
                  
                    break;
                case 3:
                    
                    break;
                case 4:
                   
                    break;
                case 5:
                    
                    break;
                case 6:
                  
                    break;
                case 7:
                   
                    break;
                case 8:
           
                    break;
                case 9:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while(opManager != 9);
    }

    private void doctorMenu() {
        int opDoctor;
        do {
            System.out.println("***Doctor Menu***");
            System.out.println("1. Generate Bill");
            System.out.println("2. View Bill");
            System.out.println("3. View Pharmacy's Stock");
            System.out.println("4. Make a Medical Prescription");
            System.out.println("5. View Available Beds or Surgical Rooms");
            System.out.println("6. Allocate a Bed or Surgical Room");
            System.out.println("7. View Scheduled Treatments");
            System.out.println("8. View Scheduled Appointments");
            System.out.println("9. View All Patients");
            System.out.println("10. Search Patient");
            System.out.println("11. Return to Main Menu");
            opDoctor = input.nextInt();
            
            switch(opDoctor) {
                case 1:
                  
                    break;
                case 2:
                  
                    break;
                case 3:
                 
                    break;
                case 4:
                  
                    break;
                case 5:
               
                    break;
                case 6:
                  
                    break;
                case 7:
                 
                    break;
                case 8:
                   
                    break;
                case 9:
                
                    break;
                case 10:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while(opDoctor != 10);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayMenu();
    }
}

