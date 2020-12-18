package cn.com.test;

public class SchoolBoy {
    private String girlId;
    private String id;
    private String name;
    private String grilName;

    public SchoolBoy() {
        super();
    }

    public SchoolBoy(String girlId, String id, String name, String grilName) {
        super();
        this.girlId = girlId;
        this.id = id;
        this.name = name;
        this.grilName = grilName;
    }

    public String getGirlId() {
        return girlId;
    }

    public void setGirlId(String girlId) {
        this.girlId = girlId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrilName() {
        return grilName;
    }

    public void setGrilName(String grilName) {
        this.grilName = grilName;
    }

    @Override
    public String toString() {
        return "\nSchoolBoy [girlId=" + girlId + ", id=" + id + ", name=" + name + ", grilName=" + grilName + "]";
    }
}
