package org.zerock.guestbook.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.guestbook.entity.Guestbook;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long>{
}
