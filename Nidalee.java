package task01;

public class Nidalee extends Champion {

    public Nidalee(String name) {
        super(name, 610, 610, 100, 58,32);
    }
    boolean skillUseUnUse = true;



    @Override
    public void skill1(Champion target) {
        if (skillUseUnUse) {
            System.out.println(getName() + "가 " + target.getName() + "에게 창 투척을 사용합니다.");
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
        }else{
            System.out.println(getName() + "가 " + target.getName() + "에게 숨통 끊기를 사용합니다.");
            target.takeDamage(getAttackDamage() + 15);
            passiveSkill();
            killedChampion(target);

        }
    }

    @Override
    public void skill2(Champion target) {
        if (skillUseUnUse) {
            System.out.println(getName() + "가 매복 덫을 사용합니다.");
            if (getMp() < 20 ) {
                System.out.println("마나가 부족합니다. 일반 공격 !");
                basicAttack(target);
                passiveSkill();
                killedChampion(target);
            } else {
                useMp(20);
                target.takeDamage(getAttackDamage() + 10);
                killedChampion(target);
            }
        }else {
            System.out.println(getName() + "가 " + target.getName() + "에게 급습 사용합니다.");
            target.takeDamage(getAttackDamage() + 5);
            passiveSkill();
            killedChampion(target);
        }
    }

    @Override
    public void skill3(Champion target) {
        if (skillUseUnUse) {
            System.out.println(getName() + "가 " + target.getName() + "에게 태고의 생명력을 사용합니다.");
            if (getMp() < 30 ) {
                System.out.println("마나가 부족합니다.");
                passiveSkill();
            } else {
                useMp(30);
                target.takeHeal(50);
            }
        }else {
            System.out.println(getName() + "가 " + target.getName() + "에게 할퀴기를 사용합니다.");
            target.takeDamage(getAttackDamage() + 10);
            passiveSkill();
            killedChampion(target);
        }
    }

    @Override
    public void skill4(Champion target) {

        if (skillUseUnUse) {
            System.out.println(getName() + "가 쿠거의 상을 사용합니다.");
        } else {
            System.out.println(getName() + "가 인간폼으로 돌아옵니다.");
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
