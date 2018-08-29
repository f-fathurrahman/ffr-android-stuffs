package com.efefer.testapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

public class MainActivity extends Activity {

  String tag = "Lifecycle";  // use less than 23 characters (?)
  
  // This function is called when the activity is first created
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // hides the title bar
    requestWindowFeature(Window.FEATURE_NO_TITLE);

    setContentView(R.layout.activity_main);
    Log.d(tag, "In the onCreate event");
  }

  public void onStart() {
    super.onStart();
    Log.d(tag, "In the onStart() event");
  }

  public void onRestart() {
    super.onRestart();
    Log.d(tag, "In the onRestart() event");
  }

  public void onResume() {
    super.onResume();
    Log.d(tag, "In the onResume() event");
  }

  public void onPause() {
    super.onResume();
    Log.d(tag, "In the onPause() event");
  }

  public void onStop() {
    super.onResume();
    Log.d(tag, "In the onStop() event");
  }

  public void onDestroy() {
    super.onResume();
    Log.d(tag, "In the onDestroy() event");
  }

}
