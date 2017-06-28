package lesson9;

import java.util.Comparator;

/**
 * Created by Dmitriy on 15.05.2017.
 */
public class MovieScoreComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2){
        return (o1.score<o2.score)?-1:((o1.score==o2.score)?0:1);
    }
}
