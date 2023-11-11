package cinema;
import java.util.Scanner;
import java.lang.Math;

public class Cinema {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = scan.nextInt();

        CinemaRoom cine = new CinemaRoom(rows, seatsPerRow);

        int option = -1;
        double ticketPrice = 0.0;
        double totalSeats = (double) rows * seatsPerRow;
        double currentIncome = 0.0;
        int soldTickets = 0;

        while(true) {

            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            option = scan.nextInt();

            switch (option) {
                case 1:
                    cine.printRoom();
                    break;

                case 2:
                    boolean flag;
                    int seatRow;
                    int seatNum;

                    do {
                        flag = false;
                        System.out.println("Enter a row number:");
                        seatRow = scan.nextInt();
                        System.out.println("Enter a seat number in that row:");
                        seatNum = scan.nextInt();

                        try {
                            cine.changeSeatStatus(seatRow, seatNum);

                        } catch (seatAlreadyPurchasedException s) {
                            System.out.println(s.getMessage());
                            System.out.println("\nPlease, enter another seat coordinates.\n");
                            flag = true;

                        } catch (IndexOutOfBoundsException ofb) {
                            System.out.println("Wrong input!");
                            flag = true;
                        }
                    } while (flag);
                    soldTickets++;


                    if (totalSeats <= 60) {
                        ticketPrice = 10.0;
                        System.out.printf("Ticket price: $%.0f\n\n", ticketPrice);

                    } else if (rows % 2 > 0) {
                        double frontHalf = Math.floor(rows / 2.0);
                        ticketPrice = seatRow <= frontHalf ? 10.0 : 8.0;
                        System.out.printf("Ticket price: $%.0f\n\n", ticketPrice);

                    } else {
                        int half = rows / 2;
                        ticketPrice = seatRow <= half ? 10.0 : 8.0;
                        System.out.printf("Ticket price: $%.0f\n\n", ticketPrice);
                    }
                    currentIncome += ticketPrice;
                    break;
                case 3:
                    Statistics.printStatistics(rows, seatsPerRow, soldTickets, totalSeats, currentIncome);
                    break;
                case 0:
                    return;

                default:
                    System.out.println("Please chose one of the options on the menu.");
                    break;
            }
        }
        //System.out.println("Sorry, all seats have been sold!");
        //return;
    }
}