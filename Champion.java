package task01;

public abstract class Champion {
    private String name;
    private int hp;
    private int maxHp;
    private int attackDamage;
    private int defence;
    private int shield;
    private Exp expClass;
    private int mp;

    public Champion(String name, int hp, int maxHp, int mp, int attackDamage, int defence) {
        this.attackDamage = attackDamage;
        this.defence = defence;
        this.hp = hp;
        this.maxHp = maxHp;
        this.name = name;
        this.mp = mp;
        this.expClass = new Exp(this);
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
        if(shield >= damage){
            shield = shield - damage;
            shieldDamage = 0;
        }else if ((shield - damage) < 0) {
            shieldDamage = damage - shield;
        }

        int actualDamage = shieldDamage - defence;
        if (actualDamage < 0) {
            actualDamage = 0;
        }

        if ((hp - actualDamage) <= 0) {
            System.out.println(name + " 사망!!!" );
            shield = 0;
            hp = 0;
        }else {
            hp = hp - actualDamage;
            shield = 0;
            System.out.println(name + "이(가) " + actualDamage + " 피해를 입음! (남은 HP : " + hp + ")");
        }
    }

    public void killedChampion(Champion target){
        if (target.getHp() <= 0) {
            System.out.println(name + "이(가) " + target.getName() + "을(를) 처치하여 경험치를 얻었습니다." );
            plusExp(100);
        }
    }

    public void basicAttack(Champion target) {
        double chance = 0.1;
        int fetalDemage = 0;
        if(Math.random() < chance) {
            System.out.println(name + " -> " + target.name + " 치명타 공격!");
            fetalDemage = attackDamage * 2;
            target.takeDamage(fetalDemage);
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

    public int takeHeal(int healing) {
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
    public void levelUpBonus(int level) {
            hp = hp + 50;
            attackDamage = attackDamage + 4;
            defence = defence + 5;
            System.out.println("체력 + 100, 공격력 + 4, 방어력 + 5");
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
    public int getHp() {
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
