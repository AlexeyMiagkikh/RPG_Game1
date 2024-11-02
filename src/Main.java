import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int playerHealth = 100;
        int playerDamage = 10;
        int playerExperience = 0;
        int playerLevel = 1;
        String[] enemyNames = new String[]{"Орк", "Гоблин", "Великан", "Даэдра", "Дракон"};
        int[] enemyHealths = new int[]{50, 30, 80, 120, 150};
        int[] enemyDamages = new int[]{8, 5, 12, 20, 25};
        boolean isGameRunning = true;

        while (isGameRunning) {
            System.out.println("Ваш персонаж имеет: " + playerHealth + " здоровья");
            System.out.println("Ваш опыт: " + playerExperience + " / 100");
            System.out.println("Ваш уровень: " + playerLevel);
            System.out.println("Ваш урон: " + playerDamage);
            System.out.println("Выберите одно из следующих действий: 1 Пойти в лес ; 2 Отхилиться (+25 HP) ; 3 Отправиться в пещеру");
            System.out.println("4 Исследовать Город Теневой порт ; 5 Исследовать локацию Пик Древних");
            System.out.println(" ");
            int choice = sc.nextInt();
            boolean isBattle;
            int choicePlayer;
            int abilityDamage;

            switch (choice) {
                case 1:
                    System.out.println("Вы отправились в лес");
                    System.out.println("Вы встретили Орка! Он злобно настроен и хочет вас убить!");
                    String enemyName = enemyNames[0];
                    int enemyHealth = enemyHealths[0];
                    int enemyDamage = enemyDamages[0];
                    isBattle = true;

                    while (isBattle) {
                        System.out.println("1 - Основная Атака; 2 - Использовать способность (двойной урон)");
                        choicePlayer = sc.nextInt();
                        if (choicePlayer == 1) {
                            System.out.println("Вы атакуете " + enemyName + " и наносите " + playerDamage + " урона.");
                            enemyHealth -= playerDamage;
                        } else if (choicePlayer == 2) {
                            abilityDamage = playerDamage * 2;
                            System.out.println("Вы используете способность и наносите " + abilityDamage + " урона.");
                            enemyHealth -= abilityDamage;
                        } else {
                            System.out.println("Вы выбрали выход из боя.");
                            isBattle = false;
                            continue;
                        }

                        if (enemyHealth <= 0) {
                            System.out.println("Вы победили " + enemyName + "!");
                            playerExperience += 50;
                            System.out.println(" ");
                            break;
                        }

                        System.out.println(enemyName + " атакует вас и наносит " + enemyDamage + " урона.");
                        playerHealth -= enemyDamage;
                        if (playerHealth <= 0) {
                            isGameRunning = false;
                            isBattle = false;
                            System.out.println("Вы проиграли");
                            System.out.println(" ");
                        }
                    }

                    if (playerExperience >= 100) {
                        playerLevel++;
                        playerDamage += 2;
                        playerHealth = 100;
                        playerExperience %= 100;
                        System.out.println("Поздравляем! Ваш уровень повышен до: " + playerLevel + ".");
                        System.out.println(" ");
                    }
                    continue;

                case 2:
                    playerHealth += 25;
                    if (playerHealth > 100) {
                        playerHealth = 100;
                    }
                    System.out.println("Вы отдохнули, ваше здоровье: " + playerHealth);
                    System.out.println(" ");
                    continue;

                case 3:
                    System.out.println("Вы отправились в пещеру");
                    System.out.println("Здесь темно с сыро... Следует оставить это место на будущее");
                    System.out.println(" ");
                    continue;

                case 4:
                    System.out.println("Вы идете в город...");
                    Thread.sleep(2000L);
                    System.out.println("Вы видите огромные стены, большие защищенные ворота для входа");
                    Thread.sleep(2000L);
                    System.out.println("Вы заходите в город");
                    Thread.sleep(2000L);
                    System.out.println("Город довольно богат.");
                    Thread.sleep(2000L);
                    System.out.println("Следует отдохнуть. Дорога была нелегкой. Куда пойти?: 1 Гостиница(отдохнуть); 2 Таверна (выпить)");
                    Thread.sleep(2000L);
                    System.out.println(" ");
                    Thread.sleep(2000L);
                    choicePlayer = sc.nextInt();
                    if (choicePlayer == 1) {
                        System.out.println("Вы зашли в гостиницу. Легкий теплый ветерок пробежался по телу. Вам комфортно");
                        Thread.sleep(2000L);
                        System.out.println("Эгл: Здравствуй странник. Желаешь арендовать комнату? 1. Да , 2. Нет (умереть)");
                        Thread.sleep(2000L);
                        abilityDamage = sc.nextInt();
                        if (abilityDamage == 1) {
                            System.out.println("Эгл: Твоя комната №2. Не забудь вернуть ключи");
                            System.out.println("Вы идете в комнату");
                            Thread.sleep(2000L);
                            System.out.println("В комнате тепло и уютно, вас клонит в сон...");
                            Thread.sleep(2000L);
                            System.out.println("Вы крепко заснули");
                            System.out.println("1...");
                            Thread.sleep(2000L);
                            System.out.println("2...");
                            Thread.sleep(2000L);
                            System.out.println("3...");
                            Thread.sleep(2000L);
                            System.out.println("Вы просыпаетесь, и чувствуете что вы хорошо отдохнули, вы здоровы!. Вы покинули город ");
                            playerHealth += 50;
                            if (playerHealth > 100) {
                                playerHealth = 100;
                            }
                            System.out.println("Вы отдохнули, ваше здоровье: " + playerHealth);
                            System.out.println(" ");
                        } else {
                            System.out.println("Вы умерли от недостатка отдыха");
                        }
                    } else if (choicePlayer == 2) {
                        System.out.println("Вы вошли в таверну");
                        Thread.sleep(2000L);
                        System.out.println("Мак: Желаешь выпить, незнакомец? 1 Да / 2 Нет (уйти из города)");
                        Thread.sleep(2000L);
                        abilityDamage = sc.nextInt();
                        if (abilityDamage == 1) {
                            System.out.println("Вы выпили, вы чувствуете себя не очень, вас уложили спать");
                            System.out.print("В нетрезвом состоянии вы решаете покинуть город");
                        }
                    }
                    continue;

                case 5:
                    System.out.println("Вы отправились на Пик Древних, слышите громкие звуки в небе, но никого не видите, кто это может быть?");
                    System.out.println("Вы увидели дракона");
                    System.out.println("Он начал испепелять вас огнем");

                    boolean IsBattle = true;

                    while (IsBattle) {
                        System.out.println("1 - Основная Атака; 2 - Использовать способность (двойной урон); 3 - Уйти из боя");
                        int choicePlayer2 = sc.nextInt();

                        if (choicePlayer2 == 1) {
                            System.out.println("Вы атакуете " + enemyNames[4] + " и наносите " + playerDamage + " урона.");
                            enemyHealths[4] -= playerDamage;
                        } else if (choicePlayer2 == 2) {
                            abilityDamage = playerDamage * 2;
                            System.out.println("Вы используете способность и наносите " + abilityDamage + " урона.");
                            enemyHealths[4] -= abilityDamage;
                        } else {
                            System.out.println("Вы выбрали выход из боя.");
                            return;
                        }

                        if (enemyHealths[4] <= 0) {
                            System.out.println("Вы победили " + enemyNames[4] + "!");
                            playerExperience += 50;
                            System.out.println(" ");
                            return;
                        }

                        System.out.println(enemyNames[4] + " атакует вас и наносит " + enemyDamages[4] + " урона.");
                        playerHealth -= enemyDamages[4];

                        if (playerHealth <= 0) {
                            System.out.println("Вы проиграли!");
                            System.out.println(" ");
                            break;
                        }
                    }

                default:
                    System.out.println("Вы ввели неверную команду!");
            }
        }
    }
}