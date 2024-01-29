package Pack1;

import java.util.*;
public class Driver {
	
	public static void main(String [] args) {
		Scanner input=new Scanner (System.in );
		System.out.println("please enter the key ");
		String key=input.next();
		input.nextLine();
		System.out.println("please enter the plan text ");
		String plan=input.nextLine();
		String cipher=Encription(plan, key);
		System.out.println("Cipher Text : "+cipher);
		System.out.println("The plan text :" +  Decription(cipher));
		
		
	}
	
	
	public static String Encription(String plan,String key)
	{
		
		
		String [][]array=new String [plan.length()/key.length()+1][key.length()];
		
		int k=0,i=0,j=0;
		for( i=0;i<array.length;i++) {
			for( j=0;j<array[i].length;j++) {
				if(k==plan.length()) {
					break;
				}
				array[i][j]=plan.charAt(k)+"";
				k++;
				
			}
		}
		for(;i<array.length;i++) {
			for(;j<array[i].length;j++) {
				array[i][j]="";
			}
		}
		
		for( i=0;i<array.length;i++) {
			for(j=0;j<array[i].length;j++) {
				System.out.print(array[i][j]+ "\t");
			}
			System.out.println();
		}
		System.out.println("------------------------------------------------------------------------------------------------");
		
	
	String [][]cipher=new String[array.length][key.length()];
	  k=0;
	for(i=0;i<key.length();i++) {
		for(j=0;j<cipher.length;j++) {
			cipher[j][k]=array[j][ Integer.parseInt(key.charAt(i)+"")-1 ];
			
		}
		k++;
		
	}
	
	for(i=0;i<cipher.length;i++) {
		for(j=0;j<cipher[i].length;j++) {
			System.out.print(cipher[i][j]+"    ");
		}
		System.out.println();
	}
	System.out.println("-----------------------------------------------------------------------------------------");
	
	String ci="";
	for(i=0;i<cipher[0].length;i++) {
		for(j=0;j<cipher.length;j++) {
			if(cipher[j][i]==null) {
				ci=ci+" ";
				
			}else {
				ci=ci+cipher[j][i];
			}
			
		}
	}
	
	return ci;
	
	
		
		
	}

	
	public static String Decription(String cipher) {
		Scanner input=new Scanner(System.in);
		input.nextLine();
		System.out.println("Please enter the Key");
		String key=input.nextLine();
		
		String [][]array=new String[cipher.length()/key.length()][key.length()];
	int k=0;
	for(int i=0;i<key.length();i++) {
		for(int j=0;j<array.length;j++) {
			array[j][i]=cipher.charAt(k)+"";
			k++;
		}
	
	}
	
	System.out.println("Array Of Cipher : ");
	
	for(int i=0;i<array.length;i++) {
		for(int j=0;j<array[i].length;j++) {
			System.out.print(array[i][j]+"\t\t");
		}
		System.out.println();
	}
	
	
	String [][]plan=new String[array.length][array[0].length];
	System.out.println("After Arrangemnt : ");
	
	for(int i=0;i<key.length();i++) {
		int colimn=Integer.parseInt(key.charAt(i)+"");
		 k=findIndex(key, i+1);
		for(int j=0;j<plan.length;j++) {
			plan[j][i]=array[j][k];
		}
		
	}
	
	String pl="";
	for(int i=0;i<plan.length;i++) {
		for(int j=0;j<plan[i].length;j++) {
			System.out.print(plan[i][j]+"\t\t");
			pl+=plan[i][j];
		}
		System.out.println();
		
	}
	
	return pl;
	
	

		
	}
	
	public static int findIndex(String key,int index) {
		for(int i=0;i<key.length();i++) {
			int number=Integer.parseInt(key.charAt(i)+"");
			if(number==index) {
				return i;
			}
		}
		return -1;
	}
	
}
