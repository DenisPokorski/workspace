
public class HundTestlauf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Hund [] haustiere = new Hund[3];
			
		for(int i=0;i<3;i++)	{
			haustiere[i]= new Hund();
			
		}
		
		
		
		haustiere[0].setGewicht(400);
		
		haustiere[1].setGewicht(50);
		
		haustiere[2].setGewicht(3);
		
		haustiere[0].bellen(1);
		haustiere[1].bellen(2);
		haustiere[2].bellen(3);
		
		
		for(int i=0;i<haustiere.length;i++)	{
			System.out.println("Gewicht des Hundes: "+ haustiere[i].getGewicht());

		}
		
		haustiere[0].setName("Bello");
		haustiere[1].setName("Mike");
		haustiere[2].setName("Mietze");
		
		for(int i=0;i<haustiere.length;i++)	{
		System.out.println(haustiere[i].getName());
		}
		

	}

}
