package com.sample.foo.usingrecyclerview;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Obaro on 11/09/2016.
 */
public class Util {

    public static List<Person> getPeopleList(Context context) {
        List<Person> people = new ArrayList<Person>();

        people.add(new Person("Obaro", "Ogbo", context.getResources().getString(R.string.ogbo_role),
                context.getResources().getString(R.string.ogbo),
                ContextCompat.getDrawable(context, R.drawable.obaro)));
        people.add(new Person("Peter", "Parker", context.getResources().getString(R.string.parker_role),
                context.getResources().getString(R.string.parker),
                ContextCompat.getDrawable(context, R.drawable.parker)));
        people.add(new Person("Clark", "Kent", context.getResources().getString(R.string.kent_role),
                context.getResources().getString(R.string.kent),
                ContextCompat.getDrawable(context, R.drawable.kent)));
        people.add(new Person("Barack", "Obama", context.getResources().getString(R.string.obama_role),
                context.getResources().getString(R.string.obama),
                ContextCompat.getDrawable(context, R.drawable.obama)));
        people.add(new Person("Bruce", "Wayne", context.getResources().getString(R.string.wayne_role),
                context.getResources().getString(R.string.wayne),
                ContextCompat.getDrawable(context, R.drawable.wayne)));
        people.add(new Person("Oliver", "Queen", context.getResources().getString(R.string.queen_role),
                context.getResources().getString(R.string.queen),
                ContextCompat.getDrawable(context, R.drawable.queen)));

        Collections.shuffle(people, new Random(System.nanoTime()));
        return people;
    }

    public static  Person getRandomPerson(Context context) {
        return getPeopleList(context).get(0);
    }
}
