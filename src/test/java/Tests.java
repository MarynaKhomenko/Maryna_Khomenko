import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Tests{
    @Test
    public void task1_1(){
        final ArrayList output = Functions.getIntegersFromList(Arrays.asList(1, 2 ,'a', 'b', 0, 15));
        final List<Integer> expected = Arrays.asList(1, 2, 0, 15);
        assertEquals(expected, output);
    }

    @Test
    public void task1_2(){
        final ArrayList output = Functions.getIntegersFromList(Arrays.asList(1, 3 ,'a', "aba", '1', "123", 131));
        final List<Integer> expected = Arrays.asList(1, 3, 131);
        assertEquals(expected, output);
    }

    @Test
    public void task2_1(){
        final char output = Functions.first_non_repeating_letter("sTreSS");
        final char expected = 'T';
        assertEquals(expected, output);
    }

    @Test
    public void task2_2(){
        final char output = Functions.first_non_repeating_letter("aAbbcc");
        final char expected = ' ';
        assertEquals(expected, output);
    }

    @Test
    public void task3_1(){
        final int output = Functions.digital_root(135);
        final int expected = 9;
        assertEquals(expected, output);
    }

    @Test
    public void task3_2(){
        final int output = Functions.digital_root(173542);
        final int expected = 4;
        assertEquals(expected, output);
    }

    @Test
    public void task4_1(){
        final int output = Functions.count_pairs(new int[]{1, 3, 6, 2, 2, 0, 4, 5}, 5);
        final int expected = 4;
        assertEquals(expected, output);
    }

    @Test
    public void task4_2(){
        final int output = Functions.count_pairs_stream(new int[]{1, 2, 2, 2}, 3);
        final int expected = 3;
        assertEquals(expected, output);
    }

    @Test
    public void task4_3(){
        final int output = Functions.count_pairs(new int[]{2, 2, 3}, 6);
        final int expected = 0;
        assertEquals(expected, output);
    }

    @Test
    public void task5_1(){
        final String output = Functions.sort_friends("Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill");
        final String expected = "(CORWILL, ALFRED)(CORWILL, FRED)(CORWILL, RAPHAEL)(CORWILL, WILFRED)(TORNBULL, BARNEY)(TORNBULL, BETTY)(TORNBULL, BJON)";
        assertEquals(expected, output);
    }

    @Test
    public void task5_2(){
        final String output = Functions.sort_friends("Ingrid:Wilson;Ingrid:Wilson;John:Smith;Eren:Kruger");
        final String expected = "(KRUGER, EREN)(SMITH, JOHN)(WILSON, INGRID)(WILSON, INGRID)";
        assertEquals(expected, output);
    }
}


