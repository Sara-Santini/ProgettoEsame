import java.util.ArrayList;


public class Trasporti {
public ArrayList<Automezzo> mezzi = new ArrayList<Automezzo>(); // lista di automezzi
public Destinazione[] destinazioni; // array di destinazioni servite
private int nDestinazioni; // numero di destinazioni servite
private int o=0;
public Trasporti(int max){
	
	destinazioni=new Destinazione[max] ;
	nDestinazioni=max;
	
		
} // max = numero massimo di destinazioni servite
public void aggiungiDestinazione(String unaCitta, int unaDistanza){
	
	destinazioni[o]=new Destinazione(unaCitta,unaDistanza);
o++;
	}
private int cercaTarga(String unaTarga) {
	 
		for(int i=0;i<mezzi.size();i++) {
			if(mezzi.get(i).getTarga().equals(unaTarga)) return i;
		}
		return -1;
	}
public int cercaCitta(String unaCitta) {

	for(int i=0;i<o;i++) {
		if(destinazioni[i].getCitta().equals(unaCitta)) return i;
		}
	   return -1;
}
public void aggiungiMezzo (String unaTarga, String unArrivo){
	
	if(cercaCitta(unArrivo)>=0) {
		Automezzo e = new Automezzo(unaTarga,destinazioni[cercaCitta(unArrivo)]);
	     mezzi.add(e);}
	else {
		
		aggiungiDestinazione(unArrivo,0);
		Automezzo e = new Automezzo(unaTarga,destinazioni[o-1]);
		mezzi.add(e);
		}
}

public void terminaViaggio(String unaTarga){
	if(cercaTarga(unaTarga)>=0) mezzi.get(cercaTarga(unaTarga)).setArrivo(null);
	else System.out.println("mezzo non presente");
	
}
public void assegnaDestinazione(String unaTarga, String unaCitta){
	if(cercaCitta(unaCitta)==-1) aggiungiDestinazione(unaCitta,0);
	if(cercaTarga(unaTarga)>=0)
	{mezzi.get(cercaTarga(unaTarga)).setArrivo(destinazioni[cercaCitta(unaCitta)]);
	 	}
	else if (cercaTarga(unaTarga)<0) aggiungiMezzo(unaTarga,unaCitta);
}
public void eliminaDestinazione(String unaCitt�)
{
 if(cercaCitta(unaCitt�)==-1)
return;
 for(int i=0;i<mezzi.size();i++)
 {
 if(mezzi.get(i).getArrivo()!=null)
 if(mezzi.get(i).getArrivo().getCitta().equals(unaCitt�))
 mezzi.get(i).setArrivo(null);
 }
 destinazioni[cercaCitta(unaCitt�)] = destinazioni[o-1];
 nDestinazioni--;
}
public int stat()
{
 int totale = 0;
 for(int i=0;i<mezzi.size();i++)
 {
 if(mezzi.get(i).getArrivo()!=null)
 totale = totale + mezzi.get(i).getArrivo().getDistanza();
 }
 int media = totale/mezzi.size();
return media;
}
public void stampa(){
	System.out.println(mezzi.size());
	System.out.println(cercaCitta("mil"));
	
	
	vedi modifica
	ciao a tutti
google
buon pranzo
	
}
}