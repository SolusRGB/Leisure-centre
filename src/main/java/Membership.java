public enum Membership {

    NEW_MEMBER("New Member", "Welcome, please purchase a membership to access the full centre." + "\n"
            + "You can choose either BASIC or PREMIUM.", 0.00),
    BASIC("Basic", "Access to only the gym. Please purchase a PREMIUM membership " +
            "to reserve pitches and have full access.", 19.99),
    PREMIUM("Premium", "Access to all centre areas.", 29.99);

    private final String name;
    private final String description;
    private final double price;

    Membership(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }


    public void setMembershipLevel(Account account) {
        account.setMembershipLevel(this);
    }


}
