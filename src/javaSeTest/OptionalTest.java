package javaSeTest;

import java.util.Optional;

public class OptionalTest {
    static class User {
        private String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static String getName1(User u) {
        return u != null ? u.getName() : "unknown user";
    }

    public static String getName2(User u) {
        return Optional.ofNullable(u)
                .map(User::getName)
                .orElse("unknown user");
    }

    public static void main(String[] args) {
        User user = null;
        User user1 = new User("abc");
        User result = Optional.ofNullable(user).orElse(user1);
        result = Optional.ofNullable(user).orElseThrow(() -> new IllegalArgumentException());
        System.out.println(result);
    }
}
