package katas;

import com.google.common.collect.ImmutableMap;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/
public class Kata1 {
    private static final String KEY_TITLE = "title";
	private static final String KEY_ID = "id";

	@SuppressWarnings("rawtypes")
	public static List<Map> execute() {
        List<Movie> movies = DataUtil.getMovies();
        
        return movies.stream().map(
        		m -> ImmutableMap.of(KEY_ID, m.getId(), KEY_TITLE, m.getTitle())
        ).collect(Collectors.toList());
    }
}
