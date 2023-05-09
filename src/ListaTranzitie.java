import java.util.ArrayList;

public class ListaTranzitie {
	private ArrayList <Tranzitie> lista = new ArrayList<>();
	
	void adaugaTranzitie(Tranzitie th) {
		this.lista.add(th); 
	}
	Tranzitie returneazaTranzitie(int i) {
		return this.lista.get(i);
	}
	
	Tranzitie gasesteTranzitie(String stare, char simbol_Citit)
	{
		for(int i=0; i<lista.size();i++) {
			Tranzitie tmp=lista.get(i);
			if(tmp.spuneStinceput().equals(stare) && 
					tmp.spuneSimbol_Citit()==simbol_Citit)
				return tmp;
	}
		return null;
	}
}
