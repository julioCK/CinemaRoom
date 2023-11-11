package cinema;

public class CinemaRoom {
    private String[][] room;

    public CinemaRoom(int rows, int columns) {

        this.room = new String[rows + 1][columns + 1];

        //------------------create de first row, with the numbers of each column
        String[] columnNumbers = new String[columns + 1];
        columnNumbers[0] = " ";
        for (int i = 1; i < columns + 1; i++) {
            columnNumbers[i] = String.valueOf(i);
        }
        //---------------------------------------------------------------------

        this.room[0] = columnNumbers;

        //-----------------creating each row
        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j <= columns; j++) {
                if(j == 0)
                    this.room[i][j] = String.valueOf(i);
                else
                    this.room[i][j] = "S";
            }
        }
    }
    public String[][] getRoom(){
        return room;
    }
    public void changeSeatStatus(int seatRow, int seatNum) throws seatAlreadyPurchasedException, IndexOutOfBoundsException{

        if(this.room[seatRow][seatNum].equals("S"))
            this.room[seatRow][seatNum] = "B";
            else
            throw new seatAlreadyPurchasedException();
    }
    public void printRoom() {

        System.out.println("Cinema:");
        for (int i = 0; i < this.room.length; i++) {
            if (i != 0)
                System.out.println();
            for (int j = 0; j < this.room[i].length; j++) {
                System.out.print(this.room[i][j] + " ");
            }
        }
        //----------------------------------
        System.out.println("\n");

    }
}
