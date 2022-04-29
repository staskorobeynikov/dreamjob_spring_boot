package ru.job4j.dreamjob.persistence;

import org.junit.Test;
import ru.job4j.dreamjob.Main;
import ru.job4j.dreamjob.model.City;
import ru.job4j.dreamjob.model.Post;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PostDBStoreTest {
    @Test
    public void whenCreatePost() {
        PostDBStore store = new PostDBStore(new Main().loadPool());
        Post post = new Post(
                0, "Java Job", "new description",
                LocalDateTime.now(), true, new City(1, null));
        store.add(post);
        Post postInDb = store.findById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Test
    public void whenUpdatePost() {
        PostDBStore store = new PostDBStore(new Main().loadPool());
        Post post = new Post(
                0, "Middle Java Job", "new description",
                LocalDateTime.now(), true, new City(1, null));
        store.add(post);
        Post update = new Post(
                post.getId(), "Senior Java Job", "Spring Security",
                post.getCreated(), false, new City(3, null));
        store.update(update);
        Post postInDb = store.findAll().get(0);
        assertThat(postInDb.getName(), is(update.getName()));
        assertThat(postInDb.getDescription(), is(update.getDescription()));
    }
}