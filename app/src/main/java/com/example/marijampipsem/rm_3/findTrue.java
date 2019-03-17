package com.example.marijampipsem.rm_3;

/**
 * Created by Sime on 6/11/2018.
 */

public class findTrue {
    private static final long serialVersionUID = 1L;

    private int t_true;
    //generateRandomNumber grn = new generateRandomNumber();
    public findTrue()
    {
        //this.checkRuz(numero);
    }

    public int checkRuz(int exp , int generated)
    {
        t_true = 0;
        int check[] = new int[4];
        int gen[] = new int[4];

        for(int i = 3 ; i >= 0 ; i--)
        {
            check[i] = exp % 10;
            exp /= 10;
        }

        for(int i = 3 ; i >= 0 ; i--)
        {
            gen[i] = generated % 10;
            generated /= 10;
        }
        for(int i = 0 ; i < 4 ; i++)
        {
            if(check[i] == gen[i])
            {
                t_true++;
            }
        }
        return t_true;
    }


}
