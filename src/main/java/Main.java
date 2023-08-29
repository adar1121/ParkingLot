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
    public static void main(String[] args) {
        String[][] logs = {
                {"11353", "TRUCK", "2020-01-01T00:00:00.000Z", "ENTRANCE"},
                {"11353", "TRUCK", "2020-01-01T02:00:00.000Z", "EXIT" },
                {"86453", "CAR", "2020-01-01T04:24:00.000Z", "ENTRANCE"},
                {"86453", "CAR", "2020-01-01T04:24:00.000Z", "ENTRANCE"}
        };
        //question 1
        //System.out.println(numberOfVehicles(logs,1));

        //question 2
        System.out.println(numberOfVehicles(logs,2));

        //question 3
        //checkHowManyVehiclesForEachType(logs);
        //System.out.println(countTruck);
        //System.out.println(countCar);
        //System.out.println(countMotorcycle);
    }
    static int numberOfVehicles(String[][] vehicles, int questionNum){
        int count = 0;
        int countVehiclesWhichSpentTheNight = 0;
        String vehicleId = "";
        String enterTime ="";
        String exitTime = "";

        for(int vehicleCheckCounter =0; vehicleCheckCounter<vehicles.length; vehicleCheckCounter++)
        {
            vehicleId = vehicles[vehicleCheckCounter][0];
            for (int j = 0; j < vehicles.length; j++){
                if(vehicles[j][0] == vehicleId)
                {
                    if(vehicles[vehicleCheckCounter][3] == "ENTRANCE")
                    {
                        enterTime = vehicles[vehicleCheckCounter][2];
                        if(vehicles[j][3] == "EXIT")
                        {
                            exitTime = vehicles[j][2];
                            count = checkVehicleType(vehicles,vehicleCheckCounter,exitTime,enterTime, count);
                        }
                        else{
                            countVehiclesWhichSpentTheNight = checkHowManySpentTheNight(enterTime,countVehiclesWhichSpentTheNight);
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
            return countVehiclesWhichSpentTheNight;
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
    static int checkHowManySpentTheNight(String enterTime,int howManyVehicleSpentTheNight)
    {
        //check diff of enter time and now time
        //if the diff is equals or bigger then 1 ? so vehicle spent the night---conut++
        //nowTime - enterTime
        Duration duration = Duration.between(Instant.parse(enterTime), Instant.now());
        if(duration.toDays() >= 1){
            howManyVehicleSpentTheNight++;
        }
        return howManyVehicleSpentTheNight;
    }

    static void checkHowManyVehiclesForEachType(String[][] vehicles)
    {
        for (int i = 0; i < vehicles.length; i++) {
            for (int j = 0; j < vehicles.length; j++) {
                if(vehicles[i][j] == "CAR")
                {
                    //check enter and exit
                    countCar++;
                }
                else if (vehicles[i][j] == "TRUCK")
                {
                    //check enter and exit
                    countTruck++;
                }
                else if (vehicles[i][j] == "MOTORCYCLE")
                {
                    //check enter and exit
                    countMotorcycle++;
                }
            }
        }
    }
}