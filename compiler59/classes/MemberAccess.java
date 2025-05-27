package classes;

public class MemberAccess {
    private boolean isThis;
    private String memberName;

    public boolean isThis() {
        return isThis;
    }

    public void setThis(boolean aThis) {
        isThis = aThis;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        return "MemberAccess{" +
                "isThis=" + isThis +
                ", memberName='" + memberName + '\'' +
                '}';
    }
}