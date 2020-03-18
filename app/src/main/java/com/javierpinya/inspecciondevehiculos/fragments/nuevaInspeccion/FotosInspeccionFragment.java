package com.javierpinya.inspecciondevehiculos.fragments.nuevaInspeccion;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Environment;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraX;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureConfig;
import androidx.camera.core.Preview;
import androidx.camera.core.PreviewConfig;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.javierpinya.inspecciondevehiculos.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class FotosInspeccionFragment extends Fragment {

    private int REQUEST_CODE_PERMISSIONS = 101;
    private String[] REQUIRED_PERMISSIONS = new String[]{"android.permission.CAMERA","android.permission.WRITE_EXTERNAL_STORAGE"};
    private String currentPhotoPath;
    private String inspeccion;

    private SharedPreferences prefs;

    TextureView textureView;


    public FotosInspeccionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fotos_inspeccion, container, false);

        prefs = getActivity().getSharedPreferences("preferences", Context.MODE_PRIVATE);
        inspeccion = prefs.getString("nuevaInspeccion","errorInspeccion");

        textureView = view.findViewById(R.id.view_finder);

        if(allPermissionGranted()){
            startCamera(view);
        }else{
            ActivityCompat.requestPermissions(getActivity(), REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS);
        }

        return view;

    }

    private void startCamera(View view){

        CameraX.unbindAll();
        Size screen = new Size(textureView.getWidth(), textureView.getHeight());

        PreviewConfig pConfig = new PreviewConfig.Builder().setTargetResolution(screen).build();
        Preview preview = new Preview(pConfig);

        preview.setOnPreviewOutputUpdateListener(
                new Preview.OnPreviewOutputUpdateListener() {
                    @Override
                    public void onUpdated(@NonNull Preview.PreviewOutput output) {
                        ViewGroup parent = (ViewGroup)textureView.getParent();
                        parent.removeView(textureView);
                        parent.addView(textureView);

                        textureView.setSurfaceTexture(output.getSurfaceTexture());
                        updateTransform();
                    }
                }
        );

        ImageCaptureConfig imageCaptureConfig = new ImageCaptureConfig.Builder().setCaptureMode(ImageCapture.CaptureMode.MIN_LATENCY).
                setTargetRotation(getActivity().getWindowManager().getDefaultDisplay().getRotation()).build();

        final ImageCapture imgCap = new ImageCapture(imageCaptureConfig);

        view.findViewById(R.id.img_capturafoto).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                File file = null;
                try {
                    file = createImageFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                imgCap.takePicture(file, ContextCompat.getMainExecutor(requireContext()), new ImageCapture.OnImageSavedListener() {
                    @Override
                    public void onImageSaved(@NonNull File file) {
                        String msg = "Pic captured at " + file.getAbsolutePath();
                        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(@NonNull ImageCapture.ImageCaptureError imageCaptureError, @NonNull String message, @Nullable Throwable cause) {

                        String msg = "Pic captured failed: " + message;
                        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();

                        if (cause != null){
                            cause.printStackTrace();
                        }

                    }
                });
            }
        });

        CameraX.bindToLifecycle(getActivity(), preview, imgCap);
    }
    
    private File createImageFile() throws IOException{
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = inspeccion + timeStamp;
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
        );
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    private void updateTransform() {

        Matrix mx = new Matrix();

        float w = textureView.getMeasuredWidth();
        float h = textureView.getMeasuredHeight();

        float cx = w / 2f;
        float cy = h / 2f;

        int rotationDgr=0;
        int rotation = (int )textureView.getRotation();

        switch (rotation){
            case Surface.ROTATION_0:
                rotationDgr = 0;
                break;
            case Surface.ROTATION_90:
                rotationDgr = 90;
                break;
            case Surface.ROTATION_180:
                rotationDgr = 180;
                break;
            case Surface.ROTATION_270:
                rotationDgr = 270;
                break;
            default:
                break;
        }

        mx.postRotate((float)rotationDgr,cx,cy);
        textureView.setTransform(mx);
    }

    private boolean allPermissionGranted(){
        for(String permission : REQUIRED_PERMISSIONS){
            if(ContextCompat.checkSelfPermission(getActivity(), permission) != PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }

}
