package com.company.repository;

import com.company.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        userRepository.deleteAll();
    }

    @Test
    public void addGetDeleteUser() {

        User user = new User();
        user.setUsername("Tester");
        user.setFirstName("Test");
        user.setLastName("Er");
        user.setEmail("www.tester@test.com");
        user.setPassword("password");

        user = userRepository.save(user);

        Optional<User> user1 = userRepository.findById(user.getId());

        assertEquals(user1.get(), user);

        userRepository.deleteById(user.getId());

        user1 = userRepository.findById(user.getId());

        assertFalse(user1.isPresent());

    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setUsername("Tester");
        user.setFirstName("Test");
        user.setLastName("Er");
        user.setEmail("www.tester@test.com");
        user.setPassword("password");

        user = userRepository.save(user);

        user.setUsername("Tester Update");
        user.setFirstName("Test Update");
        user.setLastName("Er Update");
        user.setEmail("www.tester@testUpdate.com");
        user.setPassword("passwordUpdate");

        Optional<User> user1 = userRepository.findById(user.getId());
        assertEquals(user1.get(), user);
    }

    @Test
    public void getAllUsers() {
        User user = new User();
        user.setUsername("Tester");
        user.setFirstName("Test");
        user.setLastName("Er");
        user.setEmail("www.tester@test.com");
        user.setPassword("password");

        user = userRepository.save(user);

        User user2 = new User();
        user2.setUsername("Mocker");
        user2.setFirstName("Mock");
        user2.setLastName("Er");
        user2.setEmail("www.mocker@test.com");
        user2.setPassword("password");

        user2 = userRepository.save(user2);

        List<User> userList = userRepository.findAll();
        assertEquals(userList.size(),2);
    }
}
