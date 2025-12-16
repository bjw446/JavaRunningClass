package task01;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

        ChampionPool pool = new ChampionPool();
        pool.addChampion(new Leesin("리신"));
        pool.addChampion(new Jarvan("자르반"));
        pool.addChampion(new Nidalee("니달리"));
        pool.addChampion(new Sylas("사일러스"));

        Team<Champion> blue = new Team<>("블루");
        Team<Champion> red = new Team<>("레드");

        blue.addMember(pool.get("리신"));
        blue.addMember(pool.get("사일러스"));

        red.addMember(pool.get("자르반"));
        red.addMember(pool.get("니달리"));


        System.out.println("블루팀 전체 체력 : " + blue.getTotalHp());
        System.out.println("레드팀 전체 체력 : " + red.getTotalHp());

        Battle.oneVsOne(blue, red);

        System.out.println("블루팀 전체 체력 : " + blue.getTotalHp());
        System.out.println("레드팀 전체 체력 : " + red.getTotalHp());


    }
}


