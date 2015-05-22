package com.example.mathieu.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.*;
import android.view.View;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //Mise en place du conteneur principal

        LinearLayout layout = (LinearLayout)findViewById(R.id.menu_infos); //Récupération du conteneur dans lequel ajouter les partenaires

        elementInfos e;

        //Récupération liste des partenaires
        Resources res = getResources();
        TypedArray ar = res.obtainTypedArray(R.array.liste_infos);

        int n = ar.length();
        for (int i = 0; i < n; ++i)
        {
            //Pour chaque partenaire récupération du nom et de la source
            int resId = ar.getResourceId(i, 0);
            String key = res.getResourceEntryName(resId);
            List<String> values = Arrays.asList(res.getStringArray(resId));


            //Création du composant
            e= new elementInfos(this);

            //Configuration du composant et ajout dans le LinearLayout
            //
            //Ajout du texte
            e.texte.setText(values.get(0));

            //Selection de l'activité à lancer selon le bouton

            switch (i) {
                case 0:
                    e.bouton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent nouvelleActivite = new Intent(MainActivity.this, PresentationAsso.class);

                            startActivity(nouvelleActivite);
                        }
                    });
                    break;
                case 1:
                    e.bouton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent nouvelleActivite = new Intent(MainActivity.this, Billeterie.class);

                            startActivity(nouvelleActivite);
                        }
                    });
                    break;
                case 2:
                    e.bouton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent nouvelleActivite = new Intent(MainActivity.this, Reglement.class);

                            startActivity(nouvelleActivite);
                        }
                    });
                    break;
                case 3:
                    e.bouton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent nouvelleActivite = new Intent(MainActivity.this, Partenaires.class);

                            startActivity(nouvelleActivite);
                        }
                    });
                    break;
            }

            //Ajout du composant
            layout.addView(e);

        }

        ar.recycle();

    }
}
