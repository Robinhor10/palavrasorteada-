package com.api.palavrasorteada.service;

import com.api.palavrasorteada.model.Word;
import com.api.palavrasorteada.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordService {

    private final WordRepository wordRepository;

    public WordService(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    public Word getRandomWord() {
        return wordRepository.findRandomWord();
    }
}
