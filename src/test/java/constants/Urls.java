package constants;

public class Urls {

    /**
     * Adresy Url do strony głównej sklepu "automationpractice"
     */
    private static final String TEST_URL = "";
    private static final String STAGE_URL = "";
    private static final String PROD_URL = "http://automationpractice.com/index.php";

    public static String getApUrl(){
        String env = System.getProperty("enviroment");
        if (env == null) env = "";
        return switch (env) {
            case "test" -> TEST_URL;
            case "stage" -> STAGE_URL;
            default -> PROD_URL;
        };
    }
}
