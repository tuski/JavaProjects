package prime;
import java.util.Scanner;


class palindrome{


public static void main(String [] args){


int mark=getINputMark();
double cgpa = getGrade(mark);
System.out.println("You obtained "+cgpa+" CGPA");

}


public static int getINputMark(){

Scanner scan = new Scanner(System.in);

return scan.nextInt();
}



public static double getGrade(int mark){

if(mark>=40 || mark<=45)
return 2.0;
else if(mark>=46 || mark<=50)
return 2.5;
else if(mark>=51 || mark<=56)
return 2.7;
else if(mark>=57 || mark<=60)
return 3;
else if(mark>=61 || mark<=65)
return 3.3;
else
return 0;

}

}