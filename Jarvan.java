package task01;

import java.util.Random;

public class Jarvan extends Champion {

    public Jarvan(String name) {
        super(name, 640, 640, 100,64,36);
    }


    @Override
    public void skill1(Champion target) {
        System.out.println(getName() + "이 " + target.getName() + "에게 용의 일격을 사용합니다.");
        if (getMp() < 50 ) {
            System.out.println("마나가 부족합니다. 일반 공격 !");
            basicAttack(target);
            passiveSkill();
            killedChampion(target);
        } else {
            useMp(50);
            target.takeDamage(getAttackDamage() + 30);
            killedChampion(target);
        }
    }

    @Override
    public void skill2(Champion target) {
        System.out.println(getName() + "이 황금빛 방패를 사용합니다");
        if(getMp() < 20 ) {
            System.out.println("마나가 부족합니다.");
        } else {
            useMp(20);
            target.takeShield(getShield() + 30);
        }
    }

    @Override
    public void skill3(Champion target) {
        System.out.println(getName() + "이 " +target.getName() + "에게 데마시아의 깃발을 사용합니다." );
        if(getMp() < 15) {
            System.out.println("기력이 부족합니다.");
            basicAttack(target);
            passiveSkill();
            killedChampion(target);
        } else {
            useMp(15);
            target.takeDamage(getAttackDamage() + 25);
            passiveSkill();
            killedChampion(target);
        }
    }

    @Override
    public void skill4(Champion target) {
        System.out.println(getName() + "이 " + target.getName() + "에게 대격변 사용합니다.");
        if(getMp() < 100) {
            System.out.println("마나가 부족합니다.");
            basicAttack(target);
            passiveSkill();
            killedChampion(target);
        } else {
            useMp(100);
            target.takeDamage(getAttackDamage() + 150);
            passiveSkill();
            killedChampion(target);
        }
    }

    @Override
    public void passiveSkill() {
        double chanceHeal = 0.15;
        if (Math.random() < chanceHeal) {
            System.out.println("체력 재생 효과 발생");
            takeHeal(10);
        }
        recoverMp(10);
    }

    @Override
    public void passiveSkill2(Champion target) {

    }
}
