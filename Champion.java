package task01;

import java.util.HashMap;
import java.util.Map;

public abstract class Champion {
    private final String name;
    private double hp;
    private double maxHp;
    private int attackDamage;
    private int defence;
    private int shield;
    private final Exp expClass;
    private int mp;
    private static int battleCount = 0;
    private long resurrectCoolTime = 60;
    private long lastResurrectTime = 0;
    private long airBorneTime = 0;
    private long stunnedTime = 0;
    private Status status = Status.ALIVE;
    private Map<String, Long> coolTimeMap = new HashMap<>();


    public Champion(String name, int hp, int maxHp, int mp, int attackDamage, int defence) {
        this.attackDamage = attackDamage;
        this.defence = defence;
        this.hp = hp;
        this.maxHp = maxHp;
        this.name = name;
        this.mp = mp;
        this.expClass = new Exp(this);
    }



    public int getBattleCount() {
        return battleCount;
    }


    public int basicExp(){
        return expClass.getBasicExp();
    }

    public int useMp(int useUp) {
        if(mp <= 0) {
            mp = 0;
            return mp;
        } else if((mp - useUp) < 0) {
            return mp;
        } else if((mp - useUp) == 0){
            mp = mp - useUp;
            return mp;
        }
        mp = mp - useUp;
        return mp;
    }
    public int recoverMp(int recover) {
        if(mp >= 100) {
            mp = 100;
            return mp;
        }else if ((mp + recover) >= 100) {
            mp = 100;
            return mp;
        }else {
            mp = mp + recover;
            return mp;
        }
    }
    public void takeDamage(int damage) {
        int shieldDamage = shield - damage;
        if(status == Status.ALIVE) {
            if (shield >= damage) {
                shield = shield - damage;
                shieldDamage = 0;
            } else if ((shield - damage) < 0) {
                shieldDamage = damage - shield;
            }

            int actualDamage = shieldDamage - defence;
            if (actualDamage < 0) {
                actualDamage = 0;
            }

            if ((hp - actualDamage) <= 0) {
                System.out.println(name + " 사망!!!");
                shield = 0;
                hp = 0;
                status = Status.DEAD;
            } else {
                hp = hp - actualDamage;
                shield = 0;
                System.out.println(name + "이(가) " + actualDamage + " 피해를 입음! (남은 HP : " + hp + ")");
            }
        }
        resurrect();
        battleCount++;
    }

    public void killedChampion(Champion target){
        if (target.getHp() <= 0 && target.status == Status.DEAD) {
            System.out.println(name + "이(가) " + target.getName() + "을(를) 처치하여 경험치를 얻었습니다." );
            plusExp(100);
            target.status = Status.RESURRECT;
        } else if (target.status == Status.RESURRECT){
            System.out.println(target.getName() + "이(가) 이미 사망하였습니다. 대상을 찾을 수 없습니다.");
        }
    }

    public final void resurrect() {
        long cooltime = resurrectCoolTime * 1000L;
        long currentTime = System.currentTimeMillis();

        if (getHp() <= 0 && (status != Status.ALIVE) ) {
            if (lastResurrectTime == 0 || (currentTime - lastResurrectTime) >= cooltime) {
                System.out.println("체력이 0 이하로 떨어져 사망하였습니다. 기본 체력의 20%로 부활 합니다.");
                hp = maxHp * 0.2;
                status = Status.ALIVE;
                lastResurrectTime = currentTime;
                System.out.println("(부활 후 HP : " + hp + ")");
            } else {
                System.out.println("부활 재사용 대기시간이 아직 남아 있습니다. (남은 재사용 대기시간 : " + (cooltime - (currentTime - lastResurrectTime)) / 1000L + ")");
            }
        }
    }
    public final void airBorne(Champion target) {
        target.status = Status.AIRBORNE;
        long currentTime = System.currentTimeMillis();
        target.airBorneTime = currentTime + 1000L;
        System.out.println("상태 : 공중에뜸!");
    }

    public final void stunned(Champion target) {
        target.status = Status.STUNNED;
        long currentTime = System.currentTimeMillis();
        target.stunnedTime = currentTime + 1000L;
        System.out.println("상태 : 스턴!");
    }

    public final boolean statusAlive() {
        long currentTime = System.currentTimeMillis();
        if (status == Status.AIRBORNE && currentTime >= airBorneTime) {
            status = Status.ALIVE;
        } else if (status == Status.STUNNED && currentTime >= stunnedTime) {
            status = Status.ALIVE;
        }

        if(status == Status.AIRBORNE) {
            System.out.println("에어본 상태로 행동할 수 없습니다.");
            return false;
        } else if (status == Status.STUNNED) {
            System.out.println("스턴 상태로 행동할 수 없습니다.");
            return false;
        }
        return true;
    }

    public boolean canSkillUse(String skillName, long coolTime) {
        long currentTime = System.currentTimeMillis();
        long lastUse = coolTimeMap.getOrDefault(skillName, 0L);
        return lastUse == 0 || ((currentTime - lastUse) >= coolTime);
    }

    public void SkillUse(String skillName) {
        long currentTime = System.currentTimeMillis();
        coolTimeMap.put(skillName, currentTime);
    }

    public void basicAttack(Champion target) {
        if (!statusAlive()) {
            return;
        }
        double chance = 0.1;
        int fetalDamage = 0;
        if (target.status == Status.DEAD) {
            System.out.println(target.getName() + "이(가) 이미 사망하였습니다. 대상을 찾을 수 없습니다.");
            return;
        }
        if (Math.random() < chance) {
            System.out.println(name + " -> " + target.name + " 치명타 공격!");
            fetalDamage = attackDamage * 2;
            target.takeDamage(fetalDamage);
        } else {
            System.out.println(name + " -> " + target.name + " 기본 공격!");
            target.takeDamage(attackDamage);
        }
        recoverMp(2);
        killedChampion(target);
    }

    public void takeShield(int shieldValue) {
        shield = shield + shieldValue;
        System.out.println(name + " 쉴드량 " + shield + " 증가 (남은 쉴드 : " + shield + ")");
    }

    public double takeHeal(int healing) {
        if (maxHp > (hp + healing)) {
            hp = hp + healing;
            System.out.println(name + " 체력 " + healing + " 회복 (남은 체력 : " + hp + ")");
            return hp;
        } else if (maxHp == hp) {
            System.out.println("이미 " + getName() + " 체력이 가득 차 있습니다.");
            return hp;
        } else if((hp + healing) > maxHp){
            System.out.println(name + " 체력 " + (maxHp - hp) + " 회복 (남은 체력 : " + maxHp + ")");
            hp = maxHp;
            return hp;
        }
        return hp;
    }

    public void plusExp(int plusE) {
        expClass.addExp(plusE);
    }
    public final void levelUpBonus(int level) {
            hp = hp + 50;
            maxHp = maxHp + 50;
            attackDamage = attackDamage + 4;
            defence = defence + 5;
            resurrectCoolTime = resurrectCoolTime + 5;
            System.out.println("체력 + 50, 공격력 + 4, 방어력 + 5");
    }

    public String getName() {
        return name;
    }
    public int getAttackDamage() {
        return attackDamage;
    }
    public int getShield() {
        return shield;
    }
    public double getHp() {
        return hp;
    }
    public int getMp() {
        return mp;
    }



    public abstract void skill1(Champion target);

    public abstract void skill2(Champion target);

    public abstract void skill3(Champion target);

    public abstract void skill4(Champion target);

    public abstract void passiveSkill();

    public abstract void passiveSkill2(Champion target);


}
