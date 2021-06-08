package fr.yanisnumero1.testapimdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Iterator;

import fr.yanisnumero1.testapimdb.been.MovieB;
import fr.yanisnumero1.testapimdb.been.ReponseApi;
import fr.yanisnumero1.testapimdb.instanceretrofit.RetrofitClientInstance;
import fr.yanisnumero1.testapimdb.service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = MainActivity.class.getName();
    private Button mDemarrer;
    private TextView mTextView;
    private int compteur=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDemarrer= findViewById(R.id.mDemarrer);
        mTextView= findViewById(R.id.textView2);



        mDemarrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.v(TAG, "le bouton a été pressé.");

                Service service = RetrofitClientInstance.getRetrofitInstance().create(Service.class);
                Call<ReponseApi> call = service.searchMovie("3ab4a6ec060a07c8c33c9d9b952ccf41", "John wick", 1);
                call.enqueue(new Callback<ReponseApi>() {
                    @Override
                    public void onResponse(Call<ReponseApi> call, Response<ReponseApi> response) {
                        try {


                            ReponseApi resp = response.body();
                            System.out.println("la page est " + resp.getPage());
                            System.out.println("le resultat du premier film est: " + resp.getResults().get(0).getOriginal_title());
                            System.out.println("le total des pages est: " + resp.getTotal_pages());
                            System.out.println("le total du resultat est: " + resp.getTotal_results());

                            Iterator<MovieB> iterator = resp.getResults().iterator();

                            while (iterator.hasNext()){
                                MovieB movieB=iterator.next();
                                System.out.println(movieB.getId());
                                System.out.println(movieB.getOriginal_title());
                                System.out.println(movieB.getOverview());
                            }



                        }catch (NullPointerException e){
                            e.getStackTrace();
                            System.out.println("pas de réponse !");
                        }



                    }

                    @Override
                    public void onFailure(Call<ReponseApi> call, Throwable t) {
                        System.out.println(call.request().body());

                    }
                });

                mTextView.setText("Te revoilà Yanis");
                compteur++;

                if(compteur == 3){

                    Log.v(TAG, "passage à la nouvelle acitivité");
                    Intent intent = new Intent(MainActivity.this, SecondeActivity.class);
                    intent.putExtra("prenom", mTextView.getText());
                    startActivity(intent);
                    compteur=0;

                }


            }
        });
    }
}