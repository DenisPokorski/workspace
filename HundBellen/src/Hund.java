
public class Hund {
	private int gewicht;
	String name;
	
	public int getGewicht()	{
		return gewicht;
	}
	public void  setGewicht (int s)	{
		if (s < 10) {
			System.out.print("Gewicht zu gering! ");
		} else {
			gewicht = s;
		}
		}
	
	public String getName()	{
		return name;
	}
	
	public void setName(String bez)	{
		name=bez;
	}
	
	
	public void bellen(int anzahlBellen){
		
		while(anzahlBellen > 0)	{
			
			if (gewicht > 60){
				System.out.println("WUFFWUFF!");
			} else if ((gewicht > 40) && (gewicht < 60)){
				System.out.println("Wau Wau");
			} else {
				System.out.println("jAU Jau");
			}
			anzahlBellen--;
			
		}
		
		
		
	}

}
