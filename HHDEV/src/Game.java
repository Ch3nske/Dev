import java.util.Random;

public class Game {
    public static void main(String[] args) {
        Creature player = new Creature("Игрок", 20, 15, 100);
        Creature monster = new Creature("Монстр", 18, 12, 80);

        System.out.println("Стычка началась: " + player.getName() + " Против " + monster.getName());
        System.out.println(player.getName() + ": Жизни = " + player.getHealth());
        System.out.println(monster.getName() + ": Жизни = " + monster.getHealth());
        System.out.println();

        Random random = new Random();

        while (player.getHealth() > 0 && monster.getHealth() > 0) {
            Creature attacker = player;
            Creature defender = monster;
            int attackModifier = attacker.getAttack() - defender.getDefense() + 1;
            // бросок кубика
            int roll = random.nextInt(attackModifier * 6) + 1;
            // Проверка удара если выпала 5
            boolean successfulHit = roll >= 5;
            if (successfulHit) {
                int damage = random.nextInt(6) + 1; // Assuming attacker's damage range is 1-6
                defender.takeDamage(damage);
                System.out.println(attacker.getName() + " бьёт " + defender.getName() + " Нанося " + damage + " Урона");
                System.out.println(defender.getName() + ": Здоровье = " + defender.getHealth());
            } else {
                System.out.println(attacker.getName() + " промах");
            }
            System.out.println();
            // Следующий раунд
            Creature temp = attacker;
            attacker = defender;
            defender = temp;
        }

        // Подсчёт итога стычки
        if (player.getHealth() <= 0 && monster.getHealth() <= 0) {
            System.out.println("Ничья");
        } else if (player.getHealth() <= 0) {
            System.out.println("Монстр побеждает");
        } else {
            System.out.println("Игрок побеждает");
        }
    }
}
