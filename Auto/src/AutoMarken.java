
public class AutoMarken {
	private String marke;
	private int ps;
	private String farbe;
	
	
	public int getPs(){
		return ps;
	}
	
	public void setPs(int leistung){
		if (leistung <20){
			System.out.print("Leistung zu gering!");
		} else if (leistung>999){
			System.out.print("Leistung nicht m�glich!");
		} else {
			ps=leistung;
		}
			}
		
		}
