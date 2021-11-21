/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2_BSTree;

/**
 *
 * @author DUC THINH
 */
public class Castor {
    
    String place;
    int depth;
    int weight;

    public Castor() {
    }

    public Castor(String place, int depth, int weight) {
        this.place = place;
        this.depth = depth;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + place + "," + depth + "," + weight + ")";
    }
}
