package com.example.movieratingapp;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        ImageView imgView=findViewById(R.id.movieImg);
        TextView title=findViewById(R.id.titleDetails);
        TextView overview=findViewById(R.id.OverviewDetails);
        TextView rate=findViewById(R.id.RatingDetails);
        Button ratingBtn=findViewById(R.id.ratingbtn);
        EditText inpRating=findViewById(R.id.ratingInput);


        Bundle bundle=getIntent().getExtras();
        String mTitle=bundle.getString("title");
        String mPoster=bundle.getString("poster");
        String mOverview=bundle.getString("Overview");
        String mRating=String.valueOf(bundle.getDouble("rating"));


        Glide.with(this).load(mPoster).into(imgView);
        title.setText(mTitle);
        overview.setText(mOverview);
        rate.setText(mRating);



        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        ratingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt=inpRating.getText().toString();
                Toast.makeText(DetailedActivity.this,"Your Rating added successfully",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}