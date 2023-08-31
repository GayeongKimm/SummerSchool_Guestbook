package org.zerock.guestbook.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_guestbook")
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
public class Guestbook extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gno;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 200, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;

    public void changeTitle(String title){
        this.title = title;
    }

    public void changeContent(String content) {
        this.content = content;
    }



}