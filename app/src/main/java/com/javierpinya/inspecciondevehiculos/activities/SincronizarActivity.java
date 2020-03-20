package com.javierpinya.inspecciondevehiculos.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.navigation.NavigationView;
import com.javierpinya.inspecciondevehiculos.R;
import com.javierpinya.inspecciondevehiculos.clases.TaccamiEntity;
import com.javierpinya.inspecciondevehiculos.clases.TaccatrEntity;
import com.javierpinya.inspecciondevehiculos.clases.TacprcoEntity;
import com.javierpinya.inspecciondevehiculos.clases.TacsecoEntity;
import com.javierpinya.inspecciondevehiculos.clases.TplcprtEntity;
import com.javierpinya.inspecciondevehiculos.viewmodels.TaccamiViewModel;
import com.javierpinya.inspecciondevehiculos.viewmodels.TaccatrViewModel;
import com.javierpinya.inspecciondevehiculos.viewmodels.TaccondViewModel;
import com.javierpinya.inspecciondevehiculos.viewmodels.TacprcoViewModel;
import com.javierpinya.inspecciondevehiculos.viewmodels.TacsecoViewModel;
import com.javierpinya.inspecciondevehiculos.viewmodels.TplcprtViewModel;
import com.nbsp.materialfilepicker.MaterialFilePicker;
import com.nbsp.materialfilepicker.ui.FilePickerActivity;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SincronizarActivity extends AppCompatActivity implements View.OnClickListener{

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private SharedPreferences prefs;

    private static final int PERMISSIONS_REQUEST_CODE = 0;
    private static final int FILE_PICKER_REQUEST_CODE = 7;
    private static final int REQUEST_INSPECCION=1;
    private static final int REQUEST_TACCAMI=2;
    private static final int REQUEST_TACCATR=3;
    private static final int REQUEST_TACPRCO=4;
    private static final int REQUEST_TACSECO=5;
    private static final int REQUEST_TPLCPRT=6;

    private TacprcoViewModel tacprcoViewModel;
    private TacsecoViewModel tacsecoViewModel;
    private TaccamiViewModel taccamiViewModel;
    private TaccatrViewModel taccatrViewModel;
    private TaccondViewModel taccondViewModel;
    private TplcprtViewModel tplcprtViewModel;

    private Button btnInspeccion,btnTaccatr,btnTaccami,btnTacprco,btnTacseco,btnTplcprt;

    private SimpleDateFormat parseador = new SimpleDateFormat("dd/MM/yyyy");
    private TextView header_name;
    private String currentInspectionPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sincronizar);

        btnTaccatr = findViewById(R.id.btntaccatr);
        btnTaccami = findViewById(R.id.btntaccami);
        btnTacprco = findViewById(R.id.btntacprco);
        btnTacseco = findViewById(R.id.btntacseco);
        btnTplcprt = findViewById(R.id.btntplcprt);
        setToolbar();
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navview);
        prefs = getSharedPreferences("preferences", Context.MODE_PRIVATE);
        lanzarViewModel();
        View header = navigationView.getHeaderView(0);
        header_name = header.findViewById(R.id.header_name);
        header_name.setText(prefs.getString("user","User"));

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                boolean fragmentTransaction = false;
                Fragment fragment = null;
                Intent i = new Intent();

                switch (item.getItemId()){
                    case R.id.menu_dashboard:
                        i.setClass(SincronizarActivity.this, MenuActivity.class);
                        drawerLayout.closeDrawers();
                        startActivity(i);
                        //fragment = new DashboardFragment();
                        //fragmentTransaction = true;
                        break;
                    case R.id.menu_buscari:
                        i.setClass(SincronizarActivity.this, BuscarInspeccionActivity.class);
                        drawerLayout.closeDrawers();
                        startActivity(i);
                        break;
                    case R.id.menu_buscarv:
                        i.setClass(SincronizarActivity.this, BuscarVehiculoActivity.class);
                        drawerLayout.closeDrawers();
                        startActivity(i);
                        break;
                    case R.id.menu_nuevai:
                        i.setClass(SincronizarActivity.this, CabeceraInspeccionActivity.class);
                        drawerLayout.closeDrawers();
                        startActivity(i);
                        break;
                    case R.id.menu_logout:
                        logOut();
                        return true;
                    case R.id.menu_forget_logout:
                        removeSharedPreferences();
                        logOut();
                        return true;
                }

                return true;
            }
        });




        btnTaccatr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                checkpermissionandopenfilepicker(REQUEST_TACCATR);
            }
        });
        btnTaccami.setOnClickListener(this);
        btnTacprco.setOnClickListener(this);
        btnTacseco.setOnClickListener(this);
        btnTplcprt.setOnClickListener(this);



    }

    private void checkpermissionandopenfilepicker(int requestCode){
        String permission = Manifest.permission.READ_EXTERNAL_STORAGE;

        if(ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, permission)){
                showError();
            }else{
                ActivityCompat.requestPermissions(this, new String[]{permission}, PERMISSIONS_REQUEST_CODE);
            }
        } else{
            openFilePicker(requestCode);
        }
    }

    private void openFilePicker(int requestCode) {
        new MaterialFilePicker()
                .withActivity(this)
                .withRequestCode(requestCode)
                .start();
    }

    private void showError() {
        Toast.makeText(this, "Allow external storage reading", Toast.LENGTH_SHORT).show();
    }

    private void lanzarViewModel() {
        tacprcoViewModel = ViewModelProviders.of(this).get(TacprcoViewModel.class);
        tacsecoViewModel = ViewModelProviders.of(this).get(TacsecoViewModel.class);
        taccamiViewModel = ViewModelProviders.of(this).get(TaccamiViewModel.class);
        taccatrViewModel = ViewModelProviders.of(this).get(TaccatrViewModel.class);
        taccondViewModel = ViewModelProviders.of(this).get(TaccondViewModel.class);
        tplcprtViewModel = ViewModelProviders.of(this).get(TplcprtViewModel.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btntaccami:
                checkpermissionandopenfilepicker(REQUEST_TACCAMI);
                break;
            case R.id.btntaccatr:
                checkpermissionandopenfilepicker(REQUEST_TACCATR);
                break;
            case R.id.btntacprco:
                checkpermissionandopenfilepicker(REQUEST_TACPRCO);
                break;
            case R.id.btntacseco:
                checkpermissionandopenfilepicker(REQUEST_TACSECO);
                break;
            case R.id.btntplcprt:
                checkpermissionandopenfilepicker(REQUEST_TPLCPRT);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            String filePath = data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);
            switch (requestCode){
                case REQUEST_INSPECCION:
                    break;
                case REQUEST_TACCAMI:
                    taccamiViewModel.deleteAllTaccami();
                    leerTaccami(filePath);
                    break;
                case REQUEST_TACCATR:
                    taccatrViewModel.deleteAllTaccatr();
                    leerTaccatr(filePath);
                    break;
                case REQUEST_TACPRCO:
                    tacprcoViewModel.deleteAllTacprco();
                    leerTacprco(filePath);
                    break;
                case REQUEST_TACSECO:
                    tacsecoViewModel.deleteAllTacseco();
                    leerTacseco(filePath);
                    break;
                case REQUEST_TPLCPRT:
                    tplcprtViewModel.deleteAllTplcprt();
                    leerTplcprt(filePath);
                    break;
            }
        }
    }

    private void leerTacprco(String filename){
        Date adr;
        Date itv;
        int tara;
        int peso_max;
        int chip;
        String tipo;
        String nacion;
        boolean gas = false;
        boolean blo = false;
        boolean que = false;

        File file = new File(filename);

        try {
            CSVReader reader = new CSVReader(new FileReader(file),';');
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {

                try {
                    itv = nextLine[1].isEmpty() ? parseador.parse("01/01/1980") : parseador.parse(nextLine[1]);
                    adr = nextLine[2].isEmpty() ? parseador.parse("01/01/1980") : parseador.parse(nextLine[2]);
                    tara = nextLine[3].isEmpty() ? 0 : Integer.parseInt(nextLine[3]);
                    peso_max = nextLine[4].isEmpty() ? 0 : Integer.parseInt(nextLine[4]);
                    chip = nextLine[5].isEmpty() ? 0 : Integer.parseInt(nextLine[5]);
                    tipo = nextLine[6].isEmpty() ? "-" : nextLine[6];
                    nacion = nextLine[7].isEmpty() ? "-" : nextLine[7];
                    gas = !nextLine[8].isEmpty() && Boolean.parseBoolean(nextLine[8]);
                    blo = (!(nextLine[9].equals("N")));
                    que = (!(nextLine[10].equals("N")));

                    tacprcoViewModel.insertTacprco(new TacprcoEntity(nextLine[0],
                            adr,
                            itv,
                            tara,
                            peso_max,
                            chip,
                            tipo,
                            nacion,
                            gas,
                            blo,
                            que));
                } catch (ParseException e) {
                    e.printStackTrace();
                    Log.e("tacprco empty", e.toString() + " nextline: " + reader.getLinesRead());
                }
            }

        }catch (IOException e){
            e.printStackTrace();
            Log.e("Tacprco general", e.toString());
        }

    }

    private void leerTacseco(String filename){
        Date adr;
        Date itv;
        int tara;
        int peso_max;
        int chip;
        String tipo;
        Date calibracion;
        int ejes;
        boolean pes = false;
        String nacion;
        boolean gas = false;
        boolean blo = false;
        boolean que = false;

        File file = new File(filename);
        Date date = new Date();

        try {
            CSVReader reader = new CSVReader(new FileReader(file), ';');
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                try {

                    itv = nextLine[1].isEmpty() ? parseador.parse("01/01/1980") : parseador.parse(nextLine[1]);
                    adr = nextLine[2].isEmpty() ? parseador.parse("01/01/1980") : parseador.parse(nextLine[2]);
                    tara = nextLine[3].isEmpty() ? 0 : Integer.parseInt(nextLine[3]);
                    peso_max = nextLine[4].isEmpty() ? 0 : Integer.parseInt(nextLine[4]);
                    chip = nextLine[5].isEmpty() ? 0 : Integer.parseInt(nextLine[5]);
                    tipo = nextLine[6].isEmpty() ? "-" : nextLine[6];
                    calibracion = nextLine[7].isEmpty() ? parseador.parse("01/01/1980") : parseador.parse(nextLine[7]);
                    ejes = nextLine[8].isEmpty() ? 0 : Integer.parseInt(nextLine[8]);
                    pes = (!nextLine[9].equals("N"));
                    nacion = nextLine[10].isEmpty() ? "-" : nextLine[10];
                    gas = !nextLine[11].isEmpty() && Boolean.parseBoolean(nextLine[11]);
                    blo = (!(nextLine[12].equals("N")));
                    que = (!(nextLine[13].equals("N")));

                    tacsecoViewModel.insertTacseco(new TacsecoEntity(nextLine[0],
                            itv,
                            adr,
                            tara,
                            peso_max,
                            chip,
                            tipo,
                            calibracion,
                            ejes,
                            pes,
                            nacion,
                            gas,
                            blo,
                            que));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
            Log.e("error de importacion", e.toString());
        }
    }

    private void leerTaccami(String filename) {
        int cod_vehiculo;
        String tractora;
        String cisterna;
        int tara;
        int peso_max;
        long i=0;

        File file = new File(filename);

        try {

            CSVReader reader = new CSVReader(new FileReader(file),';');
            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) {
                cod_vehiculo = nextLine[0].isEmpty() ? 0 : Integer.parseInt(nextLine[0]);
                tractora = nextLine[1].isEmpty() ? "E0000AAA" : nextLine[1];
                cisterna = nextLine[2].isEmpty() ? "R0000AAA" : nextLine[2];
                tara = nextLine[3].isEmpty() ? 0 : Integer.parseInt(nextLine[3]);
                peso_max = nextLine[4].isEmpty() ? 0 : Integer.parseInt(nextLine[4]);

                taccamiViewModel.insertarVehiculo(new TaccamiEntity(
                        cod_vehiculo,
                        tractora,
                        cisterna,
                        tara,
                        peso_max));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void leerTaccatr(String filename){
        File file = new File(filename);
        int cod_vehiculo;
        String transportista;
        String slo;

        try {
            CSVReader reader = new CSVReader(new FileReader(file),';');
            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) {
                cod_vehiculo = nextLine[0].isEmpty() ? 0 : Integer.parseInt(nextLine[0]);
                transportista = nextLine[1].isEmpty() ? "N/A" : nextLine[1];
                slo = nextLine[2].isEmpty() ? "N/A" : nextLine[2];
                taccatrViewModel.insertTaccatr(new TaccatrEntity(cod_vehiculo,transportista,slo));
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void leerTplcprt(String filename){
        File file = new File(filename);
        int compartimento;
        String tipo;
        String matricula;
        int capacacidad;
        String tag;

        try {
            CSVReader reader = new CSVReader(new FileReader(file),';');
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                compartimento = nextLine[0].isEmpty() ? 0 : Integer.parseInt(nextLine[0]);
                tipo = nextLine[1].isEmpty() ? "N/A" : nextLine[1];
                matricula = nextLine[2].isEmpty() ? "N/A" : nextLine[2];
                capacacidad = nextLine[3].isEmpty() ? 0 : Integer.parseInt(nextLine[3]);
                tag = nextLine[4].isEmpty() ? "N/A" : nextLine[4];

                tplcprtViewModel.insertTplcprt(new TplcprtEntity(
                        compartimento,
                        tipo,
                        matricula,
                        capacacidad,
                        tag));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void exportarInspecciones(String filename){
        File file = null;
        try {
            file = createInspectionFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File createInspectionFile() throws IOException{
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "inspeccion" + timeStamp;
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        File image = File.createTempFile(
                imageFileName,
                ".csv",
                storageDir
        );
        currentInspectionPath = image.getAbsolutePath();
        return image;
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                // abrir el menu lateral
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logOut(){
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void removeSharedPreferences(){
        prefs.edit().clear().apply();
    }
}
