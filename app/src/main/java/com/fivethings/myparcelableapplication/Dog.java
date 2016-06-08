package com.fivethings.myparcelableapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by eliete on 3/10/16.
 */
public class Dog extends Animal implements Parcelable {

    public int age;
    public Animal animal;

    public Dog(){}

    public Dog(Parcel from){
        age = from.readInt();
        animal = from.readParcelable(Animal.class.getClassLoader());

    }

    public Dog(int age, Animal a) {
        this.animal = a;
        this.age = age;
    }

    public String getAnimalNome() {
        return animal.getNome();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(age);
        dest.writeParcelable(animal, flags);
    }

    public static final Parcelable.Creator<Dog> CREATOR
            = new Parcelable.Creator<Dog>() {

        // This simply calls our new constructor (typically private) and
        // passes along the unmarshalled `Parcel`, and then returns the new object!
        @Override
        public Dog createFromParcel(Parcel in) {
            return new Dog(in);
        }

        // We just need to copy this and change the type to match our class.
        @Override
        public Dog[] newArray(int size) {
            return new Dog[size];
        }
    };
}
