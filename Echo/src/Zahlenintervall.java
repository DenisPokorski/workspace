public class Zahlenintervall{
		
	int zahlenintervall (int anfang, int ende) {
		int erg =0;
		while (anfang <= ende) {
			erg = erg+anfang;
			anfang++; 
		}	
		return erg;
		} 	
	}