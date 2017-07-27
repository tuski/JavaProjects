import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class graph {

	public static void main(String[] args) {
		
		
		try {
			File f=new File("input.txt");
			
			int[] a= new int[2];
			
			Scanner sc = new Scanner(f);
			
			int i=0;
			
			while( i<2){
			 a[i]=sc.nextInt();
			 sc.nextLine();
			i++;
			}
			
			
			
			System.out.println("Node= "+a[0]+" Edege="+a[1]+"\n");
			
			int[][] numbers= new int[a[0]][a[0]];
			
			
			for( i=0;i<a[0];i++){
				for(int j=0;j<a[0];j++){
					numbers[i][j]=0;
				}
				
			}
			
		        while (sc.hasNextLine()) {
		            int val_1 = sc.nextInt();
		            int val_2= sc.nextInt();
		            numbers[val_1][val_2]=1;
		            
		        }
		 //       sc.close();
		        
		        
		        
		        for( i=0;i<a[0];i++){
		        	
					for(int j=0;j<a[0];j++){
				      System.out.print(numbers[i][j]+" ");		
					}
					
					System.out.println("\n");
				}   
		        
		 	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
