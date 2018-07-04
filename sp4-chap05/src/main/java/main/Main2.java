package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import config.JavaConfig2;

public class Main2 {
	// MemberInfoPrinter의 set 메서드에 @Autowired 적용해야 정상 동작
	public static void main(String[] args) {
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(JavaConfig2.class);
		MemberRegisterService regSvc = 
				ctx.getBean("memberRegSvc", MemberRegisterService.class);
		MemberInfoPrinter infoPrinter = 
				ctx.getBean("infoPrinter", MemberInfoPrinter.class);

		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("aaa@aaa.com");
		regReq.setName("aaa");
		regReq.setPassword("111");
		regReq.setConfirmPassword("111");
		regSvc.regist(regReq);
		
		infoPrinter.printMemberInfo("aaa@aaa.com");
	}
}
