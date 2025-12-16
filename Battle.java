package task01;

import java.util.List;
import java.util.Random;

public class Battle {

    private static Random random = new Random();

    public static void oneVsOne(Team<Champion> t1, Team<Champion> t2) {

        Champion c1 = randomPick(t1.getMembers());
        Champion c2 = randomPick(t2.getMembers());

        System.out.println("\n===== 1:1 전투 시작 =====");
        System.out.println(c1.getName() + " vs " + c2.getName());

        c1.skill1(c2);
        c2.skill1(c1);
        c1.basicAttack(c2);
        c2.basicAttack(c1);
        c1.skill2(c2);
        c2.skill2(c1);
        c1.basicAttack(c2);
        c2.basicAttack(c1);
        c1.skill3(c2);
        c2.skill3(c1);
        c1.basicAttack(c2);
        c2.basicAttack(c1);
        c1.skill4(c2);
        c2.skill4(c1);
    }
    private static Champion randomPick(List<Champion> list) {
        return list.get(random.nextInt(list.size()));
    }
}
