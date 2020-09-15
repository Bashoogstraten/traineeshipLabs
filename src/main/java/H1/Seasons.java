package H1;

public class Seasons {
    public static void switchSeason() {
        Season season = Season.SPRING;
        switch (season) {
            case SPRING:
            case SUMMER:
                System.out.println(season + " is warm!");
                break;
            case FALL:
            case WINTER:
                System.out.println(season + " is cold!");
                break;
            default:
                System.out.println(season + " is unknown...");
        }

    }
}
enum Season {
    SPRING, SUMMER, FALL, WINTER, DRY, WET;
}
