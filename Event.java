
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class Event {
    private java.util.Date endTime;
    private java.util.Date startTime;
    private static int length = 10;
    static DateFormat time = new SimpleDateFormat("hh:mm");
    private static Event finalEvents[] = new Event[10];

    // *********Creating Final Schedule*************

    public static void finalSchedule(Event events[], int lenght) {
        java.util.Date earliestEndTime = events[0].endTime;
        Event addEvent = new Event();
        Event check = new Event();
        int count = -1;
        for (int i = 0; i < Event.length; i++) {
            try {
                earliestEndTime = events[count + 1].endTime;
            } catch (Exception e) {
                System.out.print("");
            }

            for (int j = count + 1; j < Event.length; j++) {

                if (earliestEndTime.after(events[j].endTime) || earliestEndTime.equals(events[j].endTime)) {
                    earliestEndTime = events[j].endTime;
                    addEvent = events[j];
                    count = j;
                }

            }

            // FOLLOWING IF ELSE: if addEvent is not updated i.e maximum number of
            // events have been added and no further event can
            // be added then the loop will break to avoid repition of last event
            if (check != addEvent) {
                check = addEvent;
            } else
                break;

            // System.out.println(time.format(earliestEndTime)); // just for checking
            // whether it is working correctly or
            // not
            finalEvents[i] = new Event();
            finalEvents[i] = addEvent;

        }

    }

    // ******Displaying Events*********

    public static void displaySortedSchedule(Event events[], int lenght) {
        for (int i = 0; i < lenght; i++) {
            System.out.println("Event " + i + " start time: " + time.format(events[i].startTime) + "   end time: "
                    + time.format(events[i].endTime));
        }
    }

    public static void displayFinalSchedule() {
        for (int i = 0; i < Event.length; i++) {
            try {
                System.out.println(
                        "Event " + i + " start time: " + time.format(finalEvents[i].startTime) + "   end time: "
                                + time.format(finalEvents[i].endTime));
            } catch (Exception e) {
                System.out.print("");
            }
        }
    }

    // *********Sorting The Events****************

    private static void swapEvents(Event event1, Event event2) {
        Event temp = event1;
        event1 = event2;
        event2 = temp;
    }

    public static void sortSchedule(Event events[], int length) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (events[i].startTime.before(events[j].startTime))
                    swapEvents(events[i], events[j]);
            }
        }
    }

    // ********Setting Starting and Ending Time of Events***********

    public void setTime(String startTime, String endTime) throws ParseException {
        this.startTime = time.parse(startTime);
        this.endTime = time.parse(endTime);
    }

}