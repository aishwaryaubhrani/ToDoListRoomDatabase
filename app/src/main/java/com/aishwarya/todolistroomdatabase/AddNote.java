package com.aishwarya.todolistroomdatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;

public class AddNote extends AppCompatActivity {

    public static final String EXTRA_TITLE = "com.aishwarya.todolistroomdatabase.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "com.aishwarya.todolistroomdatabase.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY = "com.aishwarya.todolistroomdatabase.EXTRA_PRIORITY";
    private EditText title;
    private EditText description;
    private NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        title = findViewById(R.id.editTextTitle);
        description = findViewById(R.id.editTextDescription);
        numberPicker = findViewById(R.id.numberPicker);

        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add note");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.saveNote:
                saveNote();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void saveNote() {
        String titleText = title.getText().toString();
        String descriptionText = description.getText().toString();
        int priority = numberPicker.getValue();

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, titleText);
        data.putExtra(EXTRA_DESCRIPTION, descriptionText);
        data.putExtra(EXTRA_PRIORITY, priority);

        setResult(RESULT_OK, data);
        finish();
    }
}