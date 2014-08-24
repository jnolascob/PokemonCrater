package com.bootcamp.pokemon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity extends ActionBarActivity {
    /*variables*/
    private int vida_pokemon_01 = 100;
    private int vida_pokemon_02 = 100;
    private int ataque_01 = 30;
    private int ataque_02 = 20;
    private int fin_batalla = 0;

    /*vista*/
    private ImageView pokemon_01;
    private ImageView pokemon_02;
    private TextView vida_01;
    private TextView vida_02;
    private Button boton_iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

       /*creacion del dialogo*/
        final AlertDialog.Builder dialog = new AlertDialog.Builder(MyActivity.this);
        dialog.setTitle("resultados");



        /*pikachu*/
        pokemon_01 = (ImageView) findViewById(R.id.imagen_pokemon_01);
        vida_01 = (TextView)findViewById(R.id.texto_vida_01);


        /*evento de pikachu*/
        pokemon_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyActivity.this, "Pikachu ataca", Toast.LENGTH_SHORT).show();
                vida_pokemon_02 = vida_pokemon_02 - ataque_01;
                vida_02.setText(String.valueOf(vida_pokemon_02));
                Toast.makeText(MyActivity.this, "ahora Giglipuf tiene:" + vida_pokemon_02, Toast.LENGTH_SHORT).show();

                if (vida_pokemon_02 <= 0){
                    fin_batalla = 1;
                    dialog.setMessage("Gano pikachu");
                    dialog.setPositiveButton("Volver a jugar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            vida_01.setText("100");
                            vida_02.setText("100");
                            vida_pokemon_01=100;
                            vida_pokemon_02=100;
                        }
                    });
                    dialog.create();
                    dialog.show();

                }
                if (fin_batalla == 1){
                    Toast.makeText(MyActivity.this, "Fin de la batalla!" + vida_pokemon_02, Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*jiglipuf*/
        pokemon_02 = (ImageView) findViewById(R.id.imagen_pokemon_02);
        vida_02 = (TextView)findViewById(R.id.texto_vida_02);

        /*evento de jiglipuf*/
        pokemon_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MyActivity.this, "Jiglipuf ataca", Toast.LENGTH_SHORT).show();
                vida_pokemon_01 = vida_pokemon_01 - ataque_02;
                Toast.makeText(MyActivity.this, "ahora Pikachu tiene:" + vida_pokemon_01, Toast.LENGTH_SHORT).show();
                vida_01.setText(String.valueOf(vida_pokemon_01));

                if(vida_pokemon_01 <= 0){
                    fin_batalla = 1;
                    dialog.setMessage("Gano jiglipuf");
                    dialog.create();
                    dialog.show();

                }
                if (fin_batalla == 1){
                    Toast.makeText(MyActivity.this, "Fin de la batalla!" + vida_pokemon_02, Toast.LENGTH_SHORT).show();
                }
            }
        });

        /*Reiniciar juego*/

        boton_iniciar=(Button)findViewById(R.id.boton_iniciar);
        boton_iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vida_01.setText("100");
                vida_02.setText("100");
                vida_pokemon_01=100;
                vida_pokemon_02=100;
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
