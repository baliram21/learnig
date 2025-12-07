package org.nayan.design_pattern.builder;

public class User {

    // Immutable fields → once object is created, these values cannot be changed
    private final int userId;
    private final String name;
    private final String email;

    /*
     * Private constructor
     * Only the UserBuilder can create User objects.
     * We pass UserBuilder object here and copy its values.
     */
    private User(UserBuilder userBuilder){
        this.userId = userBuilder.userId;
        this.name = userBuilder.name;
        this.email = userBuilder.email;
    }

    // Getters to read values (no setters → object is immutable)
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

    /*
     * ===============================
     *    BUILDER CLASS (Static)
     * ===============================
     *
     * Purpose:
     * - Helps in constructing User objects in a readable and flexible way.
     * - Supports method-chaining: builder.setX().setY().build()
     * - Prevents long/telescoping constructors.
     */
    static class UserBuilder {

        // Same fields as User but NON-final because they will change during building
        private int userId;
        private String name;
        private String email;

        // Default constructor for Builder
        public UserBuilder() { }

        /*
         * Static method to start builder creation
         * Usage: User.UserBuilder.builder()
         */
        public static UserBuilder builder() {
            return new UserBuilder();
        }

        /*
         * Setter-like methods for builder
         * Each method returns UserBuilder (this) → enabling method chaining
         */
        public UserBuilder setUserId(int userId) {
            this.userId = userId;
            return this; // allows chaining
        }

        public UserBuilder setName(String name) {
            this.name = name;
            return this; // allows chaining
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this; // allows chaining
        }

        /*
         * Final step: build()
         * Creates the actual immutable User object using the builder values.
         */
        public User build() {
            return new User(this);
        }
    }
}
