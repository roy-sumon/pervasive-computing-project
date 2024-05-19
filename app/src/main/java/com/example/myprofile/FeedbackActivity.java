package com.example.myprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.EditText;

import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedbackActivity extends AppCompatActivity {
    EditText feedbackNameId,feedbackCommentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


    }

    public void func(View view) {
        feedbackNameId=findViewById(R.id.feedbackNameId);
        feedbackCommentId=findViewById(R.id.feedbackCommentId);

        String name = feedbackNameId.getText().toString();
        String comment = feedbackCommentId.getText().toString();

        FeedbackDatabase collect = new FeedbackDatabase(name, comment);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference root = firebaseDatabase.getReference("Feedback");
        root.child(name).setValue(collect);

        feedbackNameId.setText("");
        feedbackCommentId.setText("");

        Toast.makeText(this, "Your comment successfully stored", Toast.LENGTH_SHORT).show();

    }
}