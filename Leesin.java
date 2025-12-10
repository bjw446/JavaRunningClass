package task01;

public class Leesin extends Champion {

    public Leesin(String name) {
        super(name, 645, 645, 100, 66,36);
    }

    @Override
    public void skill1(Champion target) {
        System.out.println(getName() + "이 " + target.getName() + "에게 음파를 사용합니다.");
        if (getMp() < 50 ) {
            System.out.println("기력이 부족합니다. 일반 공격 !");
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
        System.out.println(getName() + "이 " + target.getName() + "에게 방호를 사용합니다");
        if(getMp() < 5 ) {
            System.out.println("기력이 부족합니다.");
        } else {
            useMp(5);
            target.takeShield(getShield() + 15);
            passiveSkill();
        }
    }

    @Override
    public void skill3(Champion target) {
        System.out.println(getName() + "이 " +target.getName() + "에게 폭풍을 사용합니다." );
        if(getMp() < 25) {
            System.out.println("기력이 부족합니다.");
            basicAttack(target);
            passiveSkill();
            killedChampion(target);
        } else {
            useMp(25);
            target.takeDamage(getAttackDamage() + 15);
            killedChampion(target);
        }
    }

    @Override
    public void skill4(Champion target) {
        System.out.println(getName() + "이 " + target.getName() + "에게 용의분노를 사용합니다.");
        if(getMp() < 100) {
            System.out.println("기력이 부족합니다.");
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
        recoverMp(15);
    }

    @Override
    public void passiveSkill2(Champion target) {

    }
}
