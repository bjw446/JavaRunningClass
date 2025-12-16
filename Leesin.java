package task01;

public class Leesin extends Champion {

    public Leesin(String name) {
        super(name, 645, 645, 100, 66,36);
    }

    @Override
    public void skill1(Champion target) {
        if (!statusAlive()) {
            return;
        }
        long coolTime = 3000;
        if(!canSkillUse("음파", coolTime)) {
            System.out.println("음파 재사용 대기시간이 아직 남아있습니다.");
            return;
        }
        System.out.println(getName() + "이 " + target.getName() + "에게 음파를 사용합니다.");
        if (getMp() < 50 ) {
            System.out.println("기력이 부족합니다. 일반 공격 !");
            basicAttack(target);
            passiveSkill();
            killedChampion(target);
        } else {
            SkillUse("음파");
            useMp(50);
            target.takeDamage(getAttackDamage() + 30);
            killedChampion(target);
        }
    }

    @Override
    public void skill2(Champion target) {
        if (!statusAlive()) {
            return;
        }
        long coolTime = 3000;
        if(!canSkillUse("방호", coolTime)) {
            System.out.println("방호 재사용 대기시간이 아직 남아있습니다.");
            return;
        }
        System.out.println(getName() + "이 " + target.getName() + "에게 방호를 사용합니다");
        if(getMp() < 5 ) {
            System.out.println("기력이 부족합니다.");
        } else {
            SkillUse("방호");
            useMp(5);
            target.takeShield(getShield() + 15);
            passiveSkill();
        }
    }

    @Override
    public void skill3(Champion target) {
        if (!statusAlive()) {
            return;
        }
        long coolTime = 3000;
        if(!canSkillUse("폭풍", coolTime)) {
            System.out.println("폭풍 재사용 대기시간이 아직 남아있습니다.");
            return;
        }
        System.out.println(getName() + "이 " +target.getName() + "에게 폭풍을 사용합니다." );
        if(getMp() < 25) {
            System.out.println("기력이 부족합니다.");
            basicAttack(target);
            passiveSkill();
            killedChampion(target);
        } else {
            SkillUse("폭풍");
            useMp(25);
            target.takeDamage(getAttackDamage() + 15);
            killedChampion(target);
        }
    }

    @Override
    public void skill4(Champion target) {
        if (!statusAlive()) {
            return;
        }
        long coolTime = 3000;
        if(!canSkillUse("용의분노", coolTime)) {
            System.out.println("용의분노 재사용 대기시간이 아직 남아있습니다.");
            return;
        }
        System.out.println(getName() + "이 " + target.getName() + "에게 용의분노를 사용합니다.");
        if(getMp() < 100) {
            System.out.println("기력이 부족합니다.");
            basicAttack(target);
            passiveSkill();
            killedChampion(target);
        } else {
            SkillUse("용의분노");
            useMp(100);
            target.takeDamage(getAttackDamage() + 150);
            airBorne(target);
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
