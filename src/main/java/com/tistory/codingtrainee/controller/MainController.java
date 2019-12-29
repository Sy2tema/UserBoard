package com.tistory.codingtrainee.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tistory.codingtrainee.model.dto.ProductDTO;

// Controller어노테이션을 반드시 붙여놔야 Spring이 서버에 자동으로 적재시키라는 신호를 줄 수 있게 된다.
@Controller
public class MainController {
	public static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	// 홈으로 이동하기
	// Model은 데이터를 담는 그릇으로 map구조로 이루어져 있다.
	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("message", "페이지 방문을 환영합니다.");
		
		// servlet-context.xml을 통해 미리 문자열을 입력해놓은 결과 아래와 같은 반환값을 작성해도
		// /WEB-INF/views/<리턴값>.jsp로 이루어진 결과를 얻을 수 있다.
		return "main";
	}
	
	// HttpServletRequest를 사용할 필요 없이 필요한 자료형을 입력해준다면 자동으로 형변환까지 완료된다.
	// 이 때 해당 변수의 앞에는 @RequestParam이라는 어노테이션이 포함되어 있다는 것을 기억해두자
	@RequestMapping(value = "gugudan.do", method = RequestMethod.GET)
	public String gugudan(@RequestParam(defaultValue = "3") int number, Model model) {
		
		String result = "";
		for (int index = 1; index <= 9; index++) {
			result += number + " X " + index + " = " + number * index + "<br>";
		}
		model.addAttribute("result", result);
		
		return "test/gugudan";
	}
	
	// 반환 타입이 void인 경우 url name과 같은 페이지로 포워딩된다. (메소드 이름과는 관계 없다.)
	@RequestMapping("test")
	public void test() {
	}
	
	@RequestMapping("test/doA")
	public String doA(Model model) {
		logger.info("doA()메소드가 호출되었습니다.");
		model.addAttribute("message", "doA를 통해 전달되어 온 메시지가 포함되어 있습니다.");
		
		// forward는 주소가 바뀌지 않고 그저 jsp페이지로 값을 보내는 것이다
		return "test/doB";
	}
	
	@RequestMapping("test/doB")
	public void doB(Model model) {
		logger.info("doB()메소드가 호출되었습니다.");
		// 메소드가 종료된 후에는 doB.jsp로 포워딩된다.
	}
	
	// ModelAndView : Model은 데이터 저장소이며 View는 출력해주는 화면이다.
	// 데이터와 포워드할 페이지의 정보
	// forward : 주소는 그대로이며 화면을 전환한다. 또한 대량의 데이터를 전달할 수 있다.
	// redirect : 주소가 바뀌며 화면을 전환한다. 소량의 데이터를 GET방식으로 전달한다.
	@RequestMapping("test/doC")
	public ModelAndView doC() {
		Map<String, Object> map = new HashMap<>();
		
		// Map에 객체를 저장시킨다.
		map.put("product", new ProductDTO("샤프", 12000));
		
		// ModelAndView에는 변수를 하나밖에 전달할 수 없기 때문에 map을 통해서 여러 값을 전송하는 방식을 주로 사용하게 된다
		return new ModelAndView("test/doC", "map", map);
	}
	
	@RequestMapping("test/doD")
	public String doD() {
		// redirect는 출력이 목적이 아니라 페이지를 전환시키려 하는 명령으로 반환 타입을 문자열로 설정해야 한다.
		// doE.jsp로 보내지며 주소가 doD에서 doE로 바뀐다
		return "redirect:/test/doE";
		// return "redirect:/hello.jsp";와 같은 의미를 가진다.
	}
	
	@RequestMapping("test/doE")
	public void doE() {
	}
}
