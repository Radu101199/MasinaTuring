public class Tranzitie {
	private String st_inceput;
	private char simbol_Citit;
	private char simbol_Scris;
	private char directie;
	private String st_sfarsit;
	
	Tranzitie(String st_inceput, char simbol_Citit, char simbol_Scris, char directie, String st_sfarsit){
		this.st_inceput=st_inceput;
		this.simbol_Citit=simbol_Citit;
		this.simbol_Scris=simbol_Scris;
		this.directie=directie;
		this.st_sfarsit=st_sfarsit;
	}
	
	String spuneStinceput() {
		return this.st_inceput;
	}
	
	char spuneSimbol_Citit() {
		return this.simbol_Citit;
	}
	
	char spuneSimbol_Scris() {
		return this.simbol_Scris;
	}
	
	char spuneDirectie() {
		return this.directie;
	}
	
	String spuneStsfarsit() {
		return this.st_sfarsit;
	}
}
