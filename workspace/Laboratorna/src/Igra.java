import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Igra {
	public final static char Pole[]={'1','2','3','4','5','6','7','8','9'};
	public static final int dlinnapola=9;
	public static final char chelovek='X';
	public static final char computer='O';
	public static int hodiv=0;
	public int peremojec(){ //provirku na peremojca
		for(int i = 0;i<=6;i+=3){
			if(Pole[i]==chelovek && Pole[i+1]==chelovek && Pole[i+2]==chelovek)
				return 2;
			if(Pole[i]==computer && Pole[i+1]==computer && Pole[i+2]==computer)
				return 3;
		}
		for (int i = 0;i<= 2;i++) {
			if (Pole[i] ==chelovek && Pole[i+3] ==chelovek && Pole[i+6]==chelovek)
				return 2;
			if (Pole[i]==computer && Pole[i+3]==computer && Pole[i+6]==computer)
				return 3;
		}
		if((Pole[0]==chelovek && Pole[4]==chelovek && Pole[8]==chelovek)||(Pole[2]==chelovek && Pole[4]==chelovek && Pole[6]==chelovek))
	return 2;
		if((Pole[0]==computer && Pole[4]==computer && Pole[8]==computer)||(Pole[2]==computer && Pole[4]==computer && Pole[6]==computer))
	return 3;
		for(int i=0;i<dlinnapola;i++){
			if(Pole[i]!=chelovek && Pole[i]!=computer)
				return 0;
		}
		return 1;
	}
	public static void main(String[] args){
		SimpleDateFormat formatdati=new SimpleDateFormat("HH:mm:ss K:m:s a (dd/MM/yyyy) \n"); 
		String a=formatdati.format(new Date());
		long nachalo=System.currentTimeMillis();
		Pole p=new Pole();
		Hod chel=new Hod();
		Hod comp=new Hod();
		Igra proverka=new Igra();
		char cherga=chelovek;
		int win=0;
		while(win==0){
			p.IgrovePole();
			if(cherga==chelovek){
				chel.chelovekhodit();
				cherga=computer;
			}
			else{
				comp.computerhodit();
				cherga=chelovek;
			}
			win=proverka.peremojec();
			}
		p.IgrovePole();
		System.out.println();
		if (win==1){
			System.out.println("Nichuya");
		}
		else if (win==2){
			System.out.println("Chelovek vugrav!"); 
		}
		else if (win==3){
			System.out.println("Computer vugrav!");
		}
		else
			System.out.println("Shos pushlo ne tak");
		long konec = System.currentTimeMillis();
		long trivalist = konec-nachalo;
	    SimpleDateFormat formatdati2= new SimpleDateFormat("HH:mm:ss K:m:s a (dd/MM/yyyy) \n"); 
        try(FileWriter zapisnik=new FileWriter("D:\\resultati.txt", false))
	     {	        
	         String nichuya="Resultat:nichuya ";
	         String pobeda="Resultat:chelovek pobediv ";
	         String progrash="Resultat:computer pobediv ";
	         String chas="Trivalist: "+trivalist/1000+" secynd";
	         String nachalo2="Nachalo igri: "+a;
	         String konec2 = "Konec igri: "+formatdati2.format(new Date()) ;	         
	         String kilkist="kilkist krokiv : "+hodiv;	       	         
	         if(win==1){
	        	 zapisnik.write(nichuya+"\r\n");
				}
				else if(win==2){
					zapisnik.write(pobeda+"\r\n");
				}
				else if(win==3){
					zapisnik.write(progrash+"\r\n");
				}	         
	         zapisnik.write(chas+"\r\n");
	         zapisnik.write(nachalo2+"\r\n");
	         zapisnik.write(konec2+"\r\n");
	         zapisnik.write(kilkist+"\r\n");     
	     }
	     catch(IOException ex){	          
	         System.out.println(ex.getMessage());
	     } 
		}
	}