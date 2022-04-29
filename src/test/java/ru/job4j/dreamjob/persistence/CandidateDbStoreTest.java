package ru.job4j.dreamjob.persistence;

import org.junit.Test;
import ru.job4j.dreamjob.Main;
import ru.job4j.dreamjob.model.Candidate;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CandidateDbStoreTest {
    @Test
    public void whenCreateCandidate() {
        CandidateDbStore store = new CandidateDbStore(new Main().loadPool());
        Candidate candidate = new Candidate(
                0, "Candidate Junior Name", "Junior skills",
                LocalDateTime.now(), new byte[0]
        );
        store.add(candidate);
        Candidate candidateInDB = store.findById(candidate.getId());
        assertThat(candidateInDB.getName(), is(candidate.getName()));
    }

    @Test
    public void whenUpdateCandidate() {
        CandidateDbStore store = new CandidateDbStore(new Main().loadPool());
        Candidate candidate = new Candidate(
                0, "Candidate Junior Name", "Junior skills",
                LocalDateTime.now(), new byte[0]
        );
        store.add(candidate);
        Candidate update = new Candidate(
                candidate.getId(), "Candidate Senior Name", "Senior skills",
                candidate.getCreated(), new byte[0]
        );
        store.update(update);
        Candidate candidateInDB = store.findById(candidate.getId());
        assertThat(candidateInDB.getName(), is(update.getName()));
    }
}