package encapsulation.ex1;

public class Member {
    private String id;
    private String password;
    private int emailVerifiedStatus;

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public int getEmailVerifiedStatus() {
        return emailVerifiedStatus;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmailVerifiedStatus(int emailVerifiedStatus) {
        this.emailVerifiedStatus = emailVerifiedStatus;
    }

    public boolean isEmailVerified() {
        return emailVerifiedStatus == 2;
    }

    public void verifyEmail() {
        if (isEmailVerified()) {
            throw new RuntimeException();
        } else {
            this.emailVerifiedStatus = 2;
        }
    }
}
