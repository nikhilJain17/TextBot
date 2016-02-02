package nikhil.com.textbot;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.*;
//import a
import android.os.PowerManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
//import android.widget.Button;
//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.api.GoogleApiClient;
//import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
//import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class MainActivity extends Activity {

    Button startBtn, stopBtn;

//    LatLng currentLocation, desiredLocation;

    LocationManager locationManager;

    boolean here;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button) findViewById(R.id.startBtn);
        stopBtn = (Button) findViewById(R.id.stopBtn);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        here = true;

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);

        // wakelock
        PowerManager pm;
        PowerManager.WakeLock wakeLock;

        pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "why you up swapnanil");
        wakeLock.acquire();


//        locationManager.

    } // end of oncreate


//    private LatLng getCurrentLocation(){
//
//    }

    // start sending texts every 5 mins (for bus is not here)
    public void setStartBtn (View v){

        // timed start?

        // check location
        // if location is not location desired, send "Not here" text
        // else, send "here" text
        // sleep for 10 seconds
        SmsManager manager = SmsManager.getDefault();

        while (here) {

            manager.sendTextMessage("7327427351", null, "NOT HERE", null, null);

            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Log.d("Sent Text", "tru");

        } // end of while



    } // end of setStartBtn









    } // end of class
