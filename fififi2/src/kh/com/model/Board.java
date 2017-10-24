package kh.com.model;

import java.util.HashMap;
import java.util.Map;

public class Board {
	
	private Map<String, Integer> boards;
	
	public Board() {
		//init
		boards = new HashMap<>();
		
		//data
		boards.put("notice", 1);
		boards.put("today", 2);
		boards.put("free", 3);
	}

	public Map<String, Integer> getBoards() {
		return boards;
	}
	
	public Integer getBoardSeq(String key) {
		return boards.get(key);
	}
	
	public boolean containsKey(String key) {
		return boards.containsKey(key);
	}

	@Override
	public String toString() {
		return "Board [boards=" + boards + "]";
	}
	

}
