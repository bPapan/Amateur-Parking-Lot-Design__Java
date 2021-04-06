/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkinglotdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author bbasa
 */
public class ParkingLotDemo {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        String [] sizes = {"S", "M", "L", "XL"};
        HashMap <Integer, String> mapVehicleSize = new HashMap<>();
        HashMap <String, int[]> mapLotVehicleSize = new HashMap<>();
        HashMap <Integer, String> mapLotVehicle = new HashMap<>();
        
        for(int i=0; i<sizes.length; i++){
            mapVehicleSize.put(i+1, sizes[i]);
        }
        
        ArrayList<Integer> usedNumbers = new ArrayList<>();
        for (String size : sizes) {
            System.out.println("Type the amount of slots for vehicle size "+size);
            int typeSize = sc.nextInt();
            int [] lotNumbers = new int[typeSize];
            int j=0;
            System.out.println("Type the slot numbers one by one for vehicle size "+size);
            while(j<typeSize){
                int slot = sc.nextInt();
                if(usedNumbers.contains(slot)){
                    System.out.println("This slot no. is already used. Give another number.");
                }
                else{
                    usedNumbers.add(slot);
                    lotNumbers[j] = slot;
                    j+=1;
                }
            }
            mapLotVehicleSize.put(size, lotNumbers);
        }
        
        for (String size : sizes) {
            for(Integer lot: mapLotVehicleSize.get(size)){
                mapLotVehicle.put(lot,"");
            }
        }
        
        ParkingLot parkingLot = new ParkingLot(mapVehicleSize, mapLotVehicleSize, mapLotVehicle);
        
        while(true){
            System.out.println("Type 1 for entry of a vehicle to parking lot");
            System.out.println("Type 2 for exit of a vehicle to parking lot");
            System.out.println("Type 0 to exit");
            int opType = sc.nextInt();
            if(opType == 0){
                return;
            }
            else if(opType == 1){
                System.out.println("Type 1 for motorcycle");
                System.out.println("Type 2 for car");
                System.out.println("Type 3 for bus");
                System.out.println("Type 4 for truck");
                System.out.println();
                int vehicleType = sc.nextInt();
                System.out.println("Give the license no. of this vehicle");
                String LicensePlate = sc.next();
                System.out.println();
                //String color = sc.next();
                switch (vehicleType) {
                    case 1:
                        Motorcycle motorcycle = new Motorcycle(("M"+LicensePlate), "S");
                        System.out.println("Trying to find a slot for vehicle with license no. "+ motorcycle.getLicensePlate());
                        parkingLot.VehicleEntry(motorcycle);
                        break;
                    case 2:
                        Car car = new Car(("C"+LicensePlate), "M");
                        System.out.println("Trying to find a slot for vehicle with license no. "+ car.getLicensePlate());
                        parkingLot.VehicleEntry(car);
                        break;
                    case 3:
                        Bus bus = new Bus(("B"+LicensePlate), "L");
                        System.out.println("Trying to find a slot for vehicle with license no. "+ bus.getLicensePlate());
                        parkingLot.VehicleEntry(bus);
                        break;
                    case 4:
                        Truck truck = new Truck(("T"+LicensePlate), "XL");
                        System.out.println("Trying to find a slot for vehicle with license no. "+ truck.getLicensePlate());
                        parkingLot.VehicleEntry(truck);
                        break;
                    default:
                        break;
                }
            }
            else if(opType == 2){
                System.out.println("Type 1 for motorcycle");
                System.out.println("Type 2 for car");
                System.out.println("Type 3 for bus");
                System.out.println("Type 4 for truck");
                System.out.println();
                HashMap<Integer, String> mapTypeVehicle = new HashMap<>();
                mapTypeVehicle.put(1, "M");
                mapTypeVehicle.put(2, "C");
                mapTypeVehicle.put(3, "B");
                mapTypeVehicle.put(4, "T");
                int vehicleType = sc.nextInt();
                System.out.println("Give the license no. of this vehicle");
                String LicensePlate = sc.next();
                System.out.println();
                //String color = sc.next();
                parkingLot.VehicleExit(mapTypeVehicle.get(vehicleType)+LicensePlate);
            }
        }
    }
}
