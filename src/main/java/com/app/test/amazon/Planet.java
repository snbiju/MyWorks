package com.app.test.amazon;

import java.util.LinkedList;

/*

This code for review and provide comments
 */

public class Planet{
    int nM;
    public String name;


    public Planet(int nM,String name) throws  Exception{
        this.nM = nM;
        this.name=name;
    }

    public LinkedList findPlanetsWithLessMoons(LinkedList planets){
        boolean planetWasRemoved = false;
        for(java.util.Iterator it = planets.iterator(); it.hasNext();){
            Planet otherPlanet =(Planet) it.next();
            if(otherPlanet.getNumberOfMoons() >= nM){
                it.remove();
                planetWasRemoved = true;
            }
        }
        switch(String.valueOf(planetWasRemoved)){
            case "true":
                System.out.println("planets were removed");
                break;
            case "false":
                System.out.println("no planets were removed");
                break;
            default:
                System.out.println("shoudn't happen");
        }
        return planets;
    }
    public int getNumberOfMoons(){
        return nM;
    }
    public String getName(){
        return name;
    }

    public static void main(String[] args) throws Exception {
        Planet planet = new Planet(1,"Earth");
        Planet planet1 = new Planet(1,"Venus");
        Planet planet2 = new Planet(6,"Jupiter");
        Planet planet3 = new Planet(4,"Saturn");
        Planet planet4 = new Planet(3,"Mercury");
        Planet planet5 = new Planet(4,"Uranus");
        LinkedList list = new LinkedList();
        list.add(planet);
        list.add(planet1);
        list.add(planet2);
        list.add(planet3);
        list.add(planet4);
        list.add(planet5);

        System.out.println(planet.findPlanetsWithLessMoons(list));
    }
}