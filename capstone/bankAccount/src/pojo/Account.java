package pojo;
import java.util.Objects;

public abstract class Account {
    private String id;

    public Account(String id) {
        setId(id);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        if(id == null || id.isBlank()){
            throw new IllegalArgumentException("ID cannot be null or blank.");
        }

        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(getId(), account.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Account ID: " + id + ", ";
    }

    /**
     * An abstract method to clone to the Account class.
     * The clone method will have no parameters and
     * return an Account object.
     */
    public abstract Account clone();
}
