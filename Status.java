package task01;

public enum Status {
    ALIVE(""),
    DEAD("사망"),
    RESURRECT("부활중"),
    STUNNED("스턴"),
    SILENCED("침묵"),
    AIRBORNE("공중에뜸");

    private final String str;

    Status(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}


