///////////////////////////////////////////
//1603. Design Parking System
///////////////////////////////////////////

class ParkingSystem {

    int bigslots;
    int mediumslots;
    int smallslots;
    
       
    public ParkingSystem(int big, int medium, int small) {
        this.bigslots = big;
        this.mediumslots = medium;
        this.smallslots = small;
    }
    
    public boolean addCar(int carType) {
        if(carType == 1) {
            if(this.bigslots>0) {
                this.bigslots--;
                return true;
            } else {
                return false;
            }
        } else if(carType == 2) {
            if(this.mediumslots>0) {
                this.mediumslots--;
                return true;
            } else {
                return false;
            }
        } else if(carType == 3) {
            if(this.smallslots>0) {
                this.smallslots--;
                return true;
            } else {
                return false;
            }
        }
        
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */