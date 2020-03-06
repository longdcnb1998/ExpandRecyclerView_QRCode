package com.example.expandrecyclerview_qrcode;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.expandrecyclerview_qrcode.databinding.ActivityQrCodeBinding;

import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QrCodeActivity extends AppCompatActivity {


    ActivityQrCodeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_qr_code);

        binding.btnGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = binding.edtText.getText().toString().trim();
                if (text != null) {
                    try {
                        String content = binding.edtText.getText().toString().trim();
                        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                        Bitmap bitmap = barcodeEncoder.encodeBitmap(content, BarcodeFormat.QR_CODE, 400, 400);
                        binding.imgResult.setImageBitmap(bitmap);
                    } catch(Exception e) {

                    }


                }

            }
        });
    }
}
