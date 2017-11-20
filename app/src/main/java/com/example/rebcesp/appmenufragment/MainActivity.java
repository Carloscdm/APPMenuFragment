package com.example.rebcesp.appmenufragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cl = (ConstraintLayout) findViewById(R.id.clContenedor);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        Fragment f;

        if (item.getItemId() == R.id.action_settings) {
            Toast.makeText(this, "Se ha pulsado el boton Setting", Toast.LENGTH_LONG).show();

        } else if (item.getItemId() == R.id.menu_uno) {
            Toast.makeText(this,"Accedemos al Primer Fragment", Toast.LENGTH_LONG).show();
            f = new primero();
            abrirFragmento(f);
        } else if (item.getItemId() == R.id.menu_dos) {
            Toast.makeText(this, "Accedemos al Segundo Fragment", Toast.LENGTH_LONG).show();
            f = new segundo();
            abrirFragmento(f);

        }else if(item.getItemId() == R.id.menu_salir){
            crearDialogo().show();
        }

        return true;
    }




    private void abrirFragmento(Fragment f) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.clContenedor, f);
        ft.commit();
    }

    private Dialog crearDialogo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false);
        builder.setMessage("¿Desea Salir de la aplicacion?");
        builder.setPositiveButton("Aceptar",    new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        return builder.create();
    }
}


