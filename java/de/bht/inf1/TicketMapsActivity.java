package de.bht.inf1;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class TicketMapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        setMainButtonClickListener();

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        double ffLat = 52.3389347;
        double ffLong = 14.5305848;
        LatLng latlng = new LatLng(ffLat, ffLong);

        // Add a marker in Sydney and move the camera
        mMap.addMarker(new MarkerOptions().position(latlng).title("Tarifgebiet A"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng,12));

        CircleOptions circle = new CircleOptions();
        circle.clickable(true);
        circle.center(latlng);
        circle.radius(1000); // in meter
        circle.fillColor(Color.argb(100,255,255,0));
        circle.strokeColor(0x00000000);
        googleMap.addCircle(circle);


    }

    private void setMainButtonClickListener() {
        //Hole Referenz auf das Button Element mit der id "btnStart" (siehe res/layout/main.xml)
        Button btnStart = (Button) findViewById(R.id.btnStart);

        //Erzeuge ein (anonymes) Objekt der <code>View.OnClickListener</code>-Klasse,
        //um auf Mouseklicks bzw. Fingerberührungen des Knopfes zu reagieren
        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //Bei Klick erzeuge die Absicht ...
                Intent intent = new Intent();
                //.. eine neue Aktivität zu starten (repräsentiert durch die Klasse "TicketListActivity")
                intent.setClass(view.getContext(), StartActivity.class);
                //.. und starte die Aktivität
                startActivity(intent);
            }
        });
    }
}