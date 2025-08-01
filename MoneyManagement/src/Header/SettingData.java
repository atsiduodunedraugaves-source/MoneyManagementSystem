package Header;

public class SettingData {

    private String name;
    private String value;

    public SettingData(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SettingData [name=" + name + ", value=" + value + "]";
    }

}
