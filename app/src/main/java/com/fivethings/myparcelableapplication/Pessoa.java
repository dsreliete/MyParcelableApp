package com.fivethings.myparcelableapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by eliete on 3/10/16.
 */
public class Pessoa implements Parcelable {

    public String nome;

    public Pessoa(){}

    public Pessoa(Parcel from){
        nome = from.readString();

    }

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
    }

    public static final Parcelable.Creator<Pessoa> CREATOR
            = new Parcelable.Creator<Pessoa>() {

        // This simply calls our new constructor (typically private) and
        // passes along the unmarshalled `Parcel`, and then returns the new object!
        @Override
        public Pessoa createFromParcel(Parcel in) {
            return new Pessoa(in);
        }

        // We just need to copy this and change the type to match our class.
        @Override
        public Pessoa[] newArray(int size) {
            return new Pessoa[size];
        }
    };
}
