package com.back.domain.repository;

import com.back.domain.wiseSaying.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    private int lastId = 0;
    private List<WiseSaying> wiseSayings = new ArrayList<>();

    public WiseSaying findByIdOrNull(int id) {
        return wiseSayings.stream()
                .filter(w -> w.getId() == id)
                .findFirst()
                .orElse(null);
    }


    public boolean delete(int id) {
        return wiseSayings.removeIf(w -> w.getId() == id);
    }


    public WiseSaying save(WiseSaying wiseSaying) {

        if(wiseSaying.isNew()){
            lastId++;
            wiseSaying.setId(lastId);
            wiseSayings.add(wiseSaying);
        }
        return wiseSaying;
    }

    public List<WiseSaying> reversed() {
        return wiseSayings.reversed();
    }
}
