package com.example.marijampipsem.rm_3;

public class checkFoZeroes {

    private static final long serialVersionUID = 1L;
    private int zero = 0;

    public checkFoZeroes()
    {

    }

    public boolean checkZeroes(int exp)
    {
        int check[] = new int[4];
        for(int i = 3 ; i >= 0 ; i--)
        {
            check[i] = exp % 10;
            exp /= 10;
        }

        for(int i = 0 ; i < 4 ; i++)
        {
            if(check[i] == 0)
            {
                zero++;
            }
        }
        if(zero > 0)
        {
            return true;
        }
        else
            return false;
    }
}
