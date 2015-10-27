
public class EinfachDotComSpiel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int anzahlTipps =0;
		SpielHelfer helfer = new SpielHelfer();
		EinfachDotComKlasse dasDotCom = new EinfachDotComKlasse();
		
		int zufallsZahl = (int) (Math.random()*5);
		
		int orte[] = {zufallsZahl, zufallsZahl+1, zufallsZahl+2};
		
		dasDotCom.setZellorte(orte);
		
		boolean lebt = true;
		
		while (lebt == true)	{
			String tipp = helfer.getBenutzereingabe("Geben Sie ein Zahl ein: ");
			String ergebnis = dasDotCom.prüfDich(tipp);
			anzahlTipps++;
			
			if(ergebnis.equals("Versenkt"));
				lebt=false;
				
				System.out.println("Sie haben"+ anzahlTipps + "Versuche benötitgt.");
				}

	}

}
