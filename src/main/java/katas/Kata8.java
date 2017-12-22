package katas;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Combine videos and bookmarks by index (StreamUtils.zip) (https://github.com/poetix/protonpack)
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("videoId", "5", "bookmarkId", "3")
*/
public class Kata8 {
    private static final String KEY_BOOKMARK_ID = "bookmarkId";
	private static final String KEY_VIDEO_ID = "videoId";

	public static List<Map> execute() {
        List<Movie> movies = DataUtil.getMovies();
        List<Bookmark> bookMarks = DataUtil.getBookMarks();
        
        return StreamUtils
        		.zip(
        			movies.stream(), bookMarks.stream(),
        			(m, b) -> ImmutableMap.of(KEY_VIDEO_ID, m.getId(), KEY_BOOKMARK_ID, b.getId()) )//end zip
           .collect(Collectors.toList());
    }
}
