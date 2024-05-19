package com.example.myprofile;

import static android.text.TextUtils.replace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button educationButtonId, skillButtonId, galleryButtonId, hobbyButtonId,contactButtonId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        educationButtonId=findViewById(R.id.educationButtonId);
        skillButtonId=findViewById(R.id.skillButtonId);
        galleryButtonId=findViewById(R.id.galleryButtonId);
        hobbyButtonId=findViewById(R.id.hobbyButtonId);
        contactButtonId=findViewById(R.id.contactButtonId);

        educationButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replace(new EducationFragment());

            }

        });
        skillButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replace(new SkillFragment());
            }
        });

      galleryButtonId.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              replace(new GalleryFragment());
          }
      });

      hobbyButtonId.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              replace(new HobbyFragment());
          }
      });

      contactButtonId.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(MainActivity.this, ContactActivity.class);
              startActivity(intent);
          }


      });

    }
    private void replace(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutId, fragment);
        fragmentTransaction.commit();

    }

}