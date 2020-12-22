package com.shopee.home;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.shopee.MainActivity;
import com.shopee.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final int REQUEST_CODE_GPS_PERMISSION = 100;
    Button btn_gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        btn_gps = findViewById(R.id.get_gps);
        btn_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MapsActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {
                    getCurrentLocation();
                } else {
                    requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            REQUEST_CODE_GPS_PERMISSION);
                    getCurrentLocation();
                }
            }
        });
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    //    kiểm tra quyền truy cập GPS
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
////        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode) {
//            case REQUEST_CODE_GPS_PERMISSION:
//                for (int grantResult : grantResults) {
//                    if (grantResult != PackageManager.PERMISSION_GRANTED) {
//
//                    }
//                }
//                break;
//        }
//    }


    private void getCurrentLocation() {
        FusedLocationProviderClient mLocationClient =
                LocationServices.getFusedLocationProviderClient(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location == null) {
                    return;
                }
                LatLng currentLocation =
                        new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker (new MarkerOptions().position(currentLocation).title("Your Location"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLocation));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f));
            }
        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng dana =
                new LatLng(16.05623918754373, 108.20155567441994);
//        mMap.addMarker (new MarkerOptions().position(dana).title("Thành Phố Đà Nẵng"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dana));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(13.0f));
    }


}