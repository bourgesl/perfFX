package test;

/**
 * JVM bootstrap
 */
public final class Bootstrap {

    public static void main(String[] args) {
        /*
         * Workaround to set system properties in GraalVM / Substrate VM (native images)
         */
        setDefaultSystemProperty("javafx.verbose", "true");
        setDefaultSystemProperty("prism.verbose", "true");
        setDefaultSystemProperty("javafx.animation.fullspeed", "true");

        setDefaultSystemProperty("prism.marlin.log", "true");
        setDefaultSystemProperty("prism.marlin.useRef", "hard"); // hard or soft (default) / weak references

        setDefaultSystemProperty("prism.marlin.doStats", "false");

        System.out.println("System properties:\n" + System.getProperties());
        
        TrianglePerformanceTest.main(args);
    }

    private static void setDefaultSystemProperty(String key, String value) {
        if (System.getProperty(key) == null) {
            System.setProperty(key, value);
        }
    }

}
