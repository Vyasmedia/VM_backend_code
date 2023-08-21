package com.vm.Vyas_Media.Service;

import java.util.List;
import com.vm.Vyas_Media.Payload.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto, Integer postId);

	void deleteComment(Integer commentId);
	
	List<CommentDto> getCommnets();

}
