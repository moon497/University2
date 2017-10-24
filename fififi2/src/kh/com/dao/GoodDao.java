package kh.com.dao;

import java.util.List;

import kh.com.model.GoodDto;
import kh.com.model.Post;

public interface GoodDao {
	
	/*					CREATE					*/
	boolean insertGood(GoodDto good);
	
	/*					READ					*/
	GoodDto getGood(int seq);
	List<GoodDto> getGoodList(GoodDto good);
	int getTotalBbs(String boardName);
	
	/*					UPDATE					*/
	boolean updateBbs(Post bbs);

	/*					DELETE					*/
	boolean deleteGood(int seq);

}
