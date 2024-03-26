package com.example.projetmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    ListView listeV;
    SearchView rechercher;
    List<personne> listeP;

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

        listeV=findViewById(R.id.listeview);
        ArrayList<personne> arrayList=new ArrayList<>();
        arrayList.add(new personne(R.drawable.drapeautunis,"tunisia"));
        arrayList.add(new personne(R.drawable.drapeaufrance,"france"));
        arrayList.add(new personne(R.drawable.drapeauegybte,"egypte"));
        arrayList.add(new personne(R.drawable.drapeauesp,"espagne"));
        arrayList.add(new personne(R.drawable.drapeauruss,"russie"));
        personneadap perd=new personneadap(this,R.layout.liste_row,arrayList);
        listeV.setAdapter(perd);
    }

    private void filterList(String text){
    List<personne> filterList=new ArrayList<>();
    for(personne per:listeP){
        if(per.getName().toLowerCase().contains(text.toLowerCase())) {
            filterList.add(per);
        }
    }
    }
}