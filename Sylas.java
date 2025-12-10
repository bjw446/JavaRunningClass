package task01;

import java.util.Random;

public class Sylas extends Champion {

    public Sylas(String name) {
        super(name, 600, 600, 100, 61, 29);
    }


    @Override
    public void skill1(Champion target) {
        System.out.println(getName() + "가 " + target.getName() + "에게 사슬 후려치기 사용합니다.");
        if (getMp() < 50 ) {
            System.out.println("마나가 부족합니다. 일반 공격 !");
            basicAttack(target);
            passiveSkill();
            killedChampion(target);
        } else {
            useMp(50);
            target.takeDamage(getAttackDamage() + 20);
            passiveSkill2(target);
            killedChampion(target);
        }
    }

    @Override
    public void skill2(Champion target) {
        if(getMp() < 30 ) {
            System.out.println("마나가 부족합니다.");
            basicAttack(target);
            passiveSkill();
            killedChampion(target);
        } else {
            System.out.println(getName() + "가 "+ target.getName() + "에게 국왕시해자를 사용합니다");
            useMp(30);
            target.takeDamage(getAttackDamage() + 10);
            takeHeal(15);
            passiveSkill2(target);
            killedChampion(target);
        }
    }


    @Override
    public void skill3(Champion target) {
        System.out.println(getName() + "가 " +target.getName() + "에게 도주/억압을 사용합니다." );
        if(getMp() < 15) {
            System.out.println("기력이 부족합니다.");
            basicAttack(target);
            passiveSkill();
            killedChampion(target);
        } else {
            useMp(15);
            target.takeDamage(getAttackDamage() + 15);
            passiveSkill2(target);
            killedChampion(target);
        }
    }

    @Override
    public void skill4(Champion target) {
        System.out.println(getName() + "가 " + target.getName() + "에게 강탈을 사용합니다.");
        if(getMp() < 100) {
            System.out.println("마나가 부족합니다.");
            basicAttack(target);
            passiveSkill();
            killedChampion(target);
        } else {
            useMp(100);
            target.takeDamage(getAttackDamage() + 100);
            takeHeal(20);
            passiveSkill2(target);
            killedChampion(target);
        }
    }

    @Override
    public void passiveSkill() {
        recoverMp(10);
    }

    @Override
    public void passiveSkill2(Champion target) {
        basicAttack(target);
        basicAttack(target);
    }
}
