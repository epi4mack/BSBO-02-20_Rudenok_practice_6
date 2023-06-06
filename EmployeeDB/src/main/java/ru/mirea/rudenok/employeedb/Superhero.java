package ru.mirea.rudenok.employeedb;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Superhero {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String superheroname;
    public String name;
    public String superpower;
}