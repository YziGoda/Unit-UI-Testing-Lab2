package com.example.labtwo;

import org.junit.Test;

import static org.junit.Assert.*;

import android.view.View;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest
{
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void Test_Count_Symbols()
    {
        TextCounter tc = new TextCounter();
        assertEquals(0, tc.countSymbols(""));
        assertEquals(1, tc.countSymbols(","));
        assertEquals(5, tc.countSymbols("Hello"));
        assertEquals(9, tc.countSymbols("!@%@4ss32"));
        assertEquals(12, tc.countSymbols("aAa 999 !@# 2^8"));
    }

    @Test
    public void Test_Count_Words()
    {
        TextCounter tc = new TextCounter();
        assertEquals(0, tc.countWords(""));
        assertEquals(0, tc.countWords(","));
        assertEquals(2, tc.countWords("Hello World!"));
        assertEquals(1, tc.countWords("@!#%!^#!#!%@"));
        assertEquals(5, tc.countWords("AaA 333 !@#$ 9asd2 s5^126as"));
        assertEquals(3, tc.countWords("TETTE1\nTETE2 TESTTEW"));
    }
}

