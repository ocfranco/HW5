
package model;


public class Cars {

 private int CarID;
 private String CarMake;
 private String CarModel;
 private int ModelYear;
 private int Torque;
 private int Horsepower;
 
 public Cars() {
     this.CarID = 0;
     this.CarMake ="";
     this.CarModel ="";
     this.ModelYear=0;
     this.Torque=0;
     this.Horsepower=0;
 }

    public Cars(int CarID, String CarMake, String CarModel, int ModelYear, int Torque, int Horsepower) {
        this.CarID = CarID;
        this.CarMake = CarMake;
        this.CarModel = CarModel;
        this.ModelYear = ModelYear;
        this.Torque = Torque;
        this.Horsepower = Horsepower;
    }

    public int getCarID() {
        return CarID;
    }

    public void setCarID(int CarID) {
        this.CarID = CarID;
    }

    public String getCarMake() {
        return CarMake;
    }

    public void setCarMake(String CarMake) {
        this.CarMake = CarMake;
    }

    public String getCarModel() {
        return CarModel;
    }

    public void setCarModel(String CarModel) {
        this.CarModel = CarModel;
    }

    public int getModelYear() {
        return ModelYear;
    }

    public void setModelYear(int ModelYear) {
        this.ModelYear = ModelYear;
    }

    public int getTorque() {
        return Torque;
    }

    public void setTorque(int Torque) {
        this.Torque = Torque;
    }

    public int getHorsepower() {
        return Horsepower;
    }

    public void setHorsepower(int Horsepower) {
        this.Horsepower = Horsepower;
    }

    @Override
    public String toString() {
        return "Cars{" + "CarID=" + CarID + ", CarMake=" + CarMake + ", CarModel=" + CarModel + ", ModelYear=" + ModelYear + ", Torque=" + Torque + ", Horsepower=" + Horsepower + '}';
    }

 
}
