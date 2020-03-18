package com.javierpinya.inspecciondevehiculos.fragments.nuevaInspeccion;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.javierpinya.inspecciondevehiculos.R;
import com.javierpinya.inspecciondevehiculos.clases.InspeccionEntity;
import com.javierpinya.inspecciondevehiculos.viewmodels.InspeccionViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CabeceraInspeccionFragment extends Fragment {

    private EditText etNuevaInspeccion,etInspector,etInstalacion,etDesInstalacion;
    private EditText etTransportista,etAlbaran,etFechaArnes,etEmpresaCalibradora;
    private EditText etTractora,etRigido,etCisterna,etFechaCalRig,etFechaCalCis;
    private EditText etCodConductor,etNombreConductor;

    private Spinner spinnerIa;

    private AppCompatCheckBox permiso_conducir,adrcond,itvtrac,itvcis,adrtrac,adrcis;
    private AppCompatCheckBox fichaseguridad,transpondertrac,transpondercis,superficieantides;
    private AppCompatCheckBox posicionadecuada,frenoestacionamiento,bateriadesconectad;
    private AppCompatCheckBox apagallamas,movil,interrupemergencia,tomatierra,mangueragases;
    private AppCompatCheckBox purga,ropa,tc2,montajetags,bajadatags,lecturatags;
    private AppCompatCheckBox estcisterna,estvalvulasapi,estcajonvalvulas,estvalvulasfondo;
    private AppCompatCheckBox recogeralbaran,estequipostras;

    private Button btn_a_compartimentos;

    private DataListener callback;

    private SharedPreferences prefs;

    private List<String> cabecera = new ArrayList<>();
    private List<Boolean> checklist = new ArrayList<>();
    private String inspector;
    private InspeccionViewModel inspeccionViewModel;
    private String cod_inspector;


    public CabeceraInspeccionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            callback = (DataListener)context;
        }catch (Exception e){
            throw new ClassCastException(context.toString() + " should implement DataListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cabecera_inspeccion, container, false);

        prefs = getActivity().getSharedPreferences("preferences", Context.MODE_PRIVATE);

        final SharedPreferences.Editor editor = prefs.edit();

        inspector = prefs.getString("user", "user");
        int num_inspeccion;

        etNuevaInspeccion = view.findViewById(R.id.nueva_inspeccion);
        etInspector = view.findViewById(R.id.et_inspector);
        etInstalacion = view.findViewById(R.id.et_instalacion);
        spinnerIa = view.findViewById(R.id.ias_spinner);
        //etDesInstalacion = view.findViewById(R.id.et_desinstalacion);
        etTransportista = view.findViewById(R.id.et_transportista);
        etAlbaran = view.findViewById(R.id.et_albaran);
        etFechaArnes = view.findViewById(R.id.et_fechaarnes);
        etEmpresaCalibradora = view.findViewById(R.id.et_empresacalibradora);
        etTractora = view.findViewById(R.id.et_tractorainspeccion);
        etCisterna = view.findViewById(R.id.et_cisternainspeccion);
        etRigido = view.findViewById(R.id.et_rigidoinspeccion);
        etFechaCalRig = view.findViewById(R.id.fechacalibracionrigido);
        etFechaCalCis = view.findViewById(R.id.fechacalibracioncisterna);
        etCodConductor = view.findViewById(R.id.et_codconductor);

        permiso_conducir = view.findViewById(R.id.permiso_conducir);
        adrcond = view.findViewById(R.id.adr_conductor);
        itvtrac = view.findViewById(R.id.itv_tractora);
        itvcis = view.findViewById(R.id.itvcisterna);
        adrtrac = view.findViewById(R.id.adrtractora);
        adrcis = view.findViewById(R.id.adrcisterna);
        fichaseguridad = view.findViewById(R.id.ficha_seguridad);
        transpondertrac = view.findViewById(R.id.transpondertractora);
        transpondercis = view.findViewById(R.id.transpondercisterna);
        superficieantides = view.findViewById(R.id.cb_superficiesuperior);
        posicionadecuada = view.findViewById(R.id.cb_posicionvehiculo);
        frenoestacionamiento = view.findViewById(R.id.cb_frenoestacionamiento);
        bateriadesconectad = view.findViewById(R.id.cb_baterias);
        apagallamas = view.findViewById(R.id.cb_apagallamas);
        movil = view.findViewById(R.id.cb_movil);
        interrupemergencia = view.findViewById(R.id.cb_interruptores);
        tomatierra = view.findViewById(R.id.cb_scully);
        mangueragases = view.findViewById(R.id.cb_manguera_gases);
        purga = view.findViewById(R.id.cb_purga);
        ropa = view.findViewById(R.id.cb_ropa);
        estcisterna = view.findViewById(R.id.cb_estanqueidadcisterna);
        estvalvulasapi = view.findViewById(R.id.cb_estanqueidadvalvulasapi);
        estvalvulasfondo = view.findViewById(R.id.cb_estanqueidadvalvulasfondo);
        estcajonvalvulas = view.findViewById(R.id.cb_estanqueidadcajon);
        estequipostras = view.findViewById(R.id.cb_estanqueidadequipostrasiegos);
        tc2 = view.findViewById(R.id.cb_tc2);
        recogeralbaran = view.findViewById(R.id.cb_recogealbaran);
        montajetags = view.findViewById(R.id.montajetags);
        bajadatags = view.findViewById(R.id.cb_bajadatags);
        lecturatags = view.findViewById(R.id.cb_lecturatagsisleta);

        btn_a_compartimentos = view.findViewById(R.id.btn_a_compartimentos);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.instalaciones, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIa.setAdapter(adapter);



        switch (inspector){
            case "AD":
                cod_inspector = "L";
                break;
            case "PM":
                cod_inspector = "C";
                break;
            case "RS":
                cod_inspector = "S";
                break;
            case "AP":
                cod_inspector = "T";
                break;
            default:
                cod_inspector = "error";
                break;
        }
        num_inspeccion=contarInspecciones(cod_inspector);

        etInspector.setText(cod_inspector);
        etNuevaInspeccion.setText(String.valueOf(num_inspeccion));
        etNuevaInspeccion.setEnabled(false);
        etInspector.setEnabled(false);



        btn_a_compartimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                cabecera.add(etNuevaInspeccion.getText().toString());
                cabecera.add(etInspector.getText().toString());
                cabecera.add(etInstalacion.getText().toString());
                cabecera.add(etDesInstalacion.getText().toString());
                cabecera.add(etTransportista.getText().toString());
                cabecera.add(etAlbaran.getText().toString());
                cabecera.add(etFechaArnes.getText().toString());
                cabecera.add(etEmpresaCalibradora.getText().toString());
                cabecera.add(etTractora.getText().toString());
                cabecera.add(etCisterna.getText().toString());
                cabecera.add(etRigido.getText().toString());
                cabecera.add(etFechaCalRig.getText().toString());
                cabecera.add(etFechaCalCis.getText().toString());
                cabecera.add(etCodConductor.getText().toString());
                cabecera.add(etNombreConductor.getText().toString());
                 */

                editor.putString("nuevaInspeccion", etNuevaInspeccion.getText().toString());
                editor.putString("inspector", inspector);
                editor.putString("cod_inspector",cod_inspector);
                editor.putString("instalacion",etInstalacion.getText().toString());
                editor.putString("desInstalacion",spinnerIa.getSelectedItem().toString());
                editor.putString("transportista",etTransportista.getText().toString());
                editor.putString("albaran",etAlbaran.getText().toString());
                editor.putString("fechaArnes",etFechaArnes.getText().toString());
                editor.putString("empresaCalibracion",etEmpresaCalibradora.getText().toString());
                editor.putString("tractora",etTractora.getText().toString());
                editor.putString("cisterna",etCisterna.getText().toString());
                editor.putString("rigido",etRigido.getText().toString());
                editor.putString("fechaCalRig",etFechaCalRig.getText().toString());
                editor.putString("fechaCalCis",etFechaCalCis.getText().toString());
                editor.putString("codConductor",etCodConductor.getText().toString());
                editor.putString("nombreConductor","-");

                /*
                checklist.add(permiso_conducir.isChecked());
                checklist.add(adrcond.isChecked());
                checklist.add(itvtrac.isChecked());
                checklist.add(itvcis.isChecked());
                checklist.add(adrtrac.isChecked());
                checklist.add(adrcis.isChecked());
                checklist.add(fichaseguridad.isChecked());
                checklist.add(transpondertrac.isChecked());
                checklist.add(transpondercis.isChecked());
                checklist.add(superficieantides.isChecked());
                checklist.add(posicionadecuada.isChecked());
                checklist.add(frenoestacionamiento.isChecked());
                checklist.add(bateriadesconectad.isChecked());
                checklist.add(apagallamas.isChecked());
                checklist.add(movil.isChecked());
                checklist.add(interrupemergencia.isChecked());
                checklist.add(tomatierra.isChecked());
                checklist.add(mangueragases.isChecked());
                checklist.add(purga.isChecked());
                checklist.add(ropa.isChecked());
                checklist.add(tc2.isChecked());
                checklist.add(montajetags.isChecked());
                checklist.add(bajadatags.isChecked());
                checklist.add(lecturatags.isChecked());
                 */

                editor.putBoolean("permisoConducir",permiso_conducir.isChecked());
                editor.putBoolean("adrcond",adrcond.isChecked());
                editor.putBoolean("itvtrac",itvtrac.isChecked());
                editor.putBoolean("itvcis",itvcis.isChecked());
                editor.putBoolean("adrtrac",adrtrac.isChecked());
                editor.putBoolean("adrcis",adrcis.isChecked());
                editor.putBoolean("fichaSeguridad",fichaseguridad.isChecked());
                editor.putBoolean("transpondertrac",transpondertrac.isChecked());
                editor.putBoolean("transpondercis",transpondercis.isChecked());
                editor.putBoolean("superficieAntides",superficieantides.isChecked());
                editor.putBoolean("posicionAdecuada",posicionadecuada.isChecked());
                editor.putBoolean("frenoEstacionamiento",frenoestacionamiento.isChecked());
                editor.putBoolean("bateriaDesconectada",bateriadesconectad.isChecked());
                editor.putBoolean("apagallamas",apagallamas.isChecked());
                editor.putBoolean("movil",movil.isChecked());
                editor.putBoolean("interrupEmergencia",interrupemergencia.isChecked());
                editor.putBoolean("tomatierra",tomatierra.isChecked());
                editor.putBoolean("mangueraGases",mangueragases.isChecked());
                editor.putBoolean("purga",purga.isChecked());
                editor.putBoolean("ropa",ropa.isChecked());
                editor.putBoolean("estanqueidadcisterna",estcisterna.isChecked());
                editor.putBoolean("estanqueidadvalvulasapi", estvalvulasapi.isChecked());
                editor.putBoolean("estanqueidadvalvulasfondo",estvalvulasfondo.isChecked());
                editor.putBoolean("estanqueidadcajonvalvulas",estcajonvalvulas.isChecked());
                editor.putBoolean("estanqueidadequipostras",estequipostras.isChecked());
                editor.putBoolean("recogeralbaran",recogeralbaran.isChecked());
                editor.putBoolean("tc2",tc2.isChecked());
                editor.putBoolean("montajeTags",montajetags.isChecked());
                editor.putBoolean("bajadaTags",bajadatags.isChecked());
                editor.putBoolean("lecturaTags",lecturatags.isChecked());

                editor.apply();

                siguiente(cabecera,checklist);
            }
        });

        return view;
    }

    private void siguiente(List<String> cabecera,List<Boolean> checklist){
        callback.sendData(cabecera,checklist);
    }

    public interface DataListener{
        void sendData(List<String> cabecera, List<Boolean> checklist);
    }

    private int contarInspecciones(String cod_inspector){
        int i=0;
        inspeccionViewModel = ViewModelProviders.of(getActivity()).get(InspeccionViewModel.class);
        try{
            i = inspeccionViewModel.getRowCount(cod_inspector);
        }catch (Exception e){
            e.printStackTrace();
        }
        //Toast.makeText(getActivity(), i, Toast.LENGTH_SHORT).show();
        if (i>0) {
            return i;
        }
        return 0;
    }

}
