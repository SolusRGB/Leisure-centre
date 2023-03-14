/**
 * <p>
 *  This is a built-in java class that allows me to create a record of the members details. With built-in setters and
 *  getters.
 *  This allows me to focus more on building functionality rather than creating a class for each member.
 * </p>
 * @param firstName
 * @param lastName
 * @param email
 * @param phoneNumber
 * @param address
 * @param postcode
 */
public record Member(String firstName, String lastName, String email, String phoneNumber,
                     String address, String postcode) {


    public Member {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be empty");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be empty");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Address cannot be empty");
        }
        if (postcode == null || postcode.isBlank()) {
            throw new IllegalArgumentException("Postcode cannot be empty");
        }
    }
}
