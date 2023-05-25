package ru.mirea.rudenok.practice6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import ru.mirea.rudenok.practice6.databinding.ActivityMainBinding;
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences SP = getSharedPreferences("mysettings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = SP.edit();

        if(!SP.getString("group", "unknown").equals("unknown") || !SP.getString("number", "unknown").equals("unknown") || !SP.getString("series", "unknown").equals("unknown"))
        {
            binding.editTextText.setText(SP.getString("group", "unknown"));
            binding.editText2.setText(SP.getString("number", "unknown"));
            binding.editText3.setText(SP.getString("series", "unknown"));
        }

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("group", binding.editTextText.getText().toString());
                editor.putString("number", binding.editText2.getText().toString());
                editor.putString("series", binding.editText3.getText().toString());
                editor.apply();
            }
        });
    }
}