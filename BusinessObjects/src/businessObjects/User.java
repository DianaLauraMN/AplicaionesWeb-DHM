package businessObjects;

import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

public abstract class User {

    private ObjectId id;
    private String fullName;
    private String email;
    private String password;
    private String avatar;
    private String city;
    private Date birthDay;
    private char gender;
    private String phoneNumber;

    public User() {

    }

    public User(ObjectId id) {
        this.id = id;
    }

    public User(String fullName, String email, String password, String avatar, String city, Date birthDay, char gender, String phoneNumber) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.city = city;
        this.birthDay = birthDay;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public ObjectId getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getCity() {
        return city;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public char getGender() {
        return gender;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", fullName=" + fullName + ", email=" + email + ", password=" + password + ", avatar=" + avatar + ", city=" + city + ", birthDay=" + birthDay + ", gender=" + gender + '}';
    }

}
