import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

public class Hod extends Igra{
	public void chelovekhodit(){
		Scanner sc=new Scanner(System.in);
		int hid=-1;
		while(hid==-1){
			try{
				System.out.print("Kuda hodite: ");
				hid=sc.nextInt();
				while(hid<1||hid>dlinnapola ||Pole[hid-1]==chelovek||Pole[hid-1]==computer){
					if(hid<1||hid>dlinnapola)
						System.out.println("Drugu nado,ce ne roboche");
					else
						System.out.println("Tut zanyato,drugu nado");
					System.out.print("Vvodi:");
					hid=sc.nextInt();
					}
				}
			catch(InputMismatchException ex){
				System.out.println("Vvedi mij 1 i 9");
				sc.next();
				hid=-1;
			}
		}
		Pole[hid-1]=chelovek;
		hodiv++;
	}
	public void computerhodit(){
		Random Rand=new Random();
		int hid;
		for(int i=0;i<dlinnapola; i++) {
			if (Pole[i]!=chelovek && Pole[i]!=computer) {
				char save=Pole[i];
				Pole[i]=computer;
				if (peremojec()==3){
					System.out.println("computer hodit v "+(i+1));
					hodiv++;
					return;
				}
				else
					Pole[i]=save;
			}
		}
		for(int i=0;i<dlinnapola;i++) {
			if (Pole[i]!=chelovek && Pole[i]!=computer) {
				char save=Pole[i];   
				Pole[i]=chelovek;
				if(peremojec()==2){
					Pole[i]=computer;
					System.out.println("computer hodit v "+(i+1));
					hodiv++;
					return;
				}
				else
					Pole[i]=save;
			}
		}
		do
		{
			hid=Rand.nextInt(dlinnapola);
		} while(Pole[hid]==chelovek||Pole[hid]==computer);
		System.out.println("computer hodit v  "+(hid+1));
		Pole[hid]=computer;
		hodiv++;
	}
}
