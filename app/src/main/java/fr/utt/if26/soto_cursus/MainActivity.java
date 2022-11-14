package fr.utt.if26.soto_cursus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView text = (TextView) findViewById(R.id.main_tv);
        text.setText("Modules du Programme ISI");
        text.setTextSize(30);
        text.setTextColor(Color.BLUE);

        this.registerForContextMenu(text);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.main_menu_sigle_list:
                sigleList();
                break;
            case R.id.main_menu_sigle_add:
                sigleAdd();
                break;
            case R.id.main_menu_sigle_del:
                sigleDel();
                break;
            case R.id.main_menu_module_list:
                moduleList();
                break;
            case R.id.main_menu_module_list_recycler:
                 moduleListRecycler();
                 break;
            case R.id.main_menu_module_add:
                moduleAdd();
                break;
            case R.id.main_menu_module_del:
                moduleDel();
                break;
        }

        return true;
    }


    private void sigleList() {
        Intent intent = new Intent(this, SigleListActivity.class);
        startActivity(intent);
    }
    private void sigleAdd() {
        Toast.makeText(this, "Je veux ajouter des sigles", Toast.LENGTH_LONG).show();
    }
    private void sigleDel() {
        Toast.makeText(this, "Je veux supprimer des sigles", Toast.LENGTH_LONG).show();
    }

    private void moduleList() {
        Intent intent = new Intent(this, ModuleListActivity.class);
        startActivity(intent);
    }
    private void moduleListRecycler() {
        Intent intent = new Intent(this, ModuleRecyclerActivity.class);
        startActivity(intent);
    }

    private void moduleAdd() {
        Toast.makeText(this, "Je veux ajouter des modules", Toast.LENGTH_LONG).show();
    }
    private void moduleDel() {
        Toast.makeText(this, "Je veux supprimer des modules", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_option_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        onOptionsItemSelected(item);
        return true;


    }
}