package cinema;

import jdk.jfr.Percentage;

import java.text.DecimalFormat;

public class Statistics {

    public static void printStatistics(int rows, int seatsPerRow, int soldTickets, double totalSeats, double currentIncome) {
        //DecimalFormat dc = new DecimalFormat("##.##%");
        double output = ((soldTickets * 100) / totalSeats);

        System.out.printf("Number of purchased tickets: %d\n", soldTickets);
        System.out.printf("Percentage: %.2f%%\n", output);
        System.out.printf("Current income: $%.0f\n", currentIncome);
        calcTotalIncome(rows, seatsPerRow, totalSeats);
    }

    private static void calcTotalIncome(int rows, int seatsPerRow, double totalSeats){

        if (totalSeats <= 60) {
            System.out.printf("Total income: $%.0f\n", 10.0 * totalSeats);

        } else if (rows % 2 > 0) {
            double frontHalf = Math.floor(rows / 2.0) * seatsPerRow * 10.0;
            double backHalf = Math.ceil(rows / 2.0) * seatsPerRow * 8.0;
            System.out.printf("Total income: $%.0f\n", frontHalf + backHalf);

        } else {
            int half = rows / 2;
            System.out.printf("Total income: $%.0f\n", (half * seatsPerRow * 10.0) + (half * seatsPerRow * 8.0));
        }
    }
}
