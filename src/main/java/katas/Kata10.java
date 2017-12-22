package katas;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.MovieList;
import util.DataUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Create a datastructure from the given data:

    We have 2 arrays each containing lists, and videos respectively.
    Each video has a listId field indicating its parent list.
    We want to build an array of list objects, each with a name and a videos array.
    The videos array will contain the video's id and title.
    In other words we want to build the following structure:

    [
        {
            "name": "New Releases",
            "videos": [
                {
                    "id": 65432445,
                    "title": "The Chamber"
                },
                {
                    "id": 675465,
                    "title": "Fracture"
                }
            ]
        },
        {
            "name": "Thrillers",
            "videos": [
                {
                    "id": 70111470,
                    "title": "Die Hard"
                },
                {
                    "id": 654356453,
                    "title": "Bad Boys"
                }
            ]
        }
    ]

    DataSource: DataUtil.getLists(), DataUtil.getVideos()
    Output: the given datastructure
*/
public class Kata10 {
    private static final String KEY_TITLE = "title";
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";

	public static List<Map> execute() {
        List<Map> lists = DataUtil.getLists();
        List<Map> videos = DataUtil.getVideos();
        
        return lists.stream().map(
        		l -> ImmutableMap.of(KEY_NAME, l.get(KEY_NAME), "videos", videos.stream().filter(v -> l.get(KEY_ID).equals(v.get("listId")) )
        				.map(vf -> ImmutableMap.of(KEY_ID, vf.get(KEY_ID), KEY_TITLE, vf.get(KEY_TITLE)))
        				.collect(Collectors.toList())
        				)//end map
        		)//end map
        		.collect(Collectors.toList());
    }
}
