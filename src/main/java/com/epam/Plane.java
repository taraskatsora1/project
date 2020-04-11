package com.epam;

public class Plane {
    private int idPlanes;
    private int liftingWeight;
    private int maxDistance;
    private int consumption;
    private int numberPlaces;

    public Plane() {
    }

    public Plane(int liftingWeight, int maxDistance, int consumption, int numberPlaces) {
        this.liftingWeight = liftingWeight;
        this.maxDistance = maxDistance;
        this.consumption = consumption;
        this.numberPlaces = numberPlaces;
    }

    public Plane(int idPlanes, int liftingWeight, int maxDistance, int consumption, int numberPlaces) {
        this.idPlanes = idPlanes;
        this.liftingWeight = liftingWeight;
        this.maxDistance = maxDistance;
        this.consumption = consumption;
        this.numberPlaces = numberPlaces;
    }

    public int getIdPlanes() {
        return idPlanes;
    }

    public void setIdPlanes(int idPlanes) {
        this.idPlanes = idPlanes;
    }

    public int getLiftingWeight() {
        return liftingWeight;
    }

    public void setLiftingWeight(int liftingWeight) {
        this.liftingWeight = liftingWeight;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public int getNumberPlaces() {
        return numberPlaces;
    }

    public void setNumberPlaces(int numberPlaces) {
        this.numberPlaces = numberPlaces;
    }
}
