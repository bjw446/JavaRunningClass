package task01;

public class main {
    public static void main(String[] args) {

        Leesin leesin = new Leesin("리신");
        Nidalee nidalee = new Nidalee("니달리");
        Jarvan jarvan = new Jarvan("자르반");
        Sylas sylas = new Sylas("사일러스");

        nidalee.basicAttack(leesin);
        jarvan.basicAttack(leesin);
        sylas.basicAttack(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        System.out.println("----------------");

        sylas.skill1(nidalee);
        sylas.skill2(nidalee);
        sylas.skill3(nidalee);
        sylas.skill4(nidalee);
        System.out.println("----------------");

        leesin.skill1(jarvan);
        leesin.skill2(jarvan);
        leesin.skill3(jarvan);
        leesin.skill4(jarvan);
        System.out.println("----------------");

        jarvan.skill1(sylas);
        jarvan.skill2(sylas);
        jarvan.skill3(sylas);
        jarvan.skill4(sylas);
        System.out.println("----------------");

        nidalee.skill1(leesin);
        nidalee.skill2(leesin);
        nidalee.skill3(leesin);
        nidalee.skill4(leesin);
        nidalee.skill1(leesin);
        nidalee.skill2(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        nidalee.skill3(leesin);
        nidalee.skill1(leesin);
        nidalee.skill1(leesin);
        nidalee.skill1(leesin);
        nidalee.skill1(leesin);
        nidalee.skill1(leesin);
        nidalee.skill1(leesin);
        nidalee.skill1(leesin);

        System.out.println(leesin.getBattleCount());
        System.out.println(jarvan.getBattleCount());
        System.out.println(nidalee.getBattleCount());
        System.out.println(sylas.getBattleCount());



    }
}


