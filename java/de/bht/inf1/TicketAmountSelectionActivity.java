package de.bht.inf1;

import java.text.NumberFormat;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Diese Aktivität steuert den Ablauf des Dialogs, der nach Auswahl eines
 * Tickets aus der Ticketliste die Anzahl der zu erwerbenden Tickets abfragt
 * und den Gesamtpreis samt Rabatt berechnet.
 *
 * @author Beuth Hochschule für Technik
 */
public class TicketAmountSelectionActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ticket_amount_selection);

        //Lese Parameterbündel aus, was von der vorherigen Aktivität übergeben wurde
        Bundle recvParams = getIntent().getExtras();
        final String ticketName = recvParams.getString("param_ticketName");
        final double singleTicketPrice = recvParams.getDouble("param_ticketPrice");

        //Setze den gewählten Fahrschein in den Platzhalter ein
        final TextView tvSelectedTicket = (TextView) this.findViewById(R.id.tv_selected_ticket);
        tvSelectedTicket.setText(ticketName);

        //Setze den Preis des Fahrscheins in den Platzhalter ein (formatiert zu "x.yy EUR")
        final TextView tvPrice = (TextView) this.findViewById(R.id.tv_price);
        tvPrice.setText(formatDoubleToPriceInfo(singleTicketPrice));

        //Hole Referenzen auf die übrigen Platzhalter (konstante Referenzen)
        final TextView tvDiscount = (TextView) this.findViewById(R.id.tv_discount);

        final EditText etTicketAmount = (EditText) this.findViewById(R.id.et_ticket_amount);

        final TextView tvTotalPrice = (TextView) this.findViewById(R.id.tv_total_price);
        tvTotalPrice.setText(formatDoubleToPriceInfo(singleTicketPrice));

        //Füge an das Textfeld eine Lauscherklasse hinzu, die auf Änderungen der Zahl im Textfeld reagiert
        etTicketAmount.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                //Rufe Methode Aufgabe 3a auf
                int amount = parseAmount(etTicketAmount.getText().toString());

                //Rufe Methode Aufgabe 3b auf
                double discount = calculateDiscount(amount);

                if (discount != 0.0)
                    tvDiscount.setText((int) (discount * 100) + "%");
                else
                    tvDiscount.setText("Keiner");

                double totalPrice = singleTicketPrice * amount * (1 - discount);
                tvTotalPrice.setText(formatDoubleToPriceInfo(totalPrice));
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

    private static String formatDoubleToPriceInfo(double price) {
        NumberFormat formater = NumberFormat.getInstance();
        formater.setMinimumFractionDigits(2);
        formater.setMaximumFractionDigits(2);
        return formater.format(price) + " EUR";
    }


    //========== START: Ihre Codeanpassungen für Aufgabenstellung 3 ==========

    /**
     * Ermittelt aus der übergebenen Zeichenkette eine Ganzzahl vom Typ <code>int</code>
     *
     * @param amountAsString - eine Referenz auf die Zeichenkette, die geparsed werden soll.
     * @return Die geparste Ganzzahl oder 0 sofern sie nicht ermittelt werden konnte
     */
    private static int parseAmount(String amountAsString) {
        int amount = 0;
        //Log.d("BHT","amountAsString: "+amount);

        //=== Aufgabe 3a ===
        //Prüfung auf null und Leerstring und parsen einer Ganzzahl aus einem String [1 Punkt]

        //[Fügen Sie Ihren Code hier ein]
        if (amountAsString!=null && !amountAsString.isEmpty()) {
            amount = Integer.parseInt(amountAsString);
        }

        return amount;
    }


    /**
     * Berechnet einen Preisnachlassfaktor basierend auf der übergebenen Anzahl von Tickets:
     * <ul>
     * <li>Anzahl 1x   ==>   Rabatt-Faktor ist 0    </li>
     * <li>Anzahl 2x   ==>   Rabatt-Faktor ist 0.05 </li>
     * <li>Anzahl 3x   ==>   Rabatt-Faktor ist 0.1  </li>
     * <li>Anzahl 4x   ==>   Rabatt-Faktor ist 0.15 </li>
     * <li>Anzahl Nx   ==>   Rabatt-Faktor ist 0.2  </li>
     * </ul>
     *
     * @param amount - Anzahl der zu erwerbenden Tickets als Ganzzahl
     * @return Ein anzuwendender Rabatt-Faktor als Gleitpunktzahl
     */
    private static double calculateDiscount(int amount) {
        double discount = 0.0f;

		/* == Aufgabe 3b ==
         * Switch-Anweisung (kein WENN ... DANN!!!) für Rabatt-Höhe
		 * in Abhängigkeit der Fahrscheinanzahl:
		 *   - Wenn die Anzahl 1 ist, dann sei die Rabatt-Variable auf 0 eingestellt
		 *   - Wenn die Anzahl 2 ist, dann sei die Rabatt-Variable auf 0.05 eingestellt
		 *   - Wenn die Anzahl 3 ist, dann sei die Rabatt-Variable auf 0.1 eingestellt
		 *   - Wenn die Anzahl 4 ist, dann sei die Rabatt-Variable auf 0.15 eingestellt
		 *   - Bei 5 (oder höher), sei die Rabatt-Variable immer auf 0.2 eingestellt (repräsentiert 20%)
		 *
		 *   [0.5 Punkte]
		 */

        //[Fügen Sie Ihren Code hier ein]

        switch(amount){
            case 0:
            case 1:
                discount = 0.0;
                break;
            case 2:
                discount = 0.05;
                break;
            case 3:
                discount = 0.1;
                break;
            case 4:
                discount = 0.15;
                break;
            default:
                discount = 0.2;
        }

        return discount;
    }

    //========== ENDE: Ihre Codeanpassungen für Aufgabenstellung 3 ==========

}
