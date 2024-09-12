package com.example.onroadassi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class UserPvdService extends AppCompatActivity {
//    RecyclerView recycler;
//    ArrayList<model> datalist;
//    FirebaseFirestore db;
//    myadapter adapter;
//    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pvd_service);

//        recycler =findViewById(R.id.recycler);
//        recycler.setLayoutManager(new LinearLayoutManager(UserPvdService.this));
//        datalist =new ArrayList<>();
//        db = FirebaseFirestore.getInstance();
//        adapter =new myadapter(datalist);
//        recycler.setAdapter(adapter);
//        progressDialog =new ProgressDialog(UserPvdService.this);
//        progressDialog.setCancelable(false);
//        progressDialog.setTitle("Fetch Data From a Database");
//        progressDialog.show();
//
//
//        db.collection("student").get()
//                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//                    @Override
//                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
//
//                        for (DocumentSnapshot dc:list)
//                        {
//                            model obj = dc.toObject(model.class);
//                            datalist.add(obj);
//                        }
//                        adapter.notifyDataSetChanged();
//                        if (progressDialog.isShowing())
//                            progressDialog.dismiss();
//                    }
//                });
    }
}