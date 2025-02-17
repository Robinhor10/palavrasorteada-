package com.api.palavrasorteada.controller;

import com.api.palavrasorteada.model.Word;
import com.api.palavrasorteada.service.WordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sortear")
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping
    public ResponseEntity<String> getRandomWord() {
        Word word = wordService.getRandomWord();
        if (word != null) {
            return ResponseEntity.ok(word.getText());
        }else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Nenhuma palavra encontrada");
        }
    }
}
