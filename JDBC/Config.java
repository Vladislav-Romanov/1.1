public class Config {
    private String name="root";
    private String password="root";
    private String URL="jdbc:mysql://localhost:3306/mytest?useSSL=false";
    private String ClassforName="com.mysql.jdbc.Driver";

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public String getURL() {
        return this.URL;
    }

    public String getClassforName() {
        return this.ClassforName;
    }
}
