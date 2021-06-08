package fr.yanisnumero1.testapimdb;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondeActivity extends AppCompatActivity {

    private final static String TAG= SecondeActivity.class.getName();
    private TextView mSecondeTxt;

  @Override
    protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_seconde);
      Log.v(TAG, "arrivé dans la seconde activité");
      String textRecu ="";
      mSecondeTxt= findViewById(R.id.secondTxt);

      Intent intent = getIntent();
      textRecu = intent.getStringExtra("prenom");

      mSecondeTxt.setText(textRecu);
  }
}
