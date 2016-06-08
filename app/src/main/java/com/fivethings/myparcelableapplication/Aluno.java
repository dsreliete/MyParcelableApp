package com.fivethings.myparcelableapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by eliete on 3/10/16.
 */
public class Aluno implements Parcelable{

    public String aula;
    public String nome;

    public Aluno() {

    }

    public Aluno (String aula, String nome){
        this.nome = nome;
        this.aula = aula;
    }

    //Constructor to use when re-constructing object from a parcel
    public Aluno(Parcel in){
        aula = in.readString();
        nome = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // Using the `in` variable, we can retrieve the values that
    // we originally wrote into the `Parcel`.  This constructor is usually
    // private so that only the `CREATOR` field can access.
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(aula);
    }


    // After implementing the `Parcelable` interface, we need to create the
    // `Parcelable.Creator<> CREATOR` constant for our class;
    // Notice how it has our class specified as its type.
    public static final Parcelable.Creator<Aluno> CREATOR
            = new Parcelable.Creator<Aluno>() {

        // This simply calls our new constructor (typically private) and 
        // passes along the unmarshalled `Parcel`, and then returns the new object!
        @Override
        public Aluno createFromParcel(Parcel in) {
            return new Aluno(in);
        }

        // We just need to copy this and change the type to match our class.
        @Override
        public Aluno[] newArray(int size) {
            return new Aluno[size];
        }
    };

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
