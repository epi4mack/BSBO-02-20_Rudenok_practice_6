package ru.mirea.rudenok.employeedb;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import ru.mirea.rudenok.employeedb.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppDatabase db = App.getInstance().getDatabase();
        SuperheroDao superheroDao = db.employeeDao();

        binding.Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.editTextText4.getText().toString();
                String superheroname = binding.editTextText5.getText().toString();
                String superpower = binding.editTextText6.getText().toString();

                Superhero superhero = new Superhero();

                superhero.name = name;
                superhero.superheroname = superheroname;
                superhero.superpower = superpower;
                superheroDao.insert(superhero);

            }
        });

        binding.Load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Superhero superhero = new Superhero();
                int id = Integer.parseInt(binding.editTextText7.getText().toString());
                superhero = superheroDao.getById(id);

                Toast.makeText(MainActivity.this,superhero.name + " " + superhero.superpower, Toast.LENGTH_SHORT).show();
            }

        });


        //superhero.id = 1;

        //superheroDao.insert(superhero);

        //List<Superhero> superheroes = superheroDao.getAll();

//        superhero = superheroDao.getById(1);
//        superhero.superpower = "Eye lasers";
//        superheroDao.update(superhero);
        //Log.d("rudenok", superhero.name + " " + superhero.superpower);
    }
}