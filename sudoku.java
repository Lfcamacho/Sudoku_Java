import java.util.*;
public class sudoku{
   public static Scanner sc = new Scanner(System.in);
   public static Scanner leer = new Scanner(System.in);
   public static void main(String[] args){

	   int a=0, b=0, c=0, d=0, e=0, g=1, x=0, y=0, op=0, complete=1, finish=0, check=0;
	   String num;


	   System.out.println("==SUDOKU==");
	   System.out.println("NAME: Luis Fernando Camacho Bernal");


while(finish==0)
{

	   System.out.println("\n\nMENU");
	   System.out.println("Game Description........1");
	   System.out.println("Instructions............2");
	   System.out.println("Play....................3");
	   System.out.println("Exit....................4\n");
	   System.out.print("Select an option: ");
	   op=sc.nextInt();


	   switch(op)
	   {

		   case 1:
		   		System.out.println("\n-GAME DESCRIPTION-");
		   		System.out.println("This game is made up of a 9x9 square grid, divided into 3x3 square regions. Starting from some numbers already arranged in some of the boxes, \nyou must fill in the empty boxes.\n");
				System.out.println("Rule 1: fill in the empty boxes with a single number from 1 to 9. \nRule 2: there cannot be repeated numbers in the same row. \nRule 3: in the same column there cannot be repeated numbers. \nRule 4: There cannot be repeated numbers in the same region. \nRule 5: the solution of a sudoku is unique. \n");

		   break;

		   case 2:
		   		System.out.println("\n-INSTRUCTIONS-");
		   		System.out.println("1. First you must write the number you want to enter the sudoku");
		   		System.out.println("2. Enter a number from 1 to 9 to indicate the x coordinate of the board");
		   		System.out.println("3. Enter a number from 1 to 9 to indicate the y coordinate of the board");
		   		System.out.println("4. If after finishishing filling the sudoku correctly the program will give you another opportunity to do so");

		   break;

		   case 3:



 String[][] sudoku={{" ","5","7"," "," "," "," ","4"," "},
       	     		{" "," ","3"," "," ","2"," ","7","5"},
       	     		{"2","4"," "," "," "," "," ","3"," "},
       	     		{" ","9"," ","6"," "," "," ","2","7"},
       	     		{" "," "," "," ","9","8","5","6"," "},
       	     		{"5"," ","6","7"," "," "," "," ","8"},
       	     		{" ","7","1"," "," ","4"," "," ","6"},
       	     		{"9"," "," "," "," "," "," "," "," "},
    	     		{"8","2"," ","3"," ","5"," "," "," "}};


while(complete==1)
{
	while(g==1)
	{
		System.out.println();

		System.out.println(" 1   2   3   4   5   6   7   8   9\n");
		System.out.println("------------------------------------");

		while(a<9)
		{
			while(b<9)
			{
				g=0;
				if(sudoku[a][b].compareTo(" ")==0)
				{
					g=1;
				}
				System.out.print(" "+sudoku[a][b]+" ");
				b++;
				c=b%3;
				if(c==0)
				{
					System.out.print("|");
				}
				else
				{
					System.out.print(" ");

				}
			}

			System.out.print("   "+(a+1));
			a++;
			b=0;
			d=a%3;
			if(d==0)
			{
				System.out.println();
				System.out.print("------------------------------------");
				System.out.println();

			}
			else
			{
				System.out.println("\n");
			}
				e=0;

		}

		if(g==1)
		{
		System.out.print("Number you want to insert: ");
		num=leer.nextLine();

		do{
		System.out.print("Coordinate x: ");
		x=sc.nextInt();



		if(x<1||x>9)
		{
			check=1;
			System.out.println("Invalid number, insert another one: ");
		}
		else
		{
			check=0;
		}

		}while(check==1);

		x=x-1;

		do{
		System.out.print("Coordinate y: ");
		y=sc.nextInt();

		if(y<1||y>9)
		{
			check=1;
			System.out.println("Invalid number, insert another one: ");
		}
		else
		{
			check=0;
		}


		}while(check==1);
		y=y-1;

		sudoku[y][x]=num;
		}

		a=0;
		b=0;

	}//while de cuando se esta haciendo el sudoku

	g=1;
	complete=solution(sudoku);

	if(complete==1)
	{
		System.out.println("SUDOKU IS WRONG, TRY TO FIX IT");

		System.out.print("Number you want to insert: ");
		num=leer.nextLine();
		System.out.print("Coordinate x: ");
		x=sc.nextInt();
		x=x-1;
		System.out.print("Coordinate y: ");
		y=sc.nextInt();
		y=y-1;

		sudoku[y][x]=num;

	}
	else
	{
		System.out.println("CONGRATULATIONS YOU FINISHED THE GAME");
		finish=1;
	}



}//cuando ya esta bien el sudoku

   break;

   		case 4:
   			System.out.println("you choosed exit option");
   			finish=1;

   		break;

   		default:
   			System.out.println("You selected an invalid option, select another one");
   		break;


	}//switch

}

}//finishal de main

    public static int solution(String[][]sudoku)
    {
		int a=0, b=0, c=0;

    	String[][] solution={{"1","5","7","8","3","9","6","4","2"},
							 {"6","8","3","1","4","2","9","7","5"},
							 {"2","4","9","5","7","6","8","3","1"},
							 {"4","9","8","6","5","3","1","2","7"},
							 {"7","1","2","4","9","8","5","6","3"},
							 {"5","3","6","7","2","1","4","9","8"},
							 {"3","7","1","9","8","4","2","5","6"},
 							 {"9","6","5","2","1","7","3","8","4"},
							 {"8","2","4","3","6","5","7","1","9"}};
		while(a<9)
		{
			while(b<9)
			{
				if(sudoku[a][b].compareTo(solution[a][b])!=0)
				{
					c=1;
				}
				b++;
			}

			a++;
			b=0;
		}
		return c;

	}

   }