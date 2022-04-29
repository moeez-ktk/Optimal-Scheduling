
import java.text.ParseException;
import java.util.Scanner;

public class Schedule {
    public static void main(String[] args) throws ParseException {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter The Number Of Events: ");
        int numberOfEvents = input.nextInt();

        System.out.println();
        System.out.println("Enter the Time in the 24 Hour Format \"Hours:Minutes\" Other Formats Are Not Acceptable");

        Event events[] = new Event[10];
        for (int i = 0; i < numberOfEvents; i++) {
            events[i] = new Event();
            System.out.print("Enter Event " + (i + 1) + " Start Time: ");
            String startTime = input.next();
            System.out.print("\t      End Time: ");
            String endTime = input.next();
            events[i].setTime(startTime, endTime);
            System.out.println();
        }

        // Following Input To Check Whether Code Working Or Not
        // events[0] = new Event();
        // events[0].setTime("1:00", "2:00");

        // events[1] = new Event();
        // events[1].setTime("1:30", "4:00");

        // events[2] = new Event();
        // events[2].setTime("2:10", "2:30");

        // events[3] = new Event();
        // events[3].setTime("2:30", "3:40");

        // events[4] = new Event();
        // events[4].setTime("4:30", "5:00");

        // events[5] = new Event();
        // events[5].setTime("5:30", "6:30");

        // events[6] = new Event();
        // events[6].setTime("5:50", "6:00");

        // events[7] = new Event();
        // events[7].setTime("6:00", "6:30");

        // events[8] = new Event();
        // events[8].setTime("7:30", "8:00");

        // events[9] = new Event();
        // events[9].setTime("7:00", "8:00");

        Event.sortSchedule(events, 10);
        Event.displaySortedSchedule(events, 10);
        System.out.println();
        System.out.println();
        Event.finalSchedule(events, 10);
        Event.displayFinalSchedule();

        input.close();
    }

}