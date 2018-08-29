package com.efefer.testapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

  CharSequence[] items = {"Google", "Apple", "Microsoft"};
  boolean[] itemsChecked = new boolean[items.length];

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void onClick(View v) {
    showDialog(0);
  }

  @Override
  protected Dialog onCreateDialog(int id) {
    
    switch(id) {
      
      case 0:
        return new AlertDialog.Builder(this)
        .setTitle("This is a dialog with some simple text ...")
        .setPositiveButton("OK", 
          new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int whichButton) {
              Toast.makeText(getBaseContext(), "OK is clicked!", Toast.LENGTH_SHORT).show();
            }
          }
        )
        .setNegativeButton("Cancel",
          new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
              Toast.makeText(getBaseContext(), "Cancel is clicked!", Toast.LENGTH_SHORT).show();
            }
          }
        )
        .setMultiChoiceItems(items, itemsChecked,
          new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
              Toast.makeText(getBaseContext(),
                             items[which] + (isChecked ? " checked" : " unchecked"),
                             Toast.LENGTH_SHORT).show();
            }
          }
        ).create();
    }
    return null;
  }

}

