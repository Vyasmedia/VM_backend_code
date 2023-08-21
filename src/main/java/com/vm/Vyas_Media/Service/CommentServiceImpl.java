package com.vm.Vyas_Media.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vm.Vyas_Media.Entity.Comment;
import com.vm.Vyas_Media.Entity.Post;
import com.vm.Vyas_Media.Exception.ResourceNotFoundException;
import com.vm.Vyas_Media.Payload.CommentDto;
import com.vm.Vyas_Media.Repository.CommentRepo;
import com.vm.Vyas_Media.Repository.PostRepo;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private CommentRepo commentRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {

		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "post id ", postId));

		Comment comment = this.modelMapper.map(commentDto, Comment.class);

		comment.setPost(post);

		Comment savedComment = this.commentRepo.save(comment);

		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {

		Comment com = this.commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("Comment", "CommentId", commentId));
		this.commentRepo.delete(com);
	}
	

	@Override
	public List<CommentDto> getCommnets() {

		List<Comment> categories = this.commentRepo.findAll();
		List<CommentDto> catDtos = categories.stream().map((cat) -> this.modelMapper.map(cat, CommentDto.class))
				.collect(Collectors.toList());

		return catDtos;
	}
	
}
