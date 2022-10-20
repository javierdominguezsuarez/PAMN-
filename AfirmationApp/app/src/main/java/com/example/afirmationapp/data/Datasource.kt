package com.example.afirmationapp.data

import com.example.afirmationapp.R
import com.example.afirmationapp.model.Afirmation

class Datasource {
     fun loadAffirmations() : List<Afirmation>{
         return listOf<Afirmation>(
             Afirmation(R.string.afirmation1),
             Afirmation(R.string.afirmation2),
             Afirmation(R.string.afirmation3),
             Afirmation(R.string.afirmation4),
             Afirmation(R.string.afirmation5),
             Afirmation(R.string.afirmation6),
             Afirmation(R.string.afirmation7),
             Afirmation(R.string.afirmation8),
             Afirmation(R.string.afirmation9),
             Afirmation(R.string.afirmation10),
         )

    }
}