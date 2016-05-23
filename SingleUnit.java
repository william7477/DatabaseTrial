import java.util.Scanner;

public class SingleUnit{
    public String UnitName;
    public int Price;
    public int Age;
    public int Value;
    
    public SingleUnit()
    {
        Scanner in = new Scanner(System.in);
        String extra;
        System.out.println("Initiating Unit");
        System.out.println("Enter name of Unit:");
        UnitName = in.nextLine();
        System.out.println("Enter price of Unit:");
        Price = in.nextInt();
        extra = in.nextLine();
        System.out.println("Enter age of Unit:");
        Age = in.nextInt();
        extra = in.nextLine();
        System.out.println("Enter value of Unit from 1 to 10:");
        Value = in.nextInt();
        extra = in.nextLine();
        System.out.println("Unit Created.");
    }
    
    public void UpdateName(String Name)
    {
        UnitName = Name;
    }
    
    public void UpdatePrice(int price)
    {
        Price = price;
    }
  
    public void UpdateAge(int age)
    {
        Age = age;
    }
    
    public void UpdateValue(int value)
    {
        Value = value;
    }
    
    public int CompareAge(SingleUnit A, SingleUnit B)
    {
        if(A.Age>B.Age)
        {
            return 1;
        }
        else if(A.Age == B.Age)
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }
    
    public int ComparePrice(SingleUnit A, SingleUnit B)
    {
        if(A.Price>B.Price)
        {
            return 1;
        }
        else if(A.Price == B.Price)
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }
    
    public int CompareValue(SingleUnit A, SingleUnit B)
    {
        if(A.Value>B.Value)
        {
            return 1;
        }
        else if(A.Value == B.Value)
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }
    
    public int searchArray(SingleUnit[] UnitArray, String FindName)
    {
        int counter=0;
        for(SingleUnit item: UnitArray)
        {
            if(FindName.toUpperCase().equals(item.UnitName.toUpperCase()))
            {
                return counter;
            }
            else
                counter++;
        }
        return -1;
    }
    
    
    //Top Level Options
    public void PrintList(SingleUnit[] UnitArray)
    {
        System.out.println("Printing Database.");
        for(SingleUnit item: UnitArray)
        {
            System.out.println("Name: " + item.UnitName);
        }
    }
    
    public void NameSearch(SingleUnit[] UnitArray)
    {
        Scanner in = new Scanner(System.in);
        String searchName;
        System.out.println("Search Name: ");
        searchName = in.nextLine();
        
        int counter = 0;
        boolean found = false;
        System.out.println("Looking for: " + searchName);
        for(SingleUnit item: UnitArray)
        {
            if(searchName.toUpperCase().equals(item.UnitName.toUpperCase()))
            {
                found = true;
                break;
            }
            else
                counter++;
        }
        if(found == false)
            counter = -1;
        System.out.println("The searched name is found in index: " + counter + ". If answer is -1, name is not found");
    }
    
    public void CompareUnits(SingleUnit[] UnitArray)
    {
        Scanner in = new Scanner(System.in);
        String firstname;
        String secondname;
        System.out.println("First Unit to compare:");
        firstname = in.nextLine();
        System.out.println("Second Unit to compare:");
        secondname = in.nextLine();
        int firstindex;
        int secondindex;
        firstindex = searchArray(UnitArray, firstname);
        secondindex = searchArray(UnitArray, secondname);
        if((firstindex == -1) || (secondindex == -1))
        {
           System.out.println("Invalid Inputs");
        }
        else
        {
            switch(UnitArray[firstindex].ComparePrice(UnitArray[firstindex],UnitArray[secondindex]))
            {
                case 1:
                    System.out.println(firstname + " is more expensive than " + secondname);
                    break;
                case 0:
                    System.out.println(firstname + " is as expensive as " + secondname);
                    break;
                case -1:
                    System.out.println(firstname + " is less expensive than " + secondname);
                    break;
                default:
                    break;
            }
            
            switch(UnitArray[firstindex].CompareAge(UnitArray[firstindex],UnitArray[secondindex]))
            {
                case 1:
                    System.out.println(firstname + " is older than " + secondname);
                    break;
                case 0:
                    System.out.println(firstname + " is as old as " + secondname);
                    break;
                case -1:
                    System.out.println(firstname + " is newer than " + secondname);
                    break;
                default:
                    break;
            }
            
            switch(UnitArray[firstindex].CompareValue(UnitArray[firstindex],UnitArray[secondindex]))
            {
                case 1:
                    System.out.println(firstname + " is more valuable than " + secondname);
                    break;
                case 0:
                    System.out.println(firstname + " is as valuable as " + secondname);
                    break;
                case -1:
                    System.out.println(firstname + " is less valuable than " + secondname);
                    break;
                default:
                    break;
            }
        }
    }
    
    
    
    
    //User Choices
    public void UserOptions(SingleUnit[] UnitArray)
    {  
        Scanner in = new Scanner(System.in);
        String userInput;
        boolean exitFlag = false;
        while(exitFlag == false)
        {
			System.out.println("The following options are available: List, Search, Compare, QuitDB. Enter choice.");
			userInput = in.nextLine();
			switch(userInput.toUpperCase())
            {
                case "LIST":
                      //list all names in the array
                    UnitArray[0].PrintList(UnitArray);
                    break;
                case "SEARCH":
                     //Look for a name in the array
                    UnitArray[0].NameSearch(UnitArray);
                    break;
                case "COMPARE":
                    UnitArray[0].CompareUnits(UnitArray);
                    break;
                case "QUITDB":
                    exitFlag = true;
                default:
                    break;
            }
        }
    }
}
