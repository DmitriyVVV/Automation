package lesson9;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Dmitriy on 15.05.2017.
 */
public class Movie implements Comparable{
    public double score;
    public String title;

    @Override
    public int compareTo(Object o){
        Movie m= (Movie)o;
        return (score<m.score) ?-1:((score==m.score)?0:1);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "score=" + score +
                ", title='" + title + '\'' +
                '}';
    }

    public Movie(String title, double score){
        this.title = title;
        this.score = score;
    }


}


