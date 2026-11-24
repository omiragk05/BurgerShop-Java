
class Tools {
    private static Burger[] burgerArray = new Burger[0];

    public static boolean addBurger(Burger burger) {
        extendBurgerArray();
        burgerArray[burgerArray.length - 1] = burger;
        return true;
    }

    private static void extendBurgerArray() {
        Burger[] tempBurgerArray = new Burger[burgerArray.length + 1];
        for (int i = 0; i < burgerArray.length; i++) {
            tempBurgerArray[i] = burgerArray[i];
        }
        burgerArray = tempBurgerArray;
    }

    public static Burger searchBurger(String id) {
        for (int i = 0; i < burgerArray.length; i++) {
            if (burgerArray[i].getId().equalsIgnoreCase(id)) {
                return burgerArray[i];
            }
        }
        return null;
    }

    public static Burger[] getAllBurgers() {
        return burgerArray;
    }

    public static String generateBurgerId() {
        if (burgerArray.length == 0) {
            return "O001";
        }
        String lastBurgerId = burgerArray[burgerArray.length - 1].getId();
        int lastBurgerIdNo = Integer.parseInt(lastBurgerId.substring(1));
        return String.format("O%03d", lastBurgerIdNo + 1);
    }
    public static String generateCustomerId() {
        if (burgerArray.length == 0) {
            return "C001";
        }
        String lastCustomerId = burgerArray[burgerArray.length - 1].getId();
        int lastCustomerIdNo = Integer.parseInt(lastCustomerId.substring(1));
        return String.format("C%03d", lastCustomerIdNo + 1);
    }

    

    public static boolean updateBurger(Burger burger) {
        int index = indexOf(burger);
        if (index != -1) {
            burgerArray[index] = burger;
            return true;
        }
        return false;
    }

    public static int indexOf(Burger burger) {
        for (int i = 0; i < burgerArray.length; i++) {
            if (burgerArray[i].getId().equalsIgnoreCase(burger.getId())) {
                return i;
            }
        }
        return -1;
    }
}