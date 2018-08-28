package com.example.diego.realmalumnos.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;

import com.example.diego.realmalumnos.R;
import com.example.diego.realmalumnos.adapters.MyAdapter;

import com.example.diego.realmalumnos.models.Alumno;


import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity implements RealmChangeListener<RealmResults<Alumno>> {

    private ListView listView;
    private MyAdapter adapter;
    private GridView gridView;

    private Realm realm;
    private RealmResults<Alumno> alumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();
        gridView = (GridView) findViewById(R.id.gridView);

        alumno = getAllAlumno();
        alumno.addChangeListener(this);

        adapter = new MyAdapter(alumno, R.layout.grid_item, this);

        gridView.setAdapter(adapter);
    }

    @Override
    public void onChange(RealmResults<Alumno> element) {
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        realm.removeAllChangeListeners();
        realm.close();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_add:
                addAlumno();
                return true;
            case R.id.item_delete:
                removeAll();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private RealmResults<Alumno> getAllAlumno() {
        return realm.where(Alumno.class).findAll();
    }

    private void removeAll() {
        realm.beginTransaction();
        realm.deleteAll();
        realm.commitTransaction();
    }


    private void addAlumno() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {


                Alumno a1 = new Alumno("18899263-3", "Diego", "Huanaco", 24, "ICIN", 2018, "primero");
                Alumno a2 = new Alumno("18899263-3", "Diego", "Huanaco", 24, "ICIN", 2018, "primero");
                Alumno a3 = new Alumno("18899263-3", "Diego", "Huanaco", 24, "ICIN", 2018, "primero");
                Alumno a4 = new Alumno("18899263-3", "Diego", "Huanaco", 24, "ICIN", 2018, "primero");
                Alumno a5 = new Alumno("18899263-3", "Diego", "Huanaco", 24, "ICIN", 2018, "primero");
                Alumno a6 = new Alumno("18899263-3", "Diego", "Huanaco", 24, "ICIN", 2018, "primero");
                Alumno a7 = new Alumno("18899263-3", "Diego", "Huanaco", 24, "ICIN", 2018, "primero");
                Alumno a8 = new Alumno("18899263-3", "Diego", "Huanaco", 24, "ICIN", 2018, "primero");
                Alumno a9 = new Alumno("18899263-3", "Diego", "Huanaco", 24, "ICIN", 2018, "primero");
                Alumno a10 = new Alumno("18899263-3", "Diego", "Huanaco", 24, "ICIN", 2018, "primero");


                realm.copyToRealmOrUpdate(a1);
                realm.copyToRealmOrUpdate(a2);
                realm.copyToRealmOrUpdate(a3);
                realm.copyToRealmOrUpdate(a4);
                realm.copyToRealmOrUpdate(a5);
                realm.copyToRealmOrUpdate(a6);
                realm.copyToRealmOrUpdate(a7);
                realm.copyToRealmOrUpdate(a8);
                realm.copyToRealmOrUpdate(a9);
                realm.copyToRealmOrUpdate(a10);


                alumno = getAllAlumno();
            }
        });
    }
}