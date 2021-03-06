package src.main;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Archivio1 {
	
	private ArrayList<Detenuti1> listaDetenuti;
	private ArrayList<Guardie1> listaGuardie;
	static Scanner s = new Scanner(System.in);
	
	public Archivio1() {
		this.listaDetenuti = new ArrayList<>();
		this.listaGuardie = new ArrayList<>();	

	}

	//aggiunge dati anagrafici prigionieri 
	public void addNewPrisoner() {
		try{
			System.out.println("Inserisci il nome del nuovo detenuto: ");
			String nome = s.nextLine();
			System.out.println("Inserisci il cognome: ");
			String cognome = s.nextLine();
			System.out.println("Inserisci la data di nascita: ");
			String dataNascita = s.nextLine();
			System.out.println("Inserisci il luogo di nascita: ");
			String luogoNascita = s.nextLine();
			System.out.println("Inserisci la residenza: ");
			String residenza = s.nextLine(); 
			Detenuti1 detenuto = new Detenuti1(nome, cognome, dataNascita, luogoNascita, residenza);
			this.listaDetenuti.add(detenuto);
		
		} catch(NoSuchElementException e) {
			System.out.println("ops");
		}
	
	}
	
	//aggiunge dati anagrafici guardie  
	public void addNewGuard() {
		try{
			System.out.println("Inserisci il nome della guardia: ");
			String nome = s.nextLine();
			System.out.println("Inserisci il cognome: ");
			String cognome = s.nextLine();
			System.out.println("Inserisci la data di nascita: ");
			String dataNascita = s.nextLine();
			System.out.println("Inserisci il luogo di nascita: ");
			String luogoNascita = s.nextLine();
			System.out.println("Inserisci la residenza: ");
			String residenza = s.nextLine(); 
			Guardie1 guardia = new Guardie1(nome, cognome, dataNascita, luogoNascita, residenza);
			this.listaGuardie.add(guardia);
		} catch(NoSuchElementException ex) {
			System.out.println("ops");
		}
	}
	
	
	//aggiunge dati anagrafici prigionieri [DB]
	public void addPrisoner(Detenuti1 detenuto) {
		this.listaDetenuti.add(detenuto);
	}
	
	//aggiunge dati anagrafici guardie  [DB]
	public void addGuard(Guardie1 guardia) {
		this.listaGuardie.add(guardia);
	}

	// dati anagrafici x nome e cognome
	public void searchPrisoner(String nome, String cognome) {
		for (Detenuti1 detenuti : listaDetenuti) {
			if(detenuti.getNome().equals(nome) & detenuti.getCognome().equals(cognome)){
				detenuti.displayDetenuto();
			}
		}
	}
		
	public void searchGuard(String nome, String cognome) {
		for (Guardie1 guardie : listaGuardie) {
			if(guardie.getNome().equals(nome) & guardie.getCognome().equals(cognome)){
				guardie.displayGuardia();
			}
		}
	}	
	
	// dati anagrafici x cognome
	public void searchPrisoner(String cognome) {
		for (Detenuti1 detenuti : listaDetenuti) {
			if(detenuti.getCognome().equals(cognome)){
				detenuti.displayDetenuto();
			}
		}
	}
		
	public void searchGuard(String cognome) {
		for (Guardie1 guardie : listaGuardie) {
			if(guardie.getCognome().equals(cognome)){
				guardie.displayGuardia();
			}
		}
	}	

	public void displayPrisonersList() {
		for(Detenuti1 detenuti : listaDetenuti) {
				detenuti.displayDetenuto();
		}
	}
	
	public void displayGuardsList() {
		for(Guardie1 guardie : listaGuardie) {
				guardie.displayGuardia();
		}
	}
	
	public void displayFascicoliPrisonersList() {
		for(Detenuti1 detenuti : listaDetenuti) {
			detenuti.getFascicoloDetenuto().displayFascicoloDetenuto();;
		}
	}

	public void displayFascicoliGuardsList() {
		for(Guardie1 guardie : listaGuardie) {
			guardie.getFascicoloGuardia().displayFascicoloGuardia();;
		}
	}
	
	
	public void riepilogoCarcere() {
		
		int i=0, y = 0, z = 0, x = 0;
		
		for(Detenuti1 fascicoliDetenuti : listaDetenuti) {
			y++;
			if(fascicoliDetenuti.getFascicoloDetenuto().isDeceduto()== true) {
				y--; z++;
			}
			if(fascicoliDetenuti.getFascicoloDetenuto().isEvasione() == true) {
				y--; x++;
			}
		}
		System.out.println("Totale detenuti presenti: " + y + "\nTotale detenuti deceduti: " + z + "\nTotale evasi: " + x);

		for(Guardie1 fascicoliGuardie : listaGuardie) {
			i++;
			if(!fascicoliGuardie.getFascicoloGuardia().getDataFineRapporto().equals("none")) {	
				i--;
			}
		}
		System.out.println("Totale Guardie presenti: " + i);
	}
}
/*- il numero delle guardie,
- il numero di detenuti totali,
- il numero di detenuti evasi,
- il numero di detenuti deceduti all’interno della struttura.
*/