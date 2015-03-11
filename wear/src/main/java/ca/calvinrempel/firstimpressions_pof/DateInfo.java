package ca.calvinrempel.firstimpressions_pof;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class DateInfo extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_info);

        // Set custom fonts
        FontManager.setFont(this, (TextView) findViewById(R.id.dateDetails), "biko.otf");
        FontManager.setFont(this, (TextView) findViewById(R.id.where), "cicero.ttf");
        FontManager.setFont(this, (TextView) findViewById(R.id.date), "cicero.ttf");
        FontManager.setFont(this, (TextView) findViewById(R.id.time), "cicero.ttf");

        Meeting tryst = Data.getMeeting();

        TextView where = (TextView) findViewById(R.id.where);
        where.setText( where.getText() + Data.getPlace() );

        TextView date = (TextView) findViewById(R.id.date);
        date.setText(date.getText() + Data.getDate() );

        TextView time = (TextView) findViewById(R.id.time);
        time.setText(time.getText() + Data.getTime());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_date_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
