package net.develop2learn.dialog;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    string tag = "DialogFragmentExample";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showMessage(String message)
    {
        Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
    }
    public void doSelectItem(int wich, boolean isChecked)
    {
        showMessage(AlertDialogFragment.items[wich]+(isChecked ? " cheked!" : " uncheked"));
    }
    public void actionClick(String action)
    {
        showMessage(action + "clicked!");
        Log.d(tag, "User clicks on " + action);
    }
    public void onClick(View v)
    {
        AlertDialogFragment dialogFragment = AlertDialogFragment("Are you sure you want to do this?");
        dialogFragment.show(getSupportFragmentManager(), "dialog");
    }
}
