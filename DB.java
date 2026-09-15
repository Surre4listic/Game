public class DB {

    static public Object[][] mobs = new Object[][] {
        // Name, health, damage, balancetime, exp, aggressive
        {"Rat", 25, 2, 1.0, 10, false},
        {"Snake", 50, 5, 1.5, 25, false},
        {"Wolf", 100, 10, 2.0, 50, true},
        {"Bear", 200, 20, 3.0, 100, true},
        {"Dragon", 1000, 100, 5.0, 500, true},
        {"Slime", 30, 3, 1.0, 15, false},
        {"Zombie", 150, 15, 2.5, 75, true},
        {"Skeleton", 75, 7, 1.5, 35, true},
        {"Vampire", 300, 30, 4.0, 150, true},
        {"Werewolf", 400, 40, 4.5, 200, true},
        {"Giant Spider", 250, 25, 3.5, 125, true},
        {"Troll", 500, 50, 5.0, 250, true},
        {"Demon", 800, 80, 6.0, 400, true},
        {"Ogre", 750, 50, 3.0, 375, true},
        {"Goblin", 500, 10, 2.0, 250, true},
        {"Frog", 10, 1, 1.0, 5, false},
        {"Butterfly", 40, 1, 1.5, false},
    };

    static public Object[][] levels = new Object[][] {
        // Level, exp required
        {1, 0},
        {2, 100},
        {3, 200},
        {4, 300},
        {5, 400},
        {6, 500},
        {7, 600},
        {8, 700},
        {9, 800},
        {10, 900},
        {11, 1000}
    };


    
}
