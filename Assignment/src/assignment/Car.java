/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author DUC THINH
 */
public class Car {
    String name;
    double price;
    int namSX;
    public Car() {
    }

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

        public Car(String name, int namSX, double price) {
        this.name = name;
        this.price = price;
        this.namSX = namSX;
    }

  
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }   

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }
    
    
    @Override
    public String toString() {
        if(namSX == 0){
            return "("+name +","+(int)price+")";
        }else{
              return  "("+name +","+ namSX+")";
              }
    } 
    
}
