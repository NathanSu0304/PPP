import java.util.ArrayList;

public class BaseActor {
    private String name;
    private String dob;

    public BaseActor(){

    }
    public BaseActor(String name, String dob){
        this.name = name;
        this.dob = dob;
    }
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "BaseActor{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }

}
