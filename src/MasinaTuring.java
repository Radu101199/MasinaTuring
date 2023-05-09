import java.io.*;
import java.util.*;

public class MasinaTuring {
	private String st_curenta;
	private String stari_finale[];
	private List<Character> banda;
	private int pointerBanda;
	private ListaTranzitie lt = new ListaTranzitie();
	
	MasinaTuring(String nume_fis) throws Exception{
		BufferedReader buf = new BufferedReader(new FileReader("masinaTuring.txt"));
		this.st_curenta = buf.readLine();
		String stari_finale_str = buf.readLine();
		this.stari_finale = stari_finale_str.split(" ");
		while (true) {
			String tmp = buf.readLine();
			if(tmp == null)
				break;
			else
			{
				String tbl[]=tmp.split("_");
				Tranzitie tr = new Tranzitie(tbl[0],tbl[1].charAt(0),tbl[1].charAt(1),tbl[1].charAt(2),tbl[2]);
				this.lt.adaugaTranzitie(tr);
			}
		}
		
		buf.close();
	    this.banda = new ArrayList<>();
	}

	boolean analizeazaCuvant(String sir_intrare) {
		sir_intrare = sir_intrare.replaceFirst("^\\s*", "");
		
		this.banda.clear();
	    this.banda.add(' ');
	    for (char c : sir_intrare.toCharArray()) {
	        this.banda.add(c);
	    }
	    this.banda.add(' ');
	    this.pointerBanda = 0; 
	        
	    boolean match = false;
	        
		while(!match) {
			if(esteStareFinala(st_curenta)) {
				match=true;
			}
			
			else {
				try{
				Tranzitie tranzitie = lt.gasesteTranzitie(st_curenta, banda.get(pointerBanda));
				if(tranzitie != null) {
				
					executaTranzitie(tranzitie);
					System.out.println(this.banda);
				}
				else {
					match=false;
					break;
				}
			}
			  catch(IndexOutOfBoundsException ex) {
				System.out.println("Capul de citire a sarit de pe banda.");
				match=false;
				break;
			  }
			}
		}
		return match;
	}
	
	private void Stanga() {
		if(pointerBanda == 0) {
//			banda.add(0, ' ');
			
		}
			pointerBanda--;
	}

	private void Dreapta() {
			pointerBanda++;
			if(pointerBanda == banda.size()) {
				banda.add(' ');
			}
	}
		
	private void Scrie(char c) {
		banda.set(pointerBanda, c);
	}
	
	private void executaTranzitie(Tranzitie tranzitie) {
		st_curenta = tranzitie.spuneStsfarsit();
		Scrie(tranzitie.spuneSimbol_Scris());
		if(tranzitie.spuneDirectie() == 'L') {
			Stanga();
		}
		else if(tranzitie.spuneDirectie() == 'R') {
			Dreapta();
		}
	}
	
	private boolean esteStareFinala(String stare) {
			for(String stareFinala : stari_finale) {
				if(stare.equals(stareFinala)) {
					return true;
				}
			}
			return false;
}

	

class MT{
	public static void main(String[] args) throws Exception{
		MasinaTuring M = new MasinaTuring("MasinaTuring.txt");
		System.out.println(M.analizeazaCuvant("aabb"));
		}
	}
}
