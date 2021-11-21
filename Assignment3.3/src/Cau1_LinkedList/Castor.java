/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau1_LinkedList;

/**
 *
 * @author DUC THINH
 */
public class Castor {
    String place;
    int depth;
    int type;

    public Castor() {
    }

    public Castor(String place, int depth, int type) {
        this.place = place;
        this.depth = depth;
        this.type = type;
    }

    @Override
    public String toString() {
        return "("+place+","+depth+","+type+")";
    }
    
    
}
