class ParkingSystem {
    int[] space;
    public ParkingSystem(int big, int medium, int small) {
        space=new int[]{big,medium,small};
    }
    
    public boolean addCar(int carType) {
        if(carType ==1 && space[0]<1) return false;
        if(carType ==2 && space[1]<1) return false;
        if(carType ==3 && space[2]<1) return false;
        space[carType-1]--;
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
