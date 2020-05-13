package edu.miu.cs544.team6.integration;

import edu.miu.cs544.team6.domain.User;
import edu.miu.cs544.team6.repository.UserRepository;
import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByMailReturnsUser() {
        User user = new User();
        user.setEmail("ahussein@miu.edu");
        entityManager.persist(user);
        entityManager.flush();

        User found = userRepository.findUserByEmailEquals("ahussein@miu.edu");
        Assert.assertEquals(found.getEmail(), user.getEmail());
    }

    @Test
    public void emptyReturnsEmptyList() {
        List<User> list = userRepository.findAll();
        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void returnedSize() {
        User user = new User();
        user.setEmail("ahussein@miu.edu");
        entityManager.persist(user);
        entityManager.flush();
        List<User> list = userRepository.findAll();
        Assert.assertEquals(list.size(), 1);
    }
}
