import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
   static int searchCount = 0;
   static int numberOfVehicles = 0;
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int vehicleID;
//        int vehicleType;
//        int openingTime = 0600;
//        int closingTime = 2330;




        String[][] logs = {
                {"11353", "TRUCK", "2020-01-01T00:00:00.000Z", "ENTRANCE"},
                {"11353", "TRUCK", "2020-01-01T04:00:00.000Z", "EXIT" },
                {"86453", "CAR", "2020-01-01T04:24:00.000Z", "ENTRANCE"},
                {"86453", "CAR", "2020-01-01T06:25:00.000Z", "EXIT"}
                };

//        System.out.println(timeCalculator(logs[0][2]));

        System.out.println(numberOfVehicles(logs));

//        if (time4Numbers >= openingTime & time4Numbers < closingTime) {
//            System.out.print("What Action you want to do EXIT / ENTRANCE? ");
//
//            switch (actionType = scanner.next().toUpperCase()) {
//                case "ENTRANCE":
//                    System.out.println("Entrance");
//                    break;
//                case "EXIT":
//                    System.out.println("Exit");
//                    break;
//                default:
//                    System.out.println("Wrong Action. There is only Exit or Entrance are Available");
//            }
//        }
//        else {
//            System.out.println("Parking lot is close");
//        }

    }

//    static int getTime4Letters()


    static int numberOfVehicles(String[][] vehicles){
        String vehicleId = "";
        String enterTime ="";
        String exitTime = "";
        int count = 0;

        for(int i=0; i<vehicles.length-1; i++)
        {
            vehicleId = vehicles[i][0];
            if(vehicles[i+1][0] == vehicleId)
            {
                if(vehicles[i][3] == "ENTRANCE")
                {
                    enterTime = vehicles[i][2];
                    if(vehicles[i+1][3] == "EXIT")
                    {
                        exitTime = vehicles[i+1][2];
                        if(vehicles[i][1] == "TRUCK")
                        {
                            if ((timeCalculator(exitTime) - timeCalculator(enterTime)) > 300){
                                count++;
                            }
                        }
                        else if(vehicles[i][1] == "CAR")
                        {
                            if ((timeCalculator(exitTime) - timeCalculator(enterTime)) > 200){
                                count++;
                            }
                        }
                        else if(vehicles[i][1] == "MOTORCYCLE")
                        {
                            if ((timeCalculator(exitTime) - timeCalculator(enterTime)) > 100){
                                count++;
                            }
                        }
                    }
                }

            }
        }

        return count;
    }

    static int timeCalculator(String instant){
        Instant timeStamp = Instant.parse(instant);
        ZoneId zone = ZoneId.of("UTC");
        String actionType;
        ZonedDateTime zonedDateTime = timeStamp.atZone(zone);
        int hours = zonedDateTime.getHour();
        int minutes = zonedDateTime.getMinute();
        int time4Numbers = hours * 100 + minutes;
        return time4Numbers;
    }




}
