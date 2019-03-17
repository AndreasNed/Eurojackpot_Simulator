import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Eurojackpot {

	public static void main(String[] args) throws InterruptedException{
		Scanner sc = new Scanner(System.in);		
		Integer[] Num = new Integer[5];
		Integer[] specialNum = new Integer[2];
		HashMap<Integer[], Integer[]> rowList = new HashMap<>();
		
		System.out.println("Welcome to EuroJackpot Simulator!\n1) Långsam dragning\n2) Snabb dragnig \n3) Sortera\n4) Lista");
		while(true) {
			int go = sc.nextInt();
			switch(go) {
			case 1:
				drawNumbers(Num);
				drawSpecial(specialNum);			
				checkDuplicate(Num);
				checkDuplicateSpecial(specialNum);
				
				printWinningSlow(Num,specialNum);
				break;
				
			case 2:
				drawNumbers(Num);
				drawSpecial(specialNum);			
				checkDuplicate(Num);
				checkDuplicateSpecial(specialNum);
				
				printWinningFast(Num,specialNum);
				rowList.put(Num, specialNum);
				break;
				
			case 3:
				bubbleSortList(Num, specialNum);
				break;
				
			case 4:
				for(int i=0;i<rowList.size();i++) {
					System.out.println(rowList.toString());
				}

				break;
				
			default:
				System.out.println("Press Enter to begin!");
				break;
			}		
		}	
	}
	private static void bubbleSortList(Integer[] num, Integer[] specialNum) {
        int n = num.length;  
        int temp = 0;
        int temp2 = 0;
         for(int i=0; i < n; i++){  
        	 for(int j=1; j < (n-i); j++){  
        		 if(num[j-1] > num[j]){   
        			 temp = num[j-1];  	
        			 num[j-1] = num[j];  
        			 num[j] = temp;
        		 }
        		 if(specialNum[0] > specialNum[1]) {
        			 temp2 = specialNum[0];  	
        			 specialNum[0] = specialNum[1];  
        			 specialNum[1] = temp2;
        		 }
        	 }
         }
         System.out.println("Sorted row: "+num[0]+", "+num[1]+", "+num[2]+", "+num[3]+", "+num[4]+ " : "+specialNum[0]+", "+specialNum[1]);	
		
	}
	private static void printWinningFast(Integer[] num, Integer[] specialNum){
		System.out.println("Complete row: "+num[0]+", "+num[1]+", "+num[2]+", "+num[3]+", "+num[4]+ " : "+specialNum[0]+", "+specialNum[1]);	
	}
	
	private static void printWinningSlow(Integer[] num, Integer[] specialNum) throws InterruptedException {
		System.out.print("Drawing numbers");Thread.sleep(1000); System.out.print(".");Thread.sleep(1000); System.out.print(".");Thread.sleep(1000); System.out.print(".");Thread.sleep(1000); System.out.print(".");

		System.out.println("\nFirst number: "+num[0]);
		Thread.sleep(1000);
		System.out.println("Second number: "+num[1]);
		Thread.sleep(1000);
		System.out.println("Third number: "+num[2]);
		Thread.sleep(1000);
		System.out.println("Forth number: "+num[3]);
		Thread.sleep(1000);
		System.out.println("Fifth number: "+num[4]);
		Thread.sleep(1000);
		System.out.println("");
		System.out.print("Drawing special numbers" );Thread.sleep(1000); System.out.print(".");Thread.sleep(1000); System.out.print(".");Thread.sleep(1000); System.out.print(".");
		System.out.println("");
		Thread.sleep(1000);
		System.out.println("\nSpecial number one: "+specialNum[0]);
		Thread.sleep(1000);
		System.out.println("Special number two: "+specialNum[1]);
		Thread.sleep(1000);
		System.out.println("");
		System.out.println("");
		System.out.println("Complete row: "+num[0]+", "+num[1]+", "+num[2]+", "+num[3]+", "+num[4]+ " : "+specialNum[0]+", "+specialNum[1]);
		
	}

	public static void drawNumbers(Integer[] num) {
		for(int i=0;i<num.length;i++) { // DRAW NUMBERS
			num[i] = (int)(Math.random()*50)+1;			
		}
	}
	
	public static void drawSpecial(Integer[] specialNum) {
		for(int i =0;i<specialNum.length;i++) { // DRAW SPECIAL
			specialNum[i] = (int)(Math.random()*10)+1;	
		}	
	}
	
	public static void checkDuplicate(Integer[] num) {
		while(num[0] == num[1] || num[0] == num[2] || num[0] == num[3] || num[0] == num[4]) {
			num[0] = (int)(Math.random()*50)+1;
		}
		while(num[1] == num[0] || num[1] == num[2] || num[1] == num[3] || num[1] == num[4]) {
			num[1] = (int)(Math.random()*50)+1;
		}
		while(num[2] == num[1] || num[2] == num[0] || num[2] == num[3] || num[2] == num[4]) {
			num[2] = (int)(Math.random()*50)+1;
		}
		while(num[3] == num[1] || num[3] == num[0] || num[3] == num[2] || num[3] == num[4]) {
			num[3] = (int)(Math.random()*50)+1;
		}
		while(num[4] == num[1] || num[4] == num[0] || num[4] == num[2] || num[4] == num[3]) {
			num[4] = (int)(Math.random()*50)+1;
		}
	}
	public static void checkDuplicateSpecial(Integer[] specialNum) {
		while(specialNum[0] == specialNum[1]) {
			specialNum[0] = (int)(Math.random()*10)+1;
		}
		while(specialNum[1] == specialNum[0]) {
			specialNum[1] = (int)(Math.random()*10)+1;
		}
	}
}

