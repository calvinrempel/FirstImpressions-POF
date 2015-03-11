package ca.calvinrempel.firstimpressions_pof;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ContactInfo extends Activity {

    // You!
    private Profile user;

    //Date you have coming up
    private Meeting tryst;

    // User you're on a date with
    private Profile other;


    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        // Set the custom fonts
        FontManager.setFont(this, (TextView) findViewById(R.id.name), "cicero.ttf");
        FontManager.setFont(this, (TextView) findViewById(R.id.age), "cicero.ttf");
        FontManager.setFont(this, (TextView) findViewById(R.id.birthday), "cicero.ttf");
        FontManager.setFont(this, (TextView) findViewById(R.id.gender), "cicero.ttf");

        other = Data.getRhea();
        TextView name = (TextView) findViewById(R.id.name);
        name.setText(name.getText() + other.getName());

        TextView age = (TextView) findViewById(R.id.age);
        age.setText(age.getText() + "" + other.getAge());

        TextView gender = (TextView) findViewById(R.id.gender);
        gender.setText(gender.getText() + other.getGender());

        TextView birthday = (TextView) findViewById(R.id.birthday);
        birthday.setText( birthday.getText() + other.getBirthDate()) );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact_info, menu);
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
