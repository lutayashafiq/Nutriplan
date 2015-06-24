package com.app.cryptotunnel.nutriplan;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.cryptotunnel.nutriplan.data.NoteItem;


public class NoteEditorActivity extends ActionBarActivity {
    EditText noteText;
    Button save,cancel;

    DatabaseHandler db = new DatabaseHandler(this);
    NoteItem NI = new NoteItem();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        noteText = (EditText) findViewById(R.id.noteText);
        save = (Button) findViewById(R.id.save);
        cancel = (Button) findViewById(R.id.cancel);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Insert: ", "Inserting ..");
                db.addContact(new Contact(noteText.getText().toString(), "56465"));
                Toast.makeText(getApplicationContext(),"Note has been saved", Toast.LENGTH_SHORT).show();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }
//    @SuppressLint("SimpleDateFormat")
//    public static NoteItem getNew() {
//
//        Locale locale = new Locale("en_US");
//        Locale.setDefault(locale);
//
//        String pattern = "yyyy-MM-dd HH:mm:ss Z";
//        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
//        String key = formatter.format(new Date());
//
//        NoteItem note = new NoteItem();
//        note.setKey(key);
//        note.setText("");
//        return note;
//
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_note_editor, menu);
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
