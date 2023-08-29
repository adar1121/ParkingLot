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
    static int countTruck=0,countCar=0, countMotorcycle = 0;
    static int howManyVehicleSpentTheNight =0;
    static int insideQuestionNum = 0;
    public static void main(String[] args) {
        String[][] logs = {
                {"11353", "TRUCK", "2020-01-01T00:00:00.000Z", "ENTRANCE"},
                {"11353", "TRUCK", "2020-01-03T04:00:00.000Z", "EXIT"},
                {"86453", "CAR", "2020-01-01T04:24:00.000Z", "ENTRANCE"},
                {"86453", "CAR", "2020-01-03T08:25:00.000Z", "EXIT"}
        };
        //question 1
        insideQuestionNum = 1;
        System.out.println("There are " + numberOfVehicles(logs,insideQuestionNum) + " Vehicles spent more than x hours");


        //question 2
        insideQuestionNum = 2;
        System.out.println("There are " + numberOfVehicles(logs,insideQuestionNum) + " Vehicles spent the night");

        //question 3
        insideQuestionNum = 3;
        numberOfVehicles(logs, insideQuestionNum);
        System.out.println("Number of Truck currently in parking lot: " + countTruck);
        System.out.println("Number of Car currently in parking lot: " + countCar);
        System.out.println("Number of Motorcycle currently in parking lot: " + countMotorcycle);
    }
    static int numberOfVehicles(String[][] vehicles, int questionNum){
        int count = 0;
        int countVehiclesWhichSpentTheNight = 0;
        int countTillNotFindSameVehicleID = 0;
        String vehicleId = "";
        String enterTime ="";
        String exitTime = "";

        for(int vehicleCheckCounter =0; vehicleCheckCounter<vehicles.length; vehicleCheckCounter++)
        {
            countTillNotFindSameVehicleID = 0;
            vehicleId = vehicles[vehicleCheckCounter][0];
            if(vehicles[vehicleCheckCounter][3] == "ENTRANCE"){
                    enterTime = vehicles[vehicleCheckCounter][2];
                for (int j = 0; j < vehicles.length; j++){
                    if(vehicles[j][0] == vehicleId && vehicles[j][3] == "EXIT")
                    {
                        countTillNotFindSameVehicleID = 0;
                        if(vehicles[vehicleCheckCounter][3] == "ENTRANCE")
                        {
                            enterTime = vehicles[vehicleCheckCounter][2];
                            if(vehicles[j][3] == "EXIT")
                            {
                                exitTime = vehicles[j][2];
                                if (insideQuestionNum == 1) {
                                    count = checkVehicleType(vehicles, vehicleCheckCounter, exitTime, enterTime, count); // Question 1
                                }

                                if (insideQuestionNum == 2){
                                    checkHowManySpentTheNight(enterTime,exitTime);
                                }
                            }
                            else{
//                                countVehiclesWhichSpentTheNight = checkHowManySpentTheNight(enterTime,);
                            }
                        }
                    }
                    else
                    {
                        countTillNotFindSameVehicleID++;
                        if (insideQuestionNum == 2 && countTillNotFindSameVehicleID==vehicles.length ){
                           exitTime = Instant.now().toString();
                           checkHowManySpentTheNight(enterTime,exitTime);
                           countTillNotFindSameVehicleID = 0;
//                           checkHowManyVehiclesForEachType(vehicles,vehicleCheckCounter);
                        }
                        else if(insideQuestionNum == 1 && countTillNotFindSameVehicleID == vehicles.length){
                            exitTime = Instant.now().toString();
                            count = checkVehicleType(vehicles, vehicleCheckCounter, exitTime, enterTime, count);
                            countTillNotFindSameVehicleID = 0;
//                            checkHowManyVehiclesForEachType(vehicles,vehicleCheckCounter);
                        }
                        else if (insideQuestionNum == 3 && countTillNotFindSameVehicleID == vehicles.length) {
                            checkHowManyVehiclesForEachType(vehicles,vehicleCheckCounter);
                        }
                    }
                }
            }

        }
        if(questionNum == 1)
        {
            return count;
        }
        else
        {
            return howManyVehicleSpentTheNight;
        }

    }

    static int checkVehicleType(String[][] vehicles, int vehicleCheckCounter, String exitTime, String enterTime, int count)
    {
        if(vehicles[vehicleCheckCounter][1] == "TRUCK")
        {
            count = countNumOfVehicles(enterTime, exitTime, 180,count);
        }
        else if(vehicles[vehicleCheckCounter][1] == "CAR")
        {
            count = countNumOfVehicles(enterTime,exitTime,120,count);
        }
        else if(vehicles[vehicleCheckCounter][1] == "MOTORCYCLE")
        {
            count = countNumOfVehicles(enterTime,exitTime,60,count);
        }
        return count;
    }

    static int countNumOfVehicles(String enterTime, String exitTime, int minutes, int count)
    {
        Duration duration = Duration.between(Instant.parse(enterTime), Instant.parse(exitTime));
        if(duration.toMinutes() > minutes)
        {
            count++;
        }
        return count;
    }
    static int checkHowManySpentTheNight(String enterTime,String exitTime)
    {
        //check diff of enter time and now time
        //if the diff is equals or bigger then 1 ? so vehicle spent the night---conut++
        //nowTime - enterTime
        Duration duration = Duration.between(Instant.parse(enterTime), (Instant.parse(exitTime)));
        if(duration.toDays() >= 1){
            howManyVehicleSpentTheNight++;
        }
        return howManyVehicleSpentTheNight;
    }

    static void checkHowManyVehiclesForEachType(String[][] vehicles,int vehicleCheckCounter)
    {
                if(vehicles[vehicleCheckCounter][1] == "CAR")
                {

                    countCar++;
                }
                else if (vehicles[vehicleCheckCounter][1] == "TRUCK")
                {
                    //check enter and exit
                    countTruck++;
                }
                else if (vehicles[vehicleCheckCounter][1] == "MOTORCYCLE")
                {
                    //check enter and exit
                    countMotorcycle++;
                }
            }
}
