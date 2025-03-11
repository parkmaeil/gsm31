package kr.gsm.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller  // View를 넘겨주는
//@RestController // JSON
public class BoardController { // 객체생성(new BoardController())
   // 게시판 전체 리스트 보기 요청(URL)
   // HandlerMapping
   //  /boardList(요청)-->BoardController : boardList()
   @GetMapping("/boardList")
   public String boardList(Model model){
       //DB에서 게시판 정보를 가져오기...
       //과일이름 3개만 저장
       List<String> fList=new ArrayList<>();
       fList.add("자바");
       fList.add("오라클");
       fList.add("박매일");
       // 객체바인딩                    번지(100번지)----->
       model.addAttribute("fList",fList);
       return "boardList"; // /resources/templates/boardList.html
   }
}
