package id.ac.poliban.mi.va.e020320013.hellocompat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

/**
 * This app demonstrates the use of the ContextCompat class, part of the
 * V4 support library.
 */
public class MainActivity extends AppCompatActivity {
    // Text view for Hello World.
    private TextView mHelloTextView;

    // Array of color names; these match the color resources in color.xml.
    private final String[] mColorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black" };


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelloTextView = findViewById(R.id.hello_textview);

        // Restore saved instance state (the text color).
        if (savedInstanceState != null) {
            mHelloTextView.setTextColor(savedInstanceState.getInt("color"));
        }
    }

    /**
     * Maintains the Activity state across configuration changes.
     *
     * @param outState Activity state bundle.
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current text color.
        outState.putInt("color", mHelloTextView.getCurrentTextColor());
    }

    /**
     * Handles the click of the Change Color button by
     * picking a random color from a color array.
     *
     * @param view The view that was clicked.
     */
    public void changeColor(View view) {
        // Get a random color name from the color array (20 colors).
        Random random = new Random();
        String colorName = mColorArray[random.nextInt(20)];

        // Get the color identifier that matches the color name.
        int colorResourceName = getResources().getIdentifier(colorName,
                "color", getApplicationContext().getPackageName());

        // Get the color ID from the resources the compatible way.
        int colorRes = ContextCompat.getColor(this, colorResourceName);

        // Set the text color.
        mHelloTextView.setTextColor(colorRes);
    }
}