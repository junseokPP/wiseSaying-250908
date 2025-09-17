package com.back.domain.service;

import com.back.domain.wiseSaying.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {


    private int lastId = 0;
    private List<WiseSaying> wiseSayings = new ArrayList<>();

    public void modify(WiseSaying wiseSaying, String newSaying, String newAuthor) {
        wiseSaying.setSaying(newSaying);
        wiseSaying.setAuthor(newAuthor);
    }

    public WiseSaying findByIdOrNull(int id) {
        return wiseSayings.stream()
                .filter(w -> w.getId() == id)
                .findFirst()
                .orElse(null);
    }


    public boolean delete(int id) {
        return wiseSayings.removeIf(w -> w.getId() == id);
    }

    public List<WiseSaying> findListDesc() {
        return wiseSayings.reversed();
    }


    public WiseSaying write(String saying, String author) {

        lastId++;
        WiseSaying wiseSaying = new WiseSaying(lastId, saying, author);
        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }
}
