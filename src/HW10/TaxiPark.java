package HW10;

import java.util.Arrays;

public class TaxiPark {
    private Car[] taxiPark;

    TaxiPark(Car[] taxiPark) {
        this.taxiPark = taxiPark;
    }

    public int getcoastOfTaxiPark() {
        int coast = 0;

        for (int i = 0; i < this.taxiPark.length; i++) {
            coast += this.taxiPark[i].getPrice();
        }
        return coast;
    }

    public Car[] getsearchCarsForSpeed(int minSpeed, int maxSpeed) {
        Car[] searchCar = null;

        for (Car car : taxiPark) {
            if (car.getMaxSpeed() <= maxSpeed && car.getMaxSpeed() >= minSpeed) {
                if (searchCar == null) {
                    searchCar = new Car[1];
                    searchCar[0] = car;
                } else {
                    Car[] tempCar = new Car[searchCar.length + 1];
                    for (int i = 0; i < searchCar.length; i++) {
                        tempCar[i] = searchCar[i];
                    }
                    tempCar[searchCar.length] = car;
                    searchCar = tempCar;
                }
            }
        }
        return searchCar;
    }

    public Car[] getfuelConsumption() {

        for (int i = taxiPark.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (taxiPark[j].getFuelConsumption() > taxiPark[j + 1].getFuelConsumption()) {
                    Car temp = taxiPark[j];
                    taxiPark[j] = taxiPark[j + 1];
                    taxiPark[j + 1] = temp;
                }
            }
        }
        return taxiPark;
    }

    @Override
    public String toString() {
        return "TaxiPark{" +
                "taxiPark = " + Arrays.toString(taxiPark) +
                '}';
    }
}