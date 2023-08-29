import com.sun.jdi.Value;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static int insideQuestionNum = 0;

    public static void main(String[] args) {
        String[][] logs = {
                {"86453", "CAR", "2020-01-01T04:24:00.000Z", "ENTRANCE"},
                {"11353", "TRUCK", "2020-01-01T05:00:00.000Z", "EXIT"},
                {"11353", "TRUCK", "2020-01-01T00:00:00.000Z", "ENTRANCE"},
                {"86453", "CAR", "2020-01-01T08:25:00.000Z", "EXIT"}
        };
        //question 1
        insideQuestionNum = 1;
        ParkingLot parkingLot = new ParkingLot(insideQuestionNum);
        System.out.println("There are " + parkingLot.numberOfVehicles(logs, insideQuestionNum) + " Vehicles spent more than x hours");

        //question 2
        insideQuestionNum = 2;
        ParkingLot parkingLot2 = new ParkingLot(insideQuestionNum);
        System.out.println("There are " + parkingLot2.numberOfVehicles(logs, insideQuestionNum) + " Vehicles spent the night");

        //question 3
        insideQuestionNum = 3;
        ParkingLot parkingLot3 = new ParkingLot(insideQuestionNum);
        parkingLot3.numberOfVehicles(logs, insideQuestionNum);
        System.out.println("Number of Truck currently in parking lot: " + parkingLot3.getCountTruck());
        System.out.println("Number of Car currently in parking lot: " + parkingLot3.getCountCar());
        System.out.println("Number of Motorcycle currently in parking lot: " + parkingLot3.getCountMotorcycle());
    }
}