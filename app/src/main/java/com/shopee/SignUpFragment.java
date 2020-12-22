package com.shopee;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.shopee.me.User;

public class SignUpFragment extends Fragment {
    private View view;
    EditText edtPhone,edtName,edtPassword;
    Button btnSignUp;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_signup,container,false);

        edtName = (EditText) view.findViewById(R.id.edt_ten);
        edtPhone = (EditText) view.findViewById(R.id.edt_phone);
        edtPassword = (EditText) view.findViewById(R.id.et_pass);
        btnSignUp = (Button) view.findViewById(R.id.bt_dangNhap);
        //Firebase
        final FirebaseDatabase database=FirebaseDatabase.getInstance();
        final DatabaseReference table_user=database.getReference("User");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog mDialog=new ProgressDialog(getActivity());
                mDialog.setMessage("Please Waiting!");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //Check if
                        if (snapshot.child(edtPhone.getText().toString()).exists()) {
                            //Get User information
                            mDialog.dismiss();
                            Toast.makeText(getActivity(), "Số Điện Thoại Đã Tồn Tại !", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            mDialog.dismiss();
                            User user=new User(edtName.getText().toString(),edtPassword.getText().toString());
                            table_user.child(edtPhone.getText().toString()).setValue(user);
                            Toast.makeText(getActivity(), "Đăng Kí Thành Công !", Toast.LENGTH_SHORT).show();
                           // finish();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

        return view;
    }

}
