package com.example.diego.realmalumnos.models;

import com.example.diego.realmalumnos.application.MyApplication;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Person extends RealmObject {
    @PrimaryKey
    private int Id;
    private String Name;

    public Person() {} // Only for Realm

    public Person(String name) {
    //    Id = MyApplication.PersonID.incrementAndGet();
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


}