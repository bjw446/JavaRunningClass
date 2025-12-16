package task01;

import java.util.Random;

public class Jarvan extends Champion {

    public Jarvan(String name) {
        super(name, 640, 640, 100,64,36);
    }
    private long flagTime = 0;
    private long lastFlagTime = 0;


    @Override
    public void skill1(Champion target) {
        if (!statusAlive()) {
            return;
        }
        long coolTime = 3000;
        if(!canSkillUse("용의일격", coolTime)) {
            System.out.println("용의 일격 재사용 대기시간이 아직 남아있습니다.");
            return;
        }
        System.out.println(getName() + "이 " + target.getName() + "에게 용의 일격을 사용합니다.");
        if (getMp() < 50 ) {
            System.out.println("마나가 부족합니다. 일반 공격 !");
            basicAttack(target);
            passiveSkill();
            killedChampion(target);
        } else {
            long flagCoolTime = flagTime * 1000L;
            long currentTime = System.currentTimeMillis();
            SkillUse("용의일격");
            useMp(50);
            target.takeDamage(getAttackDamage() + 30);
            killedChampion(target);
            if(currentTime - lastFlagTime <= flagCoolTime) {
                airBorne(target);
                lastFlagTime = 0;
            }
        }
    }

    @Override
    public void skill2(Champion target) {
        if (!statusAlive()) {
            return;
        }
        long coolTime = 3000;
        if(!canSkillUse("황금빛방패", coolTime)) {
            System.out.println("황금빛 방패 재사용 대기시간이 아직 남아있습니다.");
            return;
        }
        System.out.println(getName() + "이 황금빛 방패를 사용합니다");
        if(getMp() < 20 ) {
            System.out.println("마나가 부족합니다.");
        } else {
            SkillUse("황금빛방패");
            useMp(20);
            target.takeShield(getShield() + 30);
        }
    }

    @Override
    public void skill3(Champion target) {
        if (!statusAlive()) {
            return;
        }
        long coolTime = 3000;
        if(!canSkillUse("데마시아의깃발", coolTime)) {
            System.out.println("데마시아의 깃발 재사용 대기시간이 아직 남아있습니다.");
            return;
        }
        System.out.println(getName() + "이 " +target.getName() + "에게 데마시아의 깃발을 사용합니다." );
        if(getMp() < 15) {
            System.out.println("마나가 부족합니다.");
            basicAttack(target);
            passiveSkill();
            killedChampion(target);
        } else {
            SkillUse("데마시아의깃발");
            useMp(15);
            target.takeDamage(getAttackDamage() + 25);
            flagTime = flagTime + 5;
            lastFlagTime = System.currentTimeMillis();
            passiveSkill();
            killedChampion(target);
        }
    }

    @Override
    public void skill4(Champion target) {
        if (!statusAlive()) {
            return;
        }
        long coolTime = 3000;
        if(!canSkillUse("대격변", coolTime)) {
            System.out.println("대격변 재사용 대기시간이 아직 남아있습니다.");
            return;
        }
        System.out.println(getName() + "이 " + target.getName() + "에게 대격변 사용합니다.");
        if(getMp() < 100) {
            System.out.println("마나가 부족합니다.");
            basicAttack(target);
            passiveSkill();
            killedChampion(target);
        } else {
            SkillUse("대격변");
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
