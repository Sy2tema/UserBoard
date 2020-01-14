package com.tistory.codingtrainee.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// 로그 처리를 위한 advice클래스
// 각각 스프링에서 관리하는 bean과 aop bean임을 뜻하는 어노테이션
@Component
@Aspect
public class LogAdvice {
	private static final Logger logger = LoggerFactory.getLogger(LogAdvice.class);
	
	// 컨트롤러, 서비스, DAO패키지 내의 설정한 이름이 포함된 클래스들에 적용되도록 설정해주었다
	@Around(
		"execution(* com.tistory.codingtrainee.controller..*Controller.*(..))"
		+ " or execution(* com.tistory.codingtrainee.service..*Impl.*(..))"
		+ " or execution(* com.tistory.codingtrainee.model..dao.*Impl.*(..))")
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		
		// result변수를 기준으로 Before과 After가 나뉜다고 볼 수 있다
		Object result = joinPoint.proceed();
		
		// 클래스 이름을 표시해준다
		String type = joinPoint.getSignature().getDeclaringTypeName();
		String name = "";
		if (type.indexOf("Controller") > -1) {
			name = "Controller \t: ";
		} else if (type.indexOf("Service") > -1) {
			name = "ServiceImpl \t: ";
		} else if (type.indexOf("DAO") > -1) {
			name = "DAOImpl \t: ";
		}
		
		// 메소드 이름을 표시해준다
		logger.info(name + type + "." + joinPoint.getSignature().getName());
		// 매개변수 이름을 표시해준다
		logger.info(Arrays.toString(joinPoint.getArgs()));
		
		long endTime = System.currentTimeMillis();
		long time = endTime - startTime;
		
		logger.info("Advice 실행 시간 : " + time);
		
		return result;
	}
}
