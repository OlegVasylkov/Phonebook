package ua.vasylkov.phonebook;

import ua.vasylkov.phonebook.matcher.ModelMatcher;
import ua.vasylkov.phonebook.model.Role;
import ua.vasylkov.phonebook.model.User;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

import static ua.vasylkov.phonebook.model.BaseEntity.START_SEQ;

/**
 * Created by OlegVasylkov on 17.08.2016.
 */
public class UserTestData {
    public static final int ADMIN_ID = START_SEQ;
    public static final int USER_ID = START_SEQ + 1;

    public static final User ADMIN = new User(ADMIN_ID, "Admin name", "admin", "root", Role.ROLE_ADMIN);
    public static final User USER = new User(USER_ID, "User name", "user", "password", Role.ROLE_USER);

    public static final ModelMatcher<User, TestUser> USER_MATCHER =
            new ModelMatcher<>(user -> user instanceof TestUser ? (TestUser)user : new TestUser(user));

    public static class TestUser extends User{
        public TestUser(User user){
            this(user.getId(), user.getName(), user.getLogin(), user.getPassword(), user.getRoles());
        }

        public TestUser(String name, String login, String password, Role role, Role... roles){
            this(null, name, login, password, EnumSet.of(role, roles));
        }

        public TestUser(Integer id, String name, String login, String password, Set<Role> roles) {
            super(id, name, login, password, roles);
        }

        public User asUser(){return new User(this);}

        @Override
        public String toString() {
            return "User{" +
                    "login='" + login + '\'' +
                    ", password='" + password + '\'' +
                    ", roles=" + roles +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;
            if (obj == null || getClass()!= obj.getClass()) return false;
            TestUser that = (TestUser) obj;
            return Objects.equals(this.password, that.password)
                    && Objects.equals(this.login, that.login)
                    && Objects.equals(this.name, that.name)
                    && Objects.equals(this.id, that.id);
        }
    }
}