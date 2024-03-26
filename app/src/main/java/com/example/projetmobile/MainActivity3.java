package com.example.projetmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    ListView listeV;
    SearchView rechercher;
    personneadap perd;
    ArrayList<personne> locations = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        rechercher = findViewById(R.id.rechercher);
        rechercher.clearFocus();
        rechercher.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
        listeV = findViewById(R.id.listeview);
        locations.add(new personne(R.drawable.drapeautunis,"tunisia"));
        locations.add(new personne(R.drawable.drapeaufrance,"france"));
        locations.add(new personne(R.drawable.drapeauegybte,"egypte"));
        locations.add(new personne(R.drawable.drapeauesp,"espagne"));
        locations.add(new personne(R.drawable.drapeauruss,"russie"));
        fillLocationsList(locations);
    }

    private void fillLocationsList(ArrayList<personne> locations) {
        perd=new personneadap(this,R.layout.liste_row,locations);
        listeV.setAdapter(perd);
    }

    private void filterList(String text){
        ArrayList<personne> filterList = new ArrayList<>();
        for(personne per : locations){
            if(per.getName().toLowerCase().contains(text.toLowerCase())) {
                filterList.add(per);
            }
        }
        fillLocationsList(filterList);
    }
}