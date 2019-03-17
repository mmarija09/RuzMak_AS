package com.example.marijampipsem.rm_3;

import android.util.Log;

import java.io.Serializable;
import java.util.Random;

import static android.content.ContentValues.TAG;

/**
 * Created by Sime on 6/11/2018.
 */

public class generateRandomNumber implements Serializable {

    private static final long serialVersionUID = 1L;
    public int[] number = new int[4];
    public Random random = new Random();
    public int n;

    public generateRandomNumber()
    {
        this.GenerateNumber();
    }

    public void GenerateNumber() {
        number[0] = random.nextInt(9) + 1;
        int tmp;

        do {
            tmp = random.nextInt(9) + 1;
            number[1] = tmp;

        }
        while (!(tmp != number[0]));
        do {
            tmp = random.nextInt(9) + 1;
            number[2] = tmp;

        }
        while (!(tmp != number[0] && tmp != number[1]));
        do {
            tmp = random.nextInt(9) + 1;
            number[3] = tmp;

        }
        while (!(tmp != number[0] && tmp != number[1] && tmp != number[2]));

        n = number[0] * 1000 + number[1] * 100 + number[2] * 10 + number[3];

    }
    public int getNumb() {
        return n;

    }


}
