package com.power.likelion.service;

import com.power.likelion.common.exception.AuthorMismatchException;
import com.power.likelion.domain.board.Board;
import com.power.likelion.domain.board.Comment;
import com.power.likelion.domain.member.Member;
import com.power.likelion.dto.board.CommentResDto;
import com.power.likelion.dto.question.AnswerReqDto;
import com.power.likelion.repository.BoardRepository;
import com.power.likelion.repository.CommentRepository;
import com.power.likelion.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public CommentResDto createComment(Long id, AnswerReqDto answerReqDto)throws Exception{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName(); /** 이메일이 들어감 */

        Member member=memberRepository.findByEmail(name)
                .orElseThrow(()->new Exception("유저가 존재하지 않습니다."));
        Board board= boardRepository.findById(id)
                .orElseThrow(()->new Exception("게시글이 존재하지 않습니다."));


        //일단 댓글 정보를 Entity로 바꿔야함
        Comment comment=Comment.builder()
                .content(answerReqDto.getContent())
                .member(member)
                .board(board)
                .build();


        return CommentResDto.builder()
                .comment(commentRepository.save(comment))
                .build();

    }
    @Transactional
    public List<CommentResDto> getComments(Long id) {
        List<Comment> comments = commentRepository.findByBoardId(id);
        List<CommentResDto> commentResDtos=new ArrayList<>();
        comments.forEach(o -> commentResDtos.add(new CommentResDto(o)));
        return commentResDtos;
    }

    @Transactional
    public CommentResDto updateComment(Long id, AnswerReqDto answerReqDto)throws NullPointerException, AuthorMismatchException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();

        Comment comment=commentRepository.findById(id)
                .orElseThrow(()-> new NullPointerException("해당 댓글이 존재하지 않습니다."));

        String writer=comment.getMember().getEmail();
        if(!writer.equals(name)){
            throw new AuthorMismatchException("작성자가 아닙니다.");
        }

        comment.update(answerReqDto);

        return CommentResDto.builder()
                .comment(comment)
                .build();

    }

    @Transactional
    public void deleteComment(Long id)throws Exception{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();

        Comment comment = commentRepository.findById(id)
                .orElseThrow(()-> new Exception("댓글이 존재하지 않습니다."));

        if(!name.equals(comment.getMember().getEmail())){
            throw new Exception("댓글 작성자가 아닙니다.");
        }

        commentRepository.delete(comment);
    }

}
