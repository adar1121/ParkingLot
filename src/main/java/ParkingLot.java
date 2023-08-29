import java.time.Duration;
import java.time.Instant;

public class ParkingLot {
    private int howManyVehicleSpentTheNight;
    private int insideQuestionNum;
    private int countTruck;

    //Getter
    public int getCountTruck() {
        return countTruck;
    }

    //Setter
    public void setCountTruck(int countTruck) {
        this.countTruck = countTruck;
    }

    private int countCar;

    //Getter
    public int getCountCar() {
        return countCar;
    }

    //Setter
    public void setCountCar(int countCar) {
        this.countCar = countCar;
    }

    private int countMotorcycle;

    //Getter
    public int getCountMotorcycle() {
        return countMotorcycle;
    }

    //Setter
    public void setCountMotorcycle(int countMotorcycle) {
        this.countMotorcycle = countMotorcycle;
    }

    public ParkingLot(int insideQuestionNum) {
        this.insideQuestionNum = insideQuestionNum;
        this.howManyVehicleSpentTheNight = 0;
    }

    public int numberOfVehicles(String[][] vehicles, int questionNum) {
        int count = 0;
        int countTillNotFindSameVehicleID = 0;
        String vehicleId = "";
        String enterTime = "";
        String exitTime = "";

        for (int vehicleCheckCounter = 0; vehicleCheckCounter < vehicles.length; vehicleCheckCounter++) {
            countTillNotFindSameVehicleID = 0;
            vehicleId = vehicles[vehicleCheckCounter][0];
            if (vehicles[vehicleCheckCounter][3] == "ENTRANCE") {
                enterTime = vehicles[vehicleCheckCounter][2];
                for (int j = 0; j < vehicles.length; j++) {
                    if (vehicles[j][0] == vehicleId && vehicles[j][3] == "EXIT") {
                        countTillNotFindSameVehicleID = 0;
                        if (vehicles[vehicleCheckCounter][3] == "ENTRANCE") {
                            enterTime = vehicles[vehicleCheckCounter][2];
                            if (vehicles[j][3] == "EXIT") {
                                exitTime = vehicles[j][2];
                                if (insideQuestionNum == 1) {
                                    count = checkVehicleType(vehicles, vehicleCheckCounter, exitTime, enterTime, count); // Question 1
                                }

                                if (insideQuestionNum == 2) {
                                    checkHowManySpentTheNight(enterTime, exitTime);
                                }
                            }
                        }
                    } else {
                        countTillNotFindSameVehicleID++;
                        if (insideQuestionNum == 2 && countTillNotFindSameVehicleID == vehicles.length) {
                            exitTime = Instant.now().toString();
                            checkHowManySpentTheNight(enterTime, exitTime);
                            countTillNotFindSameVehicleID = 0;
                        } else if (insideQuestionNum == 1 && countTillNotFindSameVehicleID == vehicles.length) {
                            exitTime = Instant.now().toString();
                            count = checkVehicleType(vehicles, vehicleCheckCounter, exitTime, enterTime, count);
                            countTillNotFindSameVehicleID = 0;
                        } else if (insideQuestionNum == 3 && countTillNotFindSameVehicleID == vehicles.length) {
                            checkHowManyVehiclesForEachType(vehicles, vehicleCheckCounter);
                        }
                    }
                }
            }

        }
        if (questionNum == 1) {
            return count;
        } else {
            return howManyVehicleSpentTheNight;
        }
    }

    public int checkVehicleType(String[][] vehicles, int vehicleCheckCounter, String exitTime, String enterTime, int count) {
        if (vehicles[vehicleCheckCounter][1] == "TRUCK") {
            count = countNumOfVehicles(enterTime, exitTime, 180, count);
        } else if (vehicles[vehicleCheckCounter][1] == "CAR") {
            count = countNumOfVehicles(enterTime, exitTime, 120, count);
        } else if (vehicles[vehicleCheckCounter][1] == "MOTORCYCLE") {
            count = countNumOfVehicles(enterTime, exitTime, 60, count);
        }
        return count;
    }

    public int countNumOfVehicles(String enterTime, String exitTime, int minutes, int count) {
        Duration duration = Duration.between(Instant.parse(enterTime), Instant.parse(exitTime));
        if (duration.toMinutes() > minutes) {
            count++;
        }
        return count;
    }

    public int checkHowManySpentTheNight(String enterTime, String exitTime) {
        //check diff of enter time and now time
        //if the diff is equals or bigger then 1 ? so vehicle spent the night---conut++
        //nowTime - enterTime
        Duration duration = Duration.between(Instant.parse(enterTime), (Instant.parse(exitTime)));
        if (duration.toDays() >= 1) {
            howManyVehicleSpentTheNight++;
        }
        return howManyVehicleSpentTheNight;
    }

    public void checkHowManyVehiclesForEachType(String[][] vehicles, int vehicleCheckCounter) {
        if (vehicles[vehicleCheckCounter][1] == "CAR") {
            countCar++;
        } else if (vehicles[vehicleCheckCounter][1] == "TRUCK") {
            countTruck++;
        } else if (vehicles[vehicleCheckCounter][1] == "MOTORCYCLE") {
            countMotorcycle++;
        }
    }
}
