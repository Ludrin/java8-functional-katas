package katas;

import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
	private static final String SEARCH_MIDDLE_MOMENT = "Middle";
	private static final String KEY_MIDDLE_MOMENT = "time";
	private static final String KEY_BOXART = "boxart";
	private static final String KEY_TITLE = "title";
	private static final String KEY_ID = "id";
	
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        
        return movieLists.stream()
    	.map(lm -> lm.getVideos())
    	.flatMap(c -> c.stream())
    	.map(m -> ImmutableMap.of(KEY_ID, m.getId(), KEY_TITLE, m.getTitle(), KEY_MIDDLE_MOMENT, m.getInterestingMoments().stream()
    			.filter(im -> SEARCH_MIDDLE_MOMENT.equals(im.getType()))
    			.findAny().get().getTime()
    			,
    			KEY_BOXART, 
    			m.getBoxarts().stream()
    			.min( (BoxArt ba1, BoxArt ba2) -> Integer.compare((ba1.getHeight() * ba1.getWidth()), (ba2.getHeight() * ba2.getWidth())) )
    			.get().getUrl()
    			))
    	.collect(Collectors.toList());
    }
}
