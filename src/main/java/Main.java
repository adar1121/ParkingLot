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
                {"11353", "TRUCK", "2020-01-01T02:00:00.000Z", "EXIT" },
                {"86453", "CAR", "2020-01-01T04:24:00.000Z", "ENTRANCE"}
                };


        numberOfVehicles(logs);

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


    static void numberOfVehicles(String[][] vehicles){
        String vehicleId = "";
        String enterTime ="";
        int count = 0;

        for(int i=0; i<vehicles.length-1; i++)
        {
            vehicleId = vehicles[i][0];
            if(vehicles[i+1][0] == vehicleId)
            {
                if(vehicles[i][3] == "ENTRANCE")
                {
                    if(vehicles[i+1][3] == "EXIT")
                    {
                        //we are good to add this item
                        //check vehicle condtoion ( 1 2 3 )

                        //extract to function which check the vehicle type and its hour
                        if(vehicles[i][1] == "TRUCK")
                        {
                            //calc the exit-enter
                            //check if res >= 3 --> if yes : count++
                            // else nothing
                        }
                        else if(vehicles[i][1] == "CAR")
                        {
                            //calc the exit-enter
                            //check if res >= 2 --> if yes : count++ else nothing
                        }
                        else if(vehicles[i][1] == "MOTORCYCLE")
                        {
                            //calc the exit-enter
                            //check if res >= 1 --> if yes : count++ else nothing
                        }
                    }
                }

            }
        }
    }

//    static int timeCalculator(String instant){
//        Instant timeStamp = Instant.parse(instant);
//        ZoneId zone = ZoneId.of("UTC");
//        String actionType;
//        ZonedDateTime zonedDateTime = timeStamp.atZone(zone);
//        int hours = zonedDateTime.getHour();
//        int minutes = zonedDateTime.getMinute();
//        int time4Numbers = hours * 100 + minutes;
//        return time4Numbers;
//    }




}
