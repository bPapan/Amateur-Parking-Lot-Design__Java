/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkinglotdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author bbasa
 */
public class ParkingLot {
    
    HashMap<Integer, String> mapVehicleSize;
    HashMap<String, int[]> mapLotVehicleSize;
    HashMap<Integer, String> mapLotVehicle;

    public ParkingLot(HashMap<Integer, String> mapVehicleSize, HashMap<String, int[]> mapLotVehicleSize, HashMap<Integer, String> mapLotVehicle) {
        this.mapVehicleSize = mapVehicleSize;
        this.mapLotVehicleSize = mapLotVehicleSize;
        this.mapLotVehicle = mapLotVehicle;
    }
    
    void VehicleEntry(Vehicle vehicle) {
        int flag=0;                                    //To check if any slot is free for size greater than or equal the size of the vehicle
        List<Integer> availableSlotTypes = new ArrayList<>();
        HashMap<String, Integer> reverseMapVehicleSize = new HashMap<>();
        mapVehicleSize.keySet().forEach((key) -> {
            reverseMapVehicleSize.put(mapVehicleSize.get(key), key);
        });
        
        for (Integer key: mapVehicleSize.keySet()){
            if(reverseMapVehicleSize.get(vehicle.getSize()) <= key) {
                availableSlotTypes.add(key);
            }
        }
        Integer [] availableSlotTypesArray = new Integer[availableSlotTypes.size()];
        availableSlotTypesArray = availableSlotTypes.toArray(availableSlotTypesArray);
        for (int i=0; i<availableSlotTypesArray.length; i++){
            //System.out.println(availableSlotTypesArray[i]);
            int [] lots = mapLotVehicleSize.get(mapVehicleSize.get(availableSlotTypesArray[i]));
            for(Integer lot: lots){
                if(mapLotVehicle.get(lot).equals("")){
                    flag=1;
                    mapLotVehicle.put(lot, vehicle.getLicensePlate());
                    System.out.println("Vehicle having license no. "+ vehicle.getLicensePlate() +" can be parked at slot " + lot);
                    break;
                }
            }
            if(flag==1){
                break;
            }
        }
        if(flag==0) {
            System.out.println("No slot available for a vehicle of this size");
        }
    }
    
    void VehicleExit(String licensePlate) {
        int flag=0;                                     //To check if any vehicle having the given license no. is present in the parking lot                                    
        
        for (Integer key: mapLotVehicle.keySet()){
            if(mapLotVehicle.get(key).equals(licensePlate)){
                flag=1;
                mapLotVehicle.put(key, "");
                System.out.println("Vehicle having license no. "+ licensePlate +" has left from slot " + key);
                break;
            }
        }
        if(flag==0) {
            System.out.println("No vehicle having the given license no. is present in the parking lot");
        }
    }
}
