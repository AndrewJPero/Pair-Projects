package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Pet {
    public String name;
    public String species;
    public List<String> vaccinations = new ArrayList<>();

    public Pet(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public List getVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(List vaccinations) {
        this.vaccinations = vaccinations;
    }

    public String listVaccinations(){
        for (int i = 0; i < vaccinations.size(); i++) {
            String result = vaccinations.get(i) + ", ";
            return result;
        }
        return null;
    }
}
