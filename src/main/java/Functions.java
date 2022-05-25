import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.Character.toLowerCase;

public class Functions {

    //TASK1
    static ArrayList getIntegersFromList(List list){
        ArrayList ints = new ArrayList();
        for (var v:list) {
            if(v instanceof Integer) {
                ints.add(v);
            }
        }
        return ints;
    }

    //TASK2
    static char first_non_repeating_letter(String string){
        for (int i = 0; i < string.length(); i++) {
            boolean unique = true;
            char c = toLowerCase(string.charAt(i));
            for (int j = 0; j < string.length(); j++) {
                if (i != j && c == toLowerCase(string.charAt(j))) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                return string.charAt(i);
            }
        }
        return ' ';
    }

    //TASK3
    static int digital_root(int number){
        int num = number;
        int sum = 0;
        while(num%10 > 0)
        {
            sum = (num%10) + sum;
            num = num/10;
        }

        if(sum/10 > 0)
            return digital_root(sum);
        return sum;
    }

    //TASK4.1
    static int count_pairs(int[] array, int sum){
        int pairs = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++){
                if( i!= j && array[i] + array[j] == sum)
                    pairs++;
            }
        }
        return pairs;
    }

    //TASK4.2
    static int count_pairs_stream(int[] array, int sum){
        int pairs = 0;
        for(int i = 0; i < array.length; i++) {
            int finalI = i;
            pairs += IntStream.range(finalI,  array.length)
                    .filter(j -> finalI != j && array[finalI] + array[j] == sum).count();
        }
        return pairs;
    }

    //TASK5
    static String sort_friends(String friends){
        List<Person> personList = new ArrayList<>();
        String person[];
        friends = friends.toUpperCase();
        for (String splt:friends.split(";")) {
            person = splt.split(":");
            personList.add(new Person(person[0], person[1]));
        }
        Collections.sort(personList, Comparator.comparing(Person::getSurname).thenComparing(Person::getName));
        StringBuilder friendsList = new StringBuilder();
        for (Person pers:personList) {
            friendsList.append(pers.to_string());
        }
        return friendsList.toString();
    }

    static class Person{
        private String name;
        private String surname;

        Person(String n, String s){
            this.name = n;
            this.surname = s;
        }

        String getName(){
            return name;
        }
        String getSurname(){
            return surname;
        }
        String to_string(){
            return ("(" + surname + ", " + name + ")");
        }
    }

    public static void main(String args[]){
    }
}


