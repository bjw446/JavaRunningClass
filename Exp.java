package task01;

public class Exp {
    private int basicExp;
    private int exp;
    private int level;
    private Champion user;

    public Exp(){
        this.basicExp = 100;
        this.exp = 0;
        this.level = 1;
    }
    public Exp(Champion user) {
        this.user = user;
    }
    public void addExp(int addE) {
        exp = exp + addE;
        levelUp();
    }
    public final void levelUp() {
        System.out.println("획득 경험치 : " + exp);
        if (level >= GameConstants.MAX_LEVEL){
            System.out.println("이미 최고 레벨입니다!");
        }
        while (exp >= basicExp) {
            exp = exp - basicExp;
            level++;
            exp = 0;
            System.out.println("레벨업!!! 능력치가 상승합니다.");
            user.levelUpBonus(level);
            basicExp = basicExp + 300;
        }
    }

    public int getLevel() {
        return level;
    }
    public int getExp() {
        return exp;
    }
    public int getBasicExp() {
        return basicExp;
    }
}




