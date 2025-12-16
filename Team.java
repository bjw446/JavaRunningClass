package task01;

import java.util.ArrayList;
import java.util.List;

public class Team <T extends Champion> {
    private List<T> members = new ArrayList<>();
    private String name;

    public Team(String name) {
        this.name = name;
    }

    public void addMember(T champion) {
        members.add(champion);
        System.out.println(champion.getName() + "이(가) " + name + "팀에 합류!");
    }
    public T get(int index) {
        return members.get(index);
    }
    public double getTotalHp() {
        return members.stream()
                      .mapToDouble(Champion::getHp)
                      .sum();
    }
    public List<T> getMembers() {
        return members;
    }
}