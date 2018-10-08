package com.example.gmmha.demovid3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    Button btn;

    DatabaseReference databaseArtist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseArtist = FirebaseDatabase.getInstance().getReference("artist");

        editTextName = findViewById(R.id.editTextId);
        btn = findViewById(R.id.btnId);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addName();
            }
        });
    }

    private void addName(){
        String name = editTextName.getText().toString().trim();

        if(!TextUtils.isEmpty(name)){
            String id = databaseArtist.push().getKey();

            Artist artist = new Artist(name, id);
            databaseArtist.child(id).setValue(artist);

            Toast.makeText(this,"Added",Toast.LENGTH_LONG).show();

        }
        else {
            Toast.makeText(this,"Please! Enter a name",Toast.LENGTH_LONG).show();
        }
    }
}
