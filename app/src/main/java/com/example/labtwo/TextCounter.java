package com.example.labtwo;

public class TextCounter
{
    public static int countSymbols(String phrase)
    {
        int  result = 0;

        for (int i=0; i<phrase.length();i++)
        {
            char c = phrase.charAt(i); //isskaidom indexais
            if(!Character.isWhitespace(c)) // patikrinam ar nera whitespace char
            {
                result++;
            }
        }
        return result;
    }

    public static int countWords(String phrase)
    {
        phrase = phrase.replace("/n", " "); //jei butu newline pakeistu i space
        String[] words = phrase.split("[\\s,\\.]"); // atskiriami tarpais, kableliais, taskais

        int result = 0;
        for (String word : words) //ciklas suskirsto is word array ir priskira word element
        {
            if(!word.isEmpty()) //ar elementas word ne tuscias
            {
                result++;
            }
        }
        return result;
    }
}
