package task01;

import java.util.Random;

public class Sylas extends Champion {

    public Sylas(String name) {
        super(name, 600, 600, 100, 61, 29);
    }


    @Override
    public void skill1(Champion target) {
        if (!statusAlive()) {
            return;
        }
        long coolTime = 3000;
        if(!canSkillUse("사슬후려치기", coolTime)) {
            System.out.println("사슬 후려치기 재사용 대기시간이 아직 남아있습니다.");
            return;
        }
        System.out.println(getName() + "가 " + target.getName() + "에게 사슬 후려치기 사용합니다.");
        if (getMp() < 50 ) {
            System.out.println("마나가 부족합니다. 일반 공격 !");
            basicAttack(target);
            passiveSkill();
            killedChampion(target);
        } else {
            SkillUse("사슬후려치기");
            useMp(50);
            target.takeDamage(getAttackDamage() + 20);
            passiveSkill2(target);
            killedChampion(target);
        }
    }

    @Override
    public void skill2(Champion target) {
        if (!statusAlive()) {
            return;
        }
        long coolTime = 3000;
        if(!canSkillUse("국왕시해자", coolTime)) {
            System.out.println("국왕시해자 재사용 대기시간이 아직 남아있습니다.");
            return;
        }
        System.out.println(getName() + "가 "+ target.getName() + "에게 국왕시해자를 사용합니다");
        if(getMp() < 30 ) {
            System.out.println("마나가 부족합니다.");
            basicAttack(target);
            passiveSkill();
            killedChampion(target);
        } else {
            SkillUse("국왕시해자");
            useMp(30);
            target.takeDamage(getAttackDamage() + 10);
            takeHeal(15);
            passiveSkill2(target);
            killedChampion(target);
        }
    }


    @Override
    public void skill3(Champion target) {
        if (!statusAlive()) {
            return;
        }
        long coolTime = 3000;
        if(!canSkillUse("도주억압", coolTime)) {
            System.out.println("도주/억압 재사용 대기시간이 아직 남아있습니다.");
            return;
        }
        System.out.println(getName() + "가 " +target.getName() + "에게 도주/억압을 사용합니다." );
        if(getMp() < 15) {
            System.out.println("기력이 부족합니다.");
            basicAttack(target);
            passiveSkill();
            killedChampion(target);
        } else {
            SkillUse("도주억압");
            useMp(15);
            target.takeDamage(getAttackDamage() + 15);
            passiveSkill2(target);
            airBorne(target);
            killedChampion(target);
        }
    }

    @Override
    public void skill4(Champion target) {
        if (!statusAlive()) {
            return;
        }
        long coolTime = 3000;
        if(!canSkillUse("강탈", coolTime)) {
            System.out.println("강탈 재사용 대기시간이 아직 남아있습니다.");
            return;
        }
        System.out.println(getName() + "가 " + target.getName() + "에게 강탈을 사용합니다.");
        if(getMp() < 100) {
            System.out.println("마나가 부족합니다.");
            basicAttack(target);
            passiveSkill();
            killedChampion(target);
        } else {
            SkillUse("강탈");
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
