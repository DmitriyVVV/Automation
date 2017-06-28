package lesson9;

import java.util.Comparator;

/**
 * Created by Dmitriy on 15.05.2017.
 */
public class MovieComparator implements Comparator<Movie>{
    @Override
    public int compare(Movie o1, Movie o2){
        return o1.title.compareTo(o2.title);
    }
}
