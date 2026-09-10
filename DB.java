public class DB {

    static public Object[][] mobs = new Object[][] {
        // Name, health, damage, balancetime, aggressive
        {"Ogre", 1000, 50, 3.0, true},
        {"Goblin", 500, 10, 2.0, true},
        {"Frog", 10, 1, 1.0, false},
        {"Butterfly", 40, 1, 1.5, false},
    };

    // Returns mob that is same as name
    static public Object[] mobsReturn(String name) {
        for (Object[] returnMob : mobs) {
            if (name == returnMob[0]) {
                return returnMob;
            }
        }
        return mobs[0];
    }

    // Returns mob from index in database
    static public Object[] mobsReturn(int index) {
        return mobs[index];
    }
    
}
