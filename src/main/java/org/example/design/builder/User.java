package org.example.design.builder;

public class User {

    private final int userId;
    private final String name;
    private final String email;

    private User(UserBuilder userBuilder){
        this.userId= userBuilder.userId;
        this.name= userBuilder.name;
        this.email= userBuilder.email;

    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name=" + name +
                ", email=" + email +
                '}';
    }

    static class UserBuilder{
        private int userId;
        private String name;
        private String email;

        public UserBuilder(){
        }

        public static UserBuilder builder(){
            return new UserBuilder();
        }

        public UserBuilder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build(){
            User user = new User(this);
            return user;
        }
    }


}
