package service;

import com.api.palavrasorteada.model.Word;
import com.api.palavrasorteada.repository.WordRepository;
import com.api.palavrasorteada.service.WordService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class WordServiceTest {

    @MockBean
    private WordRepository wordRepository;

    @Autowired
    private WordService wordService;

    @Test
    public void testGetRandomWord() {
        Word sampleWord = new Word("Sample word");
        sampleWord.setId(1L);

        Mockito.when(wordRepository.findRandomWord()).thenReturn(sampleWord);

        Word randomWord = wordService.getRandomWord();

        Assertions.assertNotNull(randomWord);
        Assertions.assertEquals("Sample word", randomWord.getText());
    }
}

