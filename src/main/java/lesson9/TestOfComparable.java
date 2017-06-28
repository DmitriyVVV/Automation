package lesson9;

import lesson9.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Dmitriy on 15.05.2017.
 */
public class TestOfComparable {
    public static void main(String[] args) {
        List<Movie> list = new ArrayList<Movie>();
        list.add(new Movie("A film", 2.4));
        list.add(new Movie("B film", 2.1));
        Collections.sort(list);
        System.out.println(list);

        Collections.sort(list, new MovieComparator());
        System.out.println(list);

        Collections.sort(list, new MovieScoreComparator());
        System.out.println(list);
    }
}
