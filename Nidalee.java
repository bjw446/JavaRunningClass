package task01;

import java.util.HashMap;
import java.util.Map;

public class Nidalee extends Champion {

    public Nidalee(String name) {
        super(name, 610, 610, 100, 58,32);
    }
    boolean skillUseUnUse = true;



    @Override
    public void skill1(Champion target) {
        if (!statusAlive()) {
            return;
        }
        long coolTime = 3000;
        if (skillUseUnUse) {
            if(!canSkillUse("창투척", coolTime)) {
                System.out.println("창 투척 재사용 대기시간이 아직 남아있습니다.");
                return;
            }
            System.out.println(getName() + "가 " + target.getName() + "에게 창 투척을 사용합니다.");
            if (getMp() < 50 ) {
                System.out.println("마나가 부족합니다. 일반 공격 !");
                basicAttack(target);
                passiveSkill();
                killedChampion(target);
            } else {
                SkillUse("창투척");
                useMp(50);
                target.takeDamage(getAttackDamage() + 30);
                killedChampion(target);
            }
        }else{
            coolTime = 4000;
            if(!canSkillUse("숨통끊기", coolTime)) {
                System.out.println("숨통 끊기 재사용 대기시간이 아직 남아있습니다.");
                return;
            }
            System.out.println(getName() + "가 " + target.getName() + "에게 숨통 끊기를 사용합니다.");
            SkillUse("숨통끊기");
            target.takeDamage(getAttackDamage() + 15);
            passiveSkill();
            killedChampion(target);
        }
    }

    @Override
    public void skill2(Champion target) {
        if (!statusAlive()) {
            return;
        }
        long coolTime = 3000;
        if (skillUseUnUse) {
            if(!canSkillUse("매복덫", coolTime)) {
                System.out.println("매복 덫 재사용 대기시간이 아직 남아있습니다.");
                return;
            }
            System.out.println(getName() + "가 매복 덫을 사용합니다.");
            if (getMp() < 20 ) {
                System.out.println("마나가 부족합니다. 일반 공격 !");
                basicAttack(target);
                passiveSkill();
                killedChampion(target);
            } else {
                SkillUse("매복덫");
                useMp(20);
                target.takeDamage(getAttackDamage() + 10);
                killedChampion(target);
            }
        }else {
            coolTime = 4000;
            if(!canSkillUse("급습", coolTime)) {
                System.out.println("급습 재사용 대기시간이 아직 남아있습니다.");
                return;
            }
            System.out.println(getName() + "가 " + target.getName() + "에게 급습 사용합니다.");
            SkillUse("급습");
            target.takeDamage(getAttackDamage() + 5);
            passiveSkill();
            killedChampion(target);
        }
    }

    @Override
    public void skill3(Champion target) {
        if (!statusAlive()) {
            return;
        }
        long coolTime = 3000;
        if (skillUseUnUse) {
            if(!canSkillUse("태고의생명력", coolTime)) {
                System.out.println("태고의 생명력 재사용 대기시간이 아직 남아있습니다.");
                return;
            }
            System.out.println(getName() + "가 " + target.getName() + "에게 태고의 생명력을 사용합니다.");
            if (getMp() < 30 ) {
                System.out.println("마나가 부족합니다.");
                passiveSkill();
            } else {
                SkillUse("태고의생명력");
                useMp(30);
                target.takeHeal(50);
            }
        }else {
            coolTime = 4000;
            if(!canSkillUse("할퀴기", coolTime)) {
                System.out.println("할퀴기 재사용 대기시간이 아직 남아있습니다.");
                return;
            }
            System.out.println(getName() + "가 " + target.getName() + "에게 할퀴기를 사용합니다.");
            SkillUse("할퀴기");
            target.takeDamage(getAttackDamage() + 10);
            passiveSkill();
            killedChampion(target);
        }
    }

    @Override
    public void skill4(Champion target) {
        if (!statusAlive()) {
            return;
        }
        long coolTime = 2000;
        if (skillUseUnUse) {
            if(!canSkillUse("쿠거의상", coolTime)) {
                System.out.println("쿠거의 상 재사용 대기시간이 아직 남아있습니다.");
                return;
            }
            System.out.println(getName() + "가 쿠거의 상을 사용합니다.");
            SkillUse("쿠거의상");
        } else {
            if(!canSkillUse("인간폼", coolTime)) {
                System.out.println("인간폼 재사용 대기시간이 아직 남아있습니다.");
                return;
            }
            System.out.println(getName() + "가 인간폼으로 돌아옵니다.");
            SkillUse("인간폼");
        }
        skillUseUnUse = !skillUseUnUse;
    }

    @Override
    public void passiveSkill() {
        recoverMp(20);
    }

    @Override
    public void passiveSkill2(Champion target) {

    }
}
