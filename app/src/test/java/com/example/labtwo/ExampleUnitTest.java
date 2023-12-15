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
        assertEquals(0, TextCounter.countWords(""));
        assertEquals(1, TextCounter.countSymbols(","));
        assertEquals(5, TextCounter.countSymbols("Hello"));
        assertEquals(9, TextCounter.countSymbols("!@%@4ss32"));
        assertEquals(12, TextCounter.countSymbols("aAa 999 !@# 2^8"));

    }

    @Test
    public void Test_Count_Words()
    {
        assertEquals(0, TextCounter.countWords(""));
        assertEquals(0, TextCounter.countWords(","));
        assertEquals(2, TextCounter.countWords("Hello World!"));
        assertEquals(1, TextCounter.countWords("@!#%!^#!#!%@"));
        assertEquals(5, TextCounter.countWords("AaA 333 !@#$ 9asd2 s5^126as"));
        assertEquals(3, TextCounter.countWords("TETTE1\nTETE2 TESTTEW"));
    }
}

