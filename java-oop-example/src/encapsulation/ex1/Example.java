package encapsulation.ex1;

public class Example {
    private final PasswordEncoder passwordEncoder;

    public Example(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResult authenticate(String id , String pw) {
        Member member = findOne(id);
        if (member == null) return AuthResult.NO_MATCH;

        // as-is
//        if (member.getEmailVerifiedStatus() != 2) {
//            return AuthResult.NO_EMAIL_VERIFIED;
//        }

        // to-be
        if (!member.isEmailVerified()) {
            return AuthResult.NO_EMAIL_VERIFIED;
        }

        if (passwordEncoder.isPasswordValid(member.getPassword() , pw , member.getId())) {
            return AuthResult.SUCCESS;
        }

        return AuthResult.NO_MATCH;
    }

    private Member findOne(String id) {
        return null;
    }

    public void verifyEmail(String token) {
        Member member = findByToken(token);
        if (member == null) {
            throw new RuntimeException();
        }

        // as-is
//        if (member.getEmailVerifiedStatus() == 2) {
//            throw new RuntimeException();
//        } else {
//            member.setEmailVerifiedStatus(2);
//        }

        // to-be
        member.verifyEmail();
    }

    private Member findByToken(String token) {
        return null;
    }
}
