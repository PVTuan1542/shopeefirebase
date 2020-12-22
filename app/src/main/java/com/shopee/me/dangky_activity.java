package com.shopee.me;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shopee.MainActivity;
import com.shopee.R;

public class dangky_activity extends AppCompatActivity {

    ImageView imgBack;
    EditText edtPhone,edtName,edtPassword;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky_activity);

        edtName = (EditText) findViewById(R.id.et_tenDangNhap);
        edtPhone = (EditText) findViewById(R.id.soDT);
        edtPassword = (EditText) findViewById(R.id.et_pass1);
        btnSignUp = (Button) findViewById(R.id.bt_dangKy);
        imgBack = (ImageView) findViewById(R.id.back_DangKy);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //Firebase
        final FirebaseDatabase database= FirebaseDatabase.getInstance();
        final DatabaseReference table_user=database.getReference("User");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog=new ProgressDialog(dangky_activity.this);
                mDialog.setMessage("Please Waiting!");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //Check if
                        if (snapshot.child(edtPhone.getText().toString()).exists()) {
                            //Get User information
                            mDialog.dismiss();
                            Toast.makeText(dangky_activity.this, "Số Điện Thoại Đã Tồn Tại !", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            mDialog.dismiss();
                            User user=new User(edtName.getText().toString(),edtPassword.getText().toString());
                            table_user.child(edtPhone.getText().toString()).setValue(user);
                            Toast.makeText(dangky_activity.this, "Đăng Kí Thành Công !", Toast.LENGTH_SHORT).show();

                            Intent homeIntent = new Intent(dangky_activity.this, dangnhap.class);
                            startActivity(homeIntent);

                            finish();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

    }

}