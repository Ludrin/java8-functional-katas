package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();
        		
        return movies.stream()
		.map(m -> m.getBoxarts())
		.flatMap(c -> c.stream())
		.reduce((ba1, ba2) -> (ba1.getHeight() * ba1.getWidth()) > (ba2.getHeight() * ba2.getWidth()) ? ba1:ba2)
		.get().getUrl();
    }
}
