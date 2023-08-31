package org.zerock.guestbook;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.guestbook.entity.Guestbook;
import org.zerock.guestbook.entity.repository.GuestbookRepository;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
class GuestbookApplicationTests {

	@Autowired
	private GuestbookRepository guestbookRepository;

	@Test
	public void insergDummies() {
		IntStream.rangeClosed(1, 300)
				.forEach(i -> {
					Guestbook guestbook = Guestbook.builder()
							.title("Title..." + i)
							.content("Content..." + i)
							.writer("user..." + i).build();
					guestbookRepository.save(guestbook);
				});
	}

	//		@Transactional
//		@Commit
	@Test
	public void updateTest() {
		Optional<Guestbook> result = guestbookRepository
				.findById(300L);
		if (result.isPresent()) {
			Guestbook guestbook = result.get();
			guestbook.changeTitle("Changed Title ...4");
			guestbook.changeContent("Change Content...3");
			guestbookRepository.save(guestbook);
		}

	}
}
