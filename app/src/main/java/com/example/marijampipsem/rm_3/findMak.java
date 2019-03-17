package com.example.marijampipsem.rm_3;

/**
 * Created by Sime on 6/11/2018.
 */

public class findMak {

    private static final long serialVersionUID = 1L;
    private int h_true;
    //generateRandomNumber grn = new generateRandomNumber();

    public findMak()
    {

    }
    public int checkMak(int exp , int generated)
    {
        h_true = 0;
        int [] check = new int[4];
        int gen[] = new int[4];


        for(int i = 3 ; i >= 0 ; i--)
        {
            check[i] = exp % 10;
            exp  /= 10;
        }


        for(int i = 3 ; i >= 0 ; i--)
        {
            gen[i] = generated % 10;
            generated /= 10;
        }

        for (int i = 0; i < 4;i++ )
        {
            for (int j = 0; j < 4; j++)
            {
                if (check[i] == gen[j])
                {
                    if( i != j )
                    {
                        h_true++;
                    }
                }
            }

        }
        return h_true;
    }


}
