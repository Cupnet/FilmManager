package it.apuliadigitalmaker.studenti.filmmanager.mongodb.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.apuliadigitalmaker.studenti.filmmanager.mongodb.model.Category;
import it.apuliadigitalmaker.studenti.filmmanager.mongodb.model.Film;

public class MessaggioDiRisposta<T> {
	
	private String messaggio;
	private String codice;
	private boolean esitoOperazione;
	private T payload;
	
	public String getMessaggio() {
		return messaggio;
	}



	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}



	public String getCodice() {
		return codice;
	}



	public void setCodice(String codice) {
		this.codice = codice;
	}



	public boolean isEsitoOperazione() {
		return esitoOperazione;
	}



	public void setEsitoOperazione(boolean esitoOperazione) {
		this.esitoOperazione = esitoOperazione;
	}







	public T getPayload() {
		return payload;
	}



	public void setPayload(T payload) {
		this.payload = payload;
	}



	public MessaggioDiRisposta() {
		super();
	}



	public MessaggioDiRisposta(String messaggio, String codice, boolean esitoOperazione, T category) {
		super();
		this.messaggio = messaggio;
		this.codice = codice;
		this.esitoOperazione = esitoOperazione;
		this.payload = category;
	}



	public static void main(String[] args) {
		MessaggioDiRisposta<?> mess = new MessaggioDiRisposta<>();
		MessaggioDiRisposta<Film> mess2 = new MessaggioDiRisposta<>();
		
		Category cat = new Category();
		Film film = new Film();
		
		cat.setName("Pippo");
		cat.setName("Pluto");
		
		cat = new Category();
		
		mess2.setPayload(film);
		//mess.setPayload(cat);
		
		List<Integer> listaStringhe = new ArrayList<>();
		
		listaStringhe.add(2);
		
		
		Category cat1 = new Category();
		cat1.setName("Azione");
		Category cat2 = new Category();
		
		final Category cat3 = cat1;
		cat1 = cat2;
		
		
		
		List<Number> lista = new ArrayList<>();
		
		Integer i = Integer.valueOf(2);
		
		lista.add(i);
		
		Map<Category, List<?>> dizionarioFilm = new HashMap<>();
		List<Film> filmAzione = new ArrayList<>();
		
		dizionarioFilm.put(cat1, filmAzione);
		
		dizionarioFilm.get(cat1);
	
	
		
		
	}
}
