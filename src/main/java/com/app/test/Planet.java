package com.app.test;

import java.util.LinkedList;
/*
Code reviewed and re factorized

import java.util.LinkedList;
import java.util.Iterator;

public class Planet {
    private int numberOfMoons;
    private String name;

    /**
     * Constructs a Planet instance with the given number of moons and name.
     * @param numberOfMoons The number of moons the planet has.
     * @param name The name of the planet.
     */
/*
public Planet(int numberOfMoons, String name) {
        this.numberOfMoons = numberOfMoons;
        this.name = name;
        }
*/
/**
 * Finds and removes planets from the list that have the same or more moons than this planet.
 * @param planets The list of planets to be filtered.
 * @return The filtered list of planets.
 */
/*
public LinkedList<Planet> findPlanetsWithLessMoons(LinkedList<Planet> planets) {
        boolean planetWasRemoved = false;
        Iterator<Planet> it = planets.iterator();
        while (it.hasNext()) {
        Planet otherPlanet = it.next();
        if (otherPlanet.getNumberOfMoons() >= numberOfMoons) {
        it.remove();
        planetWasRemoved = true;
        }
        }
        if (planetWasRemoved) {
        System.out.println("Planets were removed");
        } else {
        System.out.println("No planets were removed");
        }
        return planets;
        }
*/
/**
 * Gets the number of moons of this planet.
 * @return The number of moons.
 */
/*
public int getNumberOfMoons() {
        return numberOfMoons;
        }


 */
/**
 * Gets the name of this planet.
 * @return The name of the planet.
 */
/*
public String getName() {
        return name;
        }

@Override
public String toString() {
        return "Planet{" +
        "numberOfMoons=" + numberOfMoons +
        ", name='" + name + '\'' +
        '}';
        }
        }



 */
public class Planet {
    private int nM;
    private String name;

    public Planet(int nM, String name) {
        this.nM = nM;
        this.name = name;
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
                System.out.println(new String("planets were removed"));
                break;
            case "false":
                System.out.println(new String("no planets were removed"));
                break;
            default:
                System.out.println(new String("shoudn't happen"));
        }
        return planets;
    }
    public int getNumberOfMoons(){
        return nM;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "nM=" + nM +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        // Example usage
        LinkedList planetList = new LinkedList<>();
        planetList.add(new Planet(2, "Mars"));
        planetList.add(new Planet(1, "Earth"));
        planetList.add(new Planet(4, "Jupiter"));

        Planet referencePlanet = new Planet(3, "Reference");

        System.out.println("Original planet list: " + planetList);
        referencePlanet.findPlanetsWithLessMoons(planetList);
        System.out.println("Updated planet list: " + planetList);
    }
}
