package com.demo.controller.word;

import com.demo.entity.Comment;
import com.demo.entity.Word;
import com.demo.exception.IllegalParameterException;
import com.demo.exception.IncorrectParamsException;
import com.demo.exception.ParamsLackException;
import com.demo.po.WordInfo;
import com.demo.service.CommentService;
import com.demo.service.WordService;
import com.demo.utils.ResponseTemplate;
import com.demo.utils.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author admin
 * @Title: NoteController
 * @ProjectName note
 * @Description: TODO
 * @date 2021/3/1517:00
 */
@RestController
public class WordController {
    @Autowired
    private WordService wordService;
    @Autowired
    private CommentService commentService;

    /**
     * 添加新的文档
     *
     * @param word
     * @return
     */
    @PostMapping(value = "/word")
    public ResponseTemplate addWord(Word word) {
        ResponseTemplate response = new ResponseTemplate();
        if (!StringUtils.hasText(word.getTitle())) {
            return response.setResponseTemplate(StatusEnum.FAILED, "标题名称不能为空");
        }

        word.setCreateTime(new Date());
        word.setId(0);
        int var1 = wordService.insert(word);
        if (var1 == 0) {
            return response.setResponseTemplate(StatusEnum.FAILED, "添加文档失败！");
        }
        return response.setResponseTemplate("添加文档成功！");
    }

    /**
     * 删除文档
     *
     * @param id
     * @return
     */
    @DeleteMapping("/word")
    public ResponseTemplate deleteWord(Integer id) {
        ResponseTemplate response = new ResponseTemplate();
        Word word = new Word();
        word.setId(id);
        int i = wordService.delete(word);
        if (i == 0) {
            return response.setResponseTemplate(StatusEnum.FAILED, "删除失败！");
        }
        return response.setResponseTemplate("删除成功！");
    }

    /**
     * 修改文档（标题，内容）
     *
     * @param word
     * @return
     */
    @PutMapping("/word")
    public ResponseTemplate updateTitle(Word word) {
        ResponseTemplate response = new ResponseTemplate();
        if (word.getId() == 0) {
            throw new ParamsLackException("缺少参数id: id=0");
        }

        if (word.getTitle() != null) {
            if (!StringUtils.hasText(word.getTitle())) {
                throw new IncorrectParamsException("文档标题不能设置为空");
            }
        }

        int i = wordService.update(word);
        if (i == 0) {
            return response.setResponseTemplate(StatusEnum.FAILED, "修改失败");
        }
        return response.setResponseTemplate("修改成功");
    }

    /**
     * 为文章添加一条评论
     *
     * @return
     */
    @RequestMapping(value = "/word/comment", method = RequestMethod.POST)
    public ResponseTemplate addCommentForWord(Comment comment) {
        ResponseTemplate response = new ResponseTemplate();
        comment.setCreateTime(new Date());
        int i = commentService.addComment(comment);
        return response;
    }

    /**
     * 查找所有评论
     *
     * @return
     */
    @RequestMapping(value = "/word/comments", method = RequestMethod.GET)
    public ResponseTemplate getAllComment(int wordId) {
        ResponseTemplate response = new ResponseTemplate();
        List list = commentService.getAllComment(wordId);
        response.setResponseTemplate(list);
        return response;
    }

    /**
     * 查找评论的回复
     *
     * @param commentId
     * @return
     */
    @RequestMapping(value = "word/comment/reply", method = RequestMethod.GET)
    public ResponseTemplate getAnswer(int commentId) {
        ResponseTemplate response = new ResponseTemplate();
        Comment reply = commentService.getAnswer(commentId);
        response.setResponseTemplate(reply);
        return response;
    }

    /**
     * 按标题模糊查询
     *
     * @param condition
     * @return
     */
    @GetMapping(value = "/word", params = "condition")
    public ResponseTemplate getWordByCondition(String condition) {
        if (condition.equals("")) {
            condition = null;
        }
        ResponseTemplate response = new ResponseTemplate();
        List<WordInfo> wordList = wordService.findWordByTitle(condition);
        response.setResponseTemplate(wordList);
        return response;
    }

    /**
     * 查询某一类别下的文档信息
     *
     * @param category
     * @return
     */
    @GetMapping(value = "/word", params = "category")
    public ResponseTemplate getWordByCategory(String category) {
        ResponseTemplate response = new ResponseTemplate();
        if (StringUtils.isEmpty(category)) {
            throw new IllegalParameterException("不合法的参数！");
        }
        List<WordInfo> wordInfoList = wordService.findWordByCategory(category);
        return response.setResponseTemplate(wordInfoList);
    }

    /**
     * 查询用户某个类别下的文档
     *
     * @param username
     * @param category
     * @return
     */
    @GetMapping(value = "/word", params = "username, category")
    public ResponseTemplate getWordByUsernameAndCategory(String username, String category) {
        ResponseTemplate response = new ResponseTemplate();
        List<WordInfo> wordInfoList = wordService.findWordByUsernameAndCategory(username, category);
        return response.setResponseTemplate(wordInfoList);
    }
}
