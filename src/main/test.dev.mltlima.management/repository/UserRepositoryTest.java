package test.dev.mltlima.management.repository;

import dev.mltlima.management.model.User;
import dev.mltlima.management.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void should_find_no_users_if_repository_is_empty() {
        List<User> users = repository.findAll();
        assertThat(users).isEmpty();
    }

    @Test
    public void should_store_a_user() {
        User user = repository.save(new User("Fulano", "test@mail.com", "01/01/2000", null));
        assertThat(user).hasFieldOrPropertyWithValue("name", "Fulano");
    }

    @Test
    public void should_find_all_users() {
        User user1 = new User("Fulano", "test@mail.com", "01/01/2000", null);
        User user2 = new User("Beltrano", "test@mail.com", "01/01/2000", null);
        User user3 = new User("Ciclano", "test@mail.com", "01/01/2000", null);
        repository.save(user1);
        repository.save(user2);
        repository.save(user3);
        List<User> users = repository.findAll();
        assertThat(users).hasSize(3).contains(user1, user2, user3);
    }

    @Test
    public void should_find_user_by_id() {
        User user1 = new User("Fulano", "test@mail.com", "01/01/2000", null);
        User user2 = new User("Beltrano", "test@mail.com", "01/01/2000", null);
        User user3 = new User("Ciclano", "test@mail.com", "01/01/2000", null);
        repository.save(user1);
        repository.save(user2);
        repository.save(user3);
        User foundUser = repository.findById(user2.getId()).get();
        assertThat(foundUser).isEqualTo(user2);
    }

    @Test
    public void should_update_user_by_id() {
        User user1 = new User("Fulano", "test@mail.com", "01/01/2000", null);
        User user2 = new User("Beltrano", "test@mail.com", "01/01/2000", null);
        User user3 = new User("Ciclano", "test@mail.com", "01/01/2000", null);
        repository.save(user1);
        repository.save(user2);
        repository.save(user3);
        User updatedUser = new User("Beltrano", "test2@mail.com", "01/01/2002", null);
        repository.save(updatedUser);
        User checkUser = repository.findById(user2.getId()).get();
        assertThat(checkUser.getId()).isEqualTo(updatedUser.getId());
        assertThat(checkUser.getName()).isEqualTo(updatedUser.getName());
    }

    @Test
    public void should_delete_user_by_id() {
        User user1 = new User("Fulano", "test@mail.com", "01/01/2000", null);
        User user2 = new User("Beltrano", "test@mail.com", "01/01/2000", null);
        User user3 = new User("Ciclano", "test@mail.com", "01/01/2000", null);
        repository.save(user1);
        repository.save(user2);
        repository.save(user3);
        repository.deleteById(user2.getId());
        List<User> users = repository.findAll();
        assertThat(users).hasSize(2).contains(user1, user3);
    }

    @Test
    public void should_delete_all_users() {
        repository.deleteAll();
        List<User> users = repository.findAll();
        assertThat(users).isEmpty();
    }
}