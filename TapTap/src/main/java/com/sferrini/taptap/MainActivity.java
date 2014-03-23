package com.sferrini.taptap;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private TextView message;
    private ImageView bomb;

    private View.OnClickListener bombTapListener;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeApp();

    }

    private void initializeApp() {
        message = (TextView) findViewById(R.id.textView);
        bomb = (ImageView) findViewById(R.id.imageView);

        bombTapListener = new  View.OnClickListener() {
            public  void  onClick(View v) {
                touchBomb();
            }
        };
        bomb.setOnClickListener(bombTapListener);
    }

    private void touchBomb() {
        counter ++;

        if (counter < 5) {
            message.setText(String.format("You touched the bomb %s", counter));
        } else {
            bomb.setImageResource(R.drawable.explosion);
            message.setText(String.format("Oops! The bomb is exploded"));
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
