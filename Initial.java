import java.util.Scanner;

public class Initial
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String userInput;
        int size;
        int activeUnit;
        System.out.println("Enter array size: ");
        size = in.nextInt();
        userInput = in.nextLine();
        SingleUnit[] Units = new SingleUnit[size]; // Name, price, age, value
        int counter = 0;
        for(counter = 0;counter<size;counter++)
        {
            Units[counter] = new SingleUnit();
        }
        Units[0].UserOptions(Units);
    }
}