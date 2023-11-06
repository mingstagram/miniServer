package com.mini.miniServer.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class CommonScheduler {
	
	/*
	 *  - 크론(Cron) 표현식 예시
	 *  1. "0 0 0 * * *" : 매일 자정에 실행됩니다. (시, 분, 초가 0인 경우)
	 *  2. "0 0 12 * * ?": 매일 정오(12:00:00)에 실행됩니다. (매일 12시)
	 *  3. "0 0/15 * * * ?": 15분 간격으로 실행됩니다. (매 시, 매 분의 0초부터 시작하여 15분 간격으로)
	 *  4. "0 30 9 ? * MON-FRI": 평일(월요일부터 금요일까지) 아침 9:30:00에 실행됩니다.
	 *  5. "0 0 0 1 * ?": 매월 1일 자정에 실행됩니다. (매월 1일)
	 *  6. "0 0 12 1/2 * ?": 매월 짝수 달의 1일 정오(12:00:00)에 실행됩니다. (2달마다 1일)
	 *  7. "0 0 0 ? 3 6L": 3월의 마지막 금요일 자정에 실행됩니다.
	 *  8. "0 0/5 * * * ?": 5분 간격으로 실행됩니다. (매 시, 매 분의 0초부터 시작하여 5분 간격으로)
	 *  9. "0 0 0 ? 1/3 WED": 매 3달마다 첫 번째 수요일 자정에 실행됩니다.
	 */
	
	@Scheduled(cron = "0 0 0 * * *")
	public void common() {
		log.info("common schedule ");
	}

}
