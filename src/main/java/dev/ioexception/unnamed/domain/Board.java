package dev.ioexception.unnamed.domain;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String boardCode;
    String boardName;

    public Board(String boardCode, String boardName) {
        this.boardCode = boardCode;
        this.boardName = boardName;
    }

    public Board() {
    }
}
