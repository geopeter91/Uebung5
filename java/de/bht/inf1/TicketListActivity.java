package de.bht.inf1;

import java.text.NumberFormat;



import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Diese Aktivität repräsentiert die Auswahl einer bestimmten Fahrscheinart
 * aus einer Liste von Fahrscheinen für verschiedene Tarifgebiete der Stadt
 * Studentenhausen.
 *
 * @author Beuth Hochschule für Technik
 */
public class TicketListActivity extends ListActivity {

    private final static String[] TICKET_NAMES = new String[]{
        "[A1] Innenstadt",
        "[A2] Innenstadt (ermäßigt)",
        "[A3] Innenstadt (Student)",
        "[B1] Standard",
        "[B2] Standard (ermäßigt)",
        "[B3] Standard (Student)",
        "[C1] Randbezirke",
        "[C2] Randbezirke (ermäßigt)",
        "[C2] Randbezirke (Student)",
        "[D] Gruppenkarte"
    };

    private final static double BASE_PRICE_A = 2.00;    //2,00 EUR Basispreis für Tarifgebiet A
    private final static double BASE_PRICE_B = 2.80;    //2,80 EUR Basispreis für Tarifgebiet B
    private final static double BASE_PRICE_C = 3.60;    //3,60 EUR Basispreis für Tarifgebiet C
    private final static double BASE_PRICE_D = 10.50;   //10,50 EUR für die Gruppenkarte

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] ticketsWithPrices = createTicketPriceList();  //Rufe Methode auf, die Sie für Aufgabe 2 schreiben sollen

        //Setze das erzeugte Feld als "Inhalt" für die Listenansicht
        setListAdapter(new MyArrayAdapter(this, android.R.layout.simple_list_item_1, (ticketsWithPrices.length == TICKET_NAMES.length && ticketsWithPrices[0] != null) ? ticketsWithPrices : TICKET_NAMES));

    }


    //========== START: Ihre Codeanpassungen für Aufgabenstellung 2 ==========

    private String[] createTicketPriceList() {
    

		/* Aufgabe 2a) 
		 *   i. Benutzen Sie eine for- oder eine while-Schleife, um durch 
	     *      das statische Array "TICKET_NAMES" zu iterieren und die Fahrscheinbezeichnungen 
		 *      in eine lokale Schleifen-Variable namens "ticketName" auszulesen
		 *
		 *  ii. Definieren Sie eine lokale Schleifen-Variable namens "price" vom Typ double
		 *      und weisen dieser Variable den Wert des Aufrufs der Methode calculateTicketPrice
		 *      zu (Schauen Sie sich dazu die Methodensignatur an, um korrekt zu parametrisieren)
		 *      Hinweis: Solange Sie Aufgabe 3b noch nicht gelöst haben wird der Preis eines
		 *               jeden Fahrscheins als -1.00 EUR in der Liste ausgegeben
		 *       
		 * iii. Weisen sie während eines Schleifendurchlaufs dem bereits deklarierten Feld
		 *      "ticketsWithPrices" eine Kopie des korrespondierenden Wertes aus dem Array 
		 *      "TICKET_NAMES" zu. Die Kopie soll einen Zeilenumbruch sowie den berechneten 
		 *      Fahrscheinpreis aus (ii) enthalten. Benutzen Sie zum Formatieren die
		 *      bereits zur Verfügung gestellte Methode "createTicketWithPriceEntry"
		 *      (Schauen Sie sich dazu die Methodensignatur an, um korrekt zu parametrisieren)
		 *      
		 * [1 Punkt]
		 */

        String[] ticketsWithPrices = new String[TICKET_NAMES.length];
		for (int i=0; i<TICKET_NAMES.length; i++) {
			String ticketName = TICKET_NAMES[i];

			double price = calculateTicketPrice(ticketName);


            Log.i("BHT", ticketName.toString()+": "+price);
			
			
		}
        // [Fügen Sie Ihren Code nachfolgend ein]

        //(i) Deklaration for bzw. while Schleife durch das Array "TICKET_NAMES"
        //__________________________________
        {
            String ticketName = "Weisen sie hier das aktuelle Element aus dem Array zu"; // (i)

            //_____ price = calculateTicketPrice(ticketName);	//hier Lösung von (ii)

            //ticketsWithPrices___ = __________________			//hier Lösung von (iii)
        }

        return ticketsWithPrices;
    }


    /**
     * Berechnet den Preis für einen Fahrschein anhand der Fahrscheinbezeichnung.
     * <ul>
     * <li>Unterscheidet in die Preiskategorien A, B, C und D um den Basispreis zu bestimmen</li>
     * <li>Enthält die Bezeichnung die Zeichenkette "ermäßigt" so werden lediglich 50% des Basispreises fällig</li>
     * <li>Enthält die Bezeichnung die Zeichenkette "Student" so werden 75% des Basispreises fällig</li>
     * </ul>
     *
     * @param ticketName Der Bezeichnung des Fahrscheins dessen Preis berechnet werden soll.
     * @return Einen berechneten Fahrscheinpreis
     */
    private static double calculateTicketPrice(String ticketName) {

        double price = -1.0;


		/* Aufgabe 2b) Fallunterscheidung mit WENN ... DANN ... SONST Konstrukten
		 *
		 * Hinweis 1: Die Basispreise für die Kategorien A, B, C und D sind bereits
		 *            in den statischen Klassenvariablen BASE_PRICE_A, BASE_PRICE_B
		 *            BASE_PRICE_C und BASE_PRICE_D hinterlegt. Verwende diese Variablen!
		 *            
		 * Hinweis 2: Auf jedem String kann man eine Methode "startsWith()" aufrufen
		 *            um abzufragen, ob ein String mit einer bestimmten Zeichenkette beginnt
		 *            
		 * Hinweis 3: Auf jedem String kann man eine Methode "contains()" aufrufen
		 *            um abzufragen, ob ein String eine bestimmte Zeichenkette enthält
		 *            
		 * [1 Punkt]
		 */

        // [Fügen Sie Ihren Code hier ein]
        if (ticketName.startsWith("[A")) {
            price=BASE_PRICE_A;
        }
        else if (ticketName.startsWith("[B")) {
            price=BASE_PRICE_B;
        }
        else if (ticketName.startsWith("[C")) {
            price=BASE_PRICE_C;
        }
        else {
            price=BASE_PRICE_D;
        }

        if (ticketName.contains("ermäßigt")){
            price=price*0.5;
        }
        if (ticketName.contains("Student")){
            price=price*0.75;
        }
        return price;

    }

    //========== ENDE: Ihre Codeanpassungen für Aufgabenstellung 2 ==========


    /**
     * Konkateniert ein Zeilenumbruchssteuerzeichen an das Ende der übergebenen
     * Fahrscheinbezeichnung und formatiert den übergebenen Preis in ein Ausgabeformat
     * mit genau zwei Nachkommastellen.
     * Der formatierte Preis sowie der Suffix "EUR" werden ebenfalls konkateniert
     *
     * @param ticketName - Eine Fahrscheinbezeichnung aus dem Array "TICKET_NAMES"
     * @param price      - Der berechnete Preis des übergebenen Tickets
     * @return Ein formatierter String für die Ausgabe in einer grafischen Liste
     * z.B.  aus den Parametern "[A1] Innenstadt" und 2 würde
     * "[A1] Innenstadt\n2.00 EUR" werden
     */
    private static String createTicketWithPriceEntry(String ticketName, double price) {
        NumberFormat formater = NumberFormat.getInstance();
        formater.setMinimumFractionDigits(2);
        formater.setMaximumFractionDigits(2);
        return (ticketName + "\n" + formater.format(price) + " EUR");
    }


    /*
     * Diese Methode wird aufgerufen sobald ein Listeneintrag angeklickt bzw.
     * mit dem Finger berührt wird. Es liest Fahrscheinbezeichnung sowie den Preis
     * des ausgewählten Eintrags anhand seiner Position in der Liste aus und ruft
     * die nächste Aktivität zur Auswahl der Fahrscheinanzahl auf.
     *
     * Sowohl Fahrscheinbezeichnung als auch Preis werden als "Parameterbündel"
     * an die nächste Aktivität übergeben.
     */
    @Override
    protected void onListItemClick(ListView listView, View touchedView, int posInList, long rowId) {

        //Rufe zunächst den Programmcode der Basisklasse "ListActivity" auf
        super.onListItemClick(listView, touchedView, posInList, rowId);

        String ticketName = TICKET_NAMES[posInList];

        //Optionale Log-Mitteilung in der Konsole zu Prüfzwecken des Programmierers
        Log.d("BHT", "list was touched on pos=" + posInList + ", id=" + rowId);

        //Erzeuge die Absicht ...
        Intent intent = new Intent();

        //.. eine neue Aktivität zu starten (repräsentiert durch die Klasse "TicketAmountSelectionActivity")
        intent.setClass(listView.getContext(), TicketAmountSelectionActivity.class);

        //.. mit einem "Parameterbündel", was Fahrscheinbezeichnung und Preis enthält, ...
        Bundle params = new Bundle();
        params.putString("param_ticketName", ticketName);
        params.putDouble("param_ticketPrice", calculateTicketPrice(ticketName));
        intent.putExtras(params);

        //.. und starte die Aktivität
        startActivity(intent);

        //Toast.makeText(TicketListActivity.this, "Fahrschein " + ticketName + " wurde ausgewählt.", Toast.LENGTH_LONG).show();
    }

}