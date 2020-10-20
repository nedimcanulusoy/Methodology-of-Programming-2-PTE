import java.io.Serializable;

public class User implements Serializable {
    private String mName;

    public User(String mName) {
        this.mName = mName;
    }

    public String getName() {
        return mName;
    }
}

