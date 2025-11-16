class ParkingSystem {
    HashMap<Integer, Integer> parking;
    public ParkingSystem(int big, int medium, int small) {
        parking = new HashMap<>();
        parking.put(1,big);
        parking.put(2,medium);
        parking.put(3,small);
    }
    
    public boolean addCar(int carType) {
        if(parking.get(carType) > 0){
            parking.put(carType, parking.get(carType)-1);
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */