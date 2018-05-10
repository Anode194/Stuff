package com.example.jo.stuff;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText bookTitleEnter,authorFnEnter,authorLnEnter,genreEnter,conditionEnter,editionEnter;
DBhelper booksDB;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        booksDB = new DBhelper(this);
        bookTitleEnter = (EditText)findViewById(R.id.bookTitleEnter);
        authorFnEnter = (EditText)findViewById(R.id.authorFNEnter);
        authorLnEnter = (EditText)findViewById(R.id.authorLNEnter);
        genreEnter = (EditText)findViewById(R.id.genreEnter);
        conditionEnter = (EditText)findViewById(R.id.conditionEnter);
        editionEnter = (EditText)findViewById(R.id.editionEnter);
        Button addBtn = (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               boolean isInserted = booksDB.insertData(bookTitleEnter.getText().toString(),
                        authorLnEnter.getText().toString(),
                        authorLnEnter.getText().toString(),
                        genreEnter.getText().toString(),
                        conditionEnter.getText().toString(),
                        editionEnter.getText().toString());
               if(isInserted)
               {
                   Toast.makeText(MainActivity.this,"data Inserted",Toast.LENGTH_LONG).show();
               }else
               {
                   Toast.makeText(MainActivity.this,"data Not Inserted",Toast.LENGTH_LONG).show();
               }
            }
        });
    }
}
