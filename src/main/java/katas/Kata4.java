package katas;

import com.google.common.collect.ImmutableMap;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve id, title, and a 150x200 box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": BoxArt)
*/
public class Kata4 {
	private static final String KEY_BOXART = "boxart";
	private static final String KEY_TITLE = "title";
	private static final String KEY_ID = "id";
    
	public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        
        return movieLists.stream()
    	.map(lm -> lm.getVideos())
    	.flatMap(c -> c.stream())
    	.map(m -> ImmutableMap.of(KEY_ID, m.getId(), KEY_TITLE, m.getTitle(), KEY_BOXART, 
    			m.getBoxarts().stream()
    			.filter(line -> 150 == line.getWidth())
    			.findAny().get().getUrl()
    			))
    	.collect(Collectors.toList());
    }
}
