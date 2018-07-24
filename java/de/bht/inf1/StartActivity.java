package de.bht.inf1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Diese Aktivität repräsentiert den Startbildschirm des "Fahrpreiskalkulators"
 * der Stadt Studentenhausen. Sie ist als zu startende Standard-Aktivität beim
 * Aufruf der App vorgesehen.
 *
 * @author Beuth Hochschule für Technik
 */
public class StartActivity extends Activity {

    /**
     * Diese Methode wird aufgerufen sobald die Aktivität
     * erzeugt und gestartet wird.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //Rufe gleichnamige Methode der Basisklasse auf

        setContentView(R.layout.main);      //Lade grafische Maske, wie sie in /res/layout/main.xml beschrieben ist

        setStartButtonClickListener();      //selbst geschriebene Funktion (siehe unten)

        setMapButtonClickListener();

        //Aufgabe 1a) Zufallszahlerzeugung [1 Punkt]
        int randomNumber = (int) (Math.random()*100)+1; //hier zufällige Ganzzahl zwischen 1 und 100 generieren

        Log.i("BHT", "Generierte Zufallsganzzahl ist: " + randomNumber);

        //Aufgabe 1b) Einfärbung Grün bzw. Cyan ( ?: Operator zum Farben setzen) [0.5 Punkte]
        applyTitleColor(randomNumber % 2 ==0 ? R.color.cGreen : R.color.cCyan);
    }


    /**
     * Färbt den App-Titel im Splash-Screen abhängig von der übergebenen
     * Farbresource gelb oder blau.
     *
     * @param colorResourceCode Für Gelb <code>R.color.cYellow</code>, für Blau <code>R.color.cBlue</code>
     */
    private void applyTitleColor(int colorResourceCode) {
        TextView appName = (TextView) findViewById(R.id.tv_splash_app_name);
        appName.setTextColor(getResources().getColor(colorResourceCode));
    }

    /**
     * Verknüpft die Berührung des "Button"-Elements der Startseite
     * mit einer Absicht, die Fahrschein-Liste anzuzeigen.
     * (Klasse <code>TicketListActivity</code>)
     */
    private void setStartButtonClickListener() {

        //Hole Referenz auf das Button Element mit der id "btnStart" (siehe res/layout/main.xml)
        Button btnStart = (Button) findViewById(R.id.btnStart);

        //Erzeuge ein (anonymes) Objekt der <code>View.OnClickListener</code>-Klasse,
        //um auf Mouseklicks bzw. Fingerberührungen des Knopfes zu reagieren
        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Bei Klick erzeuge die Absicht ...
                Intent intent = new Intent();
                //.. eine neue Aktivität zu starten (repräsentiert durch die Klasse "TicketListActivity")
                intent.setClass(view.getContext(), TicketListActivity.class);
                //.. und starte die Aktivität
                startActivity(intent);
            }
        });
    }

    private void setMapButtonClickListener(){
        Button btnMap = (Button) findViewById(R.id.btnMap);

        btnMap.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent();

                intent.setClass(view.getContext(),TicketMapsActivity.class);
                startActivity(intent);
            }
        });

    }

}