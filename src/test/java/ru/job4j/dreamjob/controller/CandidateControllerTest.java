package ru.job4j.dreamjob.controller;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import ru.job4j.dreamjob.model.Candidate;
import ru.job4j.dreamjob.service.CandidateService;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CandidateControllerTest {

    @Test
    public void when1() throws IOException {
        Candidate candidate = new Candidate(
                0, "cand_1", "desc_1", LocalDateTime.now(), new byte[0]
        );

        CandidateService service = mock(CandidateService.class);
        CandidateController controller = new CandidateController(
                service
        );
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "hello.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "Hello, World!".getBytes()
        );
        String str = controller.addCandidate(candidate, file);
        verify(service).add(candidate);
        assertThat(str, is("redirect:/candidates"));
    }

}