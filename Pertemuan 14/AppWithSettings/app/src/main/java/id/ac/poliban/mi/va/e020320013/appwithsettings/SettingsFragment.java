package id.ac.poliban.mi.va.e020320013.appwithsettings;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;


/**
 * A subclass of PreferenceFragmentCompat to supply preferences in a
 * Fragment for the SettingsActivity to display.
 */
public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }

}