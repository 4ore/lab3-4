import java.util.Scanner;
public class Osnova {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Graph g = new Graph();
        String Noda;
        boolean x = true; 
        System.out.println("Kilkist vershin i reber:");
        int m = scan.nextInt();
        int n = scan.nextInt();                
        System.out.println("kakie verhini hosh?");
        for(int i = 0; i < m; i++) 
        {
        	Noda = scan.next();
            g.vvod(Noda);
        }              
        System.out.println("a rebra?");
        for(int i = 0; i < n; i++) 
        {
        	String Node1 = scan.next();
        	String Node2 = scan.next();  
        	g.vvod(Node1, Node2);
        }                
        while(x) 
        {
        	System.out.println("1 - vuvestu zvyaznist nod");
        	System.out.println("2 - naytu vershinu po id");
        	int k = scan.nextInt();
        	
        	 if (k == 1) {
        		 g.vuvod();
               } else {
        	 if (k == 2){
        		 g.poisk();
         } else{
     x=false;
        	}
      }  
   }   	 
     
  } 
}