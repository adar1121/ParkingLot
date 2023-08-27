import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vehicleID;
        int vehicleType;
        int openingTime = 0600;
        int closingTime = 2330;

        Instant timeStamp = Instant.now();
        ZoneId zone = ZoneId.of("UTC");
        String actionType;
        ZonedDateTime zonedDateTime = timeStamp.atZone(zone);
        int hours = zonedDateTime.getHour();
        int minutes = zonedDateTime.getMinute();
        int time4Numbers = hours * 100 + minutes;
        String[] logs = {"11353 " + "TRUCK " + "2020-01-01T00:00:00.000Z " + "ENTRANCE", "11353 " + "TRUCK " + "2020-01-01T02:00:00.000Z " + "EXIT",
        "86453 " + "CAR " + "2020-01-01T04:24:00.000Z " + "ENTRANCE"};

//        for (int i = 0; i < logs.length; i++){
//            System.out.println(logs[i]);
//        }

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


    static int numberOfVehicles(String[] ss){
        System.out.println(Arrays.toString(ss));
        System.out.println("Yes");
        return 0;
    }

}
