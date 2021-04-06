/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parkinglotdemo;

/**
 *
 * @author bbasa
 */
abstract class Vehicle {
    String licensePlate;
    String size;
    enum Color{
        RED, GREEN, BLUE, WHITE, BLACK, SILVER, YELLOW;
    }

    public Vehicle(String licensePlate, String size) {
        this.licensePlate = licensePlate;
        this.size = size;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getSize() {
        return size;
    }

    
    
}
