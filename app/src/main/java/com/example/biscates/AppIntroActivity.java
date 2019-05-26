package com.example.biscates;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage; //Caso use SliderPages

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class AppIntroActivity extends AppIntro {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {this.getSupportActionBar().hide();} catch(NullPointerException e){}
        //setContentView(R.layout.activity_app_intro);

        addSlide(AppIntroFragment.newInstance("First Intro", "description",
                R.drawable.def_user, ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary)));

        addSlide(AppIntroFragment.newInstance("Second Intro", "description",
                R.drawable.def_user, ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark)));

        addSlide(AppIntroFragment.newInstance("Third Intro", "description",
                R.drawable.def_user, ContextCompat.getColor(getApplicationContext(), R.color.colorAccent)));

        addSlide(AppIntroFragment.newInstance("Fourth Intro", "description",
                R.drawable.def_user, ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary)));



        // Note here that we DO NOT use setContentView();

        // Add your slide fragments here.
        // AppIntro will automatically generate the dots indicator and buttons.

        // Instead of fragments, you can also use our default slide.
        // Just create a `SliderPage` and provide title, description, background and image.
        // AppIntro will do the rest.
        /*
        SliderPage sliderPage = new SliderPage();
        sliderPage.setTitle("Something");
        sliderPage.setDescription("Something new");
        sliderPage.setImageDrawable(R.drawable.testingImage4);
        sliderPage.setBgColor(Color.BLUE);
        addSlide(AppIntroFragment.newInstance(sliderPage));

        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.parseColor("#3F51B5"));
        setSeparatorColor(Color.parseColor("#2196F3"));

        // Hide Skip/Done button.
        showSkipButton(false);
        setProgressButtonEnabled(false);

        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.
        setVibrate(true);
        setVibrateIntensity(30); */

    }

    @Override
    public void onDonePressed(Fragment currentFragment){
        super.onDonePressed(currentFragment);
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

        //test
        //super.onSkipPressed(currentFragment);
        //Toast.makeText(AppIntroActivity.this, "App Intro Ended", Toast.LENGTH_SHORT).show();
    }

    /*
    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
    */
}