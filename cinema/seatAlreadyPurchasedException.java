package cinema;

public class seatAlreadyPurchasedException extends Exception{
    public seatAlreadyPurchasedException(){
        super("That ticket has already been purchased!");
    }
}
