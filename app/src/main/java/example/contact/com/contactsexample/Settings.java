package example.contact.com.contactsexample;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

public class Settings extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SeekBar redBar,greenBar,blueBar;
    int r,g,b;
    ConstraintLayout cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
          redBar=(SeekBar)findViewById(R.id.redBar);
         greenBar=(SeekBar)findViewById(R.id.greendBar);
         blueBar=(SeekBar)findViewById(R.id.greendBar);
        cl =(ConstraintLayout)findViewById(R.id.mainLayout);
        sharedPreferences=getSharedPreferences("MySetting",MODE_PRIVATE);
        //To get the Value
        r= sharedPreferences.getInt("RED",0);
        g= sharedPreferences.getInt("GREEN",0);
        b= sharedPreferences.getInt("BLUE",0);

        //Setting the progess bars
        redBar.setProgress(r);
        greenBar.setProgress(g);
        blueBar.setProgress(b);

        cl.setBackgroundColor(Color.rgb(r,g,b));

        redBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                cl.setBackgroundColor(Color.rgb(redBar.getProgress(),greenBar.getProgress(),blueBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("RED",seekBar.getProgress());
                editor.commit();

            }
        });

        greenBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                cl.setBackgroundColor(Color.rgb(redBar.getProgress(),greenBar.getProgress(),blueBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("GREEN",seekBar.getProgress());
                editor.commit();

            }
        });

        blueBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                cl.setBackgroundColor(Color.rgb(redBar.getProgress(),greenBar.getProgress(),blueBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("BLUE",seekBar.getProgress());
                editor.commit();

            }
        });
    }
}
