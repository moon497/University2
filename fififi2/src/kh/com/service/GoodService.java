package kh.com.service;

import java.util.List;

import kh.com.model.GoodDto;
import kh.com.model.Post;

public interface GoodService {
	
	/*					CREATE					*/
	boolean insertGood(GoodDto good);
	
	/*					READ					*/
	List<GoodDto> getGoodList(GoodDto good);
	GoodDto getGood(int seq);
	int getTotalBbs(String boardName);
	
	/*					UPDATE					*/
	boolean updateBbs(Post bbs);

	/*					DELETE					*/
	boolean deleteGood(int seq);

}
