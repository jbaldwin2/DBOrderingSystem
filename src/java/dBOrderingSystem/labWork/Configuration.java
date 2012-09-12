package dBOrderingSystem.labWork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.Properties;

/**
 * This is a utility class for reading configuration files.
 *
 * @author Jim Lombardo
 * @version 2.01
 */
public class Configuration {
    private Properties props;

    /**
     * Constructor reads all key value pairs from a supplied properties file.
     * Requires that a config.properties file live in the "default" package,
     * and that the file be formatted using standard java properties
     * key=value pairs format.
     */
    public Configuration() {
        // Figure out where the class files live -- this is where
        // the .properties file is as well
        Class cls = this.getClass();
        ProtectionDomain pDomain = cls.getProtectionDomain();
        CodeSource cSource = pDomain.getCodeSource();
        URL loc = cSource.getLocation();
        String configFilePath = loc.getPath();

        File file = new File(configFilePath + "/config.properties");
        String debug = file.getAbsolutePath();
        System.out.println(debug);
        BufferedReader in = null;
        try {
            props = new Properties();
            in = new BufferedReader(new FileReader(file));
            props.load(in);
        } catch (Exception ex) {
             throw new RuntimeException("Cannot load properties file", ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                throw new RuntimeException("Cannot close file stream");
            }
        }
    }

    /**
     * This version of the constructor lets you pass in a complete file path
     * for .properties file that has any name you choose, plus any location.
     * Constructor reads all key value pairs from a supplied properties file.
     * Requires standard java properties file format containing key=value pairs.
     *
     * @param configFilePath - the absolute or relative path to a properties
     *  file, including the complete file name.
     * <P>
     * Absolute Example: C:/temp/myconfig.properties
     * <P>
     * Relative Example: (relative to project directory) myconfig.properties
	 * @throws RuntimeException if properties file cannot be read or file connection
	 * cannot be closed.
     */
    public Configuration(String configFilePath) {
        File file = new File(configFilePath);
        //String debug = file.getAbsolutePath();
        //System.out.println(debug);
        BufferedReader in = null;
        try {
            props = new Properties();
            in = new BufferedReader(new FileReader(file));
            props.load(in);
        } catch (Exception ex) {
             throw new RuntimeException("Cannot load properties file", ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                throw new RuntimeException("Cannot close file stream");
            }
        }
    }

    /**
     * Retrieve a properties value as a int. NOTE: parameters are not
     * validated in any way.
     * @param key - the property key
     * @return an int parsed from the properties value
     * @throws NumberFormatException if value cannot be parsed to a int
     */
    public int getInteger(String key) {
        int value = 0;

        // retrieve the value as a String from config file
        String strValue = props.getProperty(key);
        // parse into a int if possible
        value = Integer.parseInt(strValue);

        return value;
    }

    /**
     * Retrieve a properties value as a long. NOTE: parameters are not
     * validated in any way.
     * @param key - the property key
     * @return an long parsed from the properties value
     * @throws NumberFormatException if value cannot be parsed to a long
     */
    public long getLong(String key) {
        long value = 0;

        // retrieve the value as a String from config file
        String strValue = props.getProperty(key);
        // parse into a long if possible
        value = Long.parseLong(strValue);

        return value;
    }

    /**
     * Retrieve a properties value as a boolean. NOTE: parameters are not
     * validated in any way.
     * @param key - the property key
     * @return an boolean parsed from the properties value
     * @throws NumberFormatException if value cannot be parsed to a boolean
     */
    public boolean getBoolean(String key) {
        boolean value = false;

        // retrieve the value as a String from config file
        String strValue = props.getProperty(key);
        // parse into a boolean if possible
        value = Boolean.parseBoolean(strValue);

        return value;
    }

    /**
     * Retrieve a properties value as a double. NOTE: parameters are not
     * validated in any way.
     * @param key - the property key
     * @return a double parsed from the properties value
     * @throws NumberFormatException if value cannot be parsed to a double
     */
    public double getDouble(String key) {
        double value = 0.00;

        // retrieve the value as a String from config file
        String strValue = props.getProperty(key);
        // parse into a double if possible
        value = Double.parseDouble(strValue);

        return value;
    }

    /**
     * Retrieve a properties value as a String
     * @param key - the property key
     * @return the String value
     */
    public String getString(String key) {
        String name = "Unknown";

        // retrieve the value as a String from config file
        name = props.getProperty(key);

        return name;
    }

    /**
     * Retrieves a programmatically instantiated object from a fully
     * qualified class name (must include package name).
     * @param key - the property key representing the class name
     * @return a plain Object that must be cast to its original data type.
     * @throws a RuntimeException if the object cannot be created due to
     * an ill-formed fully qualified class name.
     */
    public Object getObject(String key) {
        String className = null;
        Object obj = null;

        try {
            // retrieve class name from config file
            className = props.getProperty(key);

            // Create 'Class' objects
            Class theClass = Class.forName(className);

            // use the 'Class' objects to create instances of behaviors
            obj = theClass.newInstance();
        } catch(InstantiationException e) {
            throw new RuntimeException("Cannot instantiate object because: "
                    + e.getMessage());
        } catch(IllegalAccessException iae) {
            throw new RuntimeException("Error: you do not have read access "
                    + "privileges for the .properties file");
        } catch(ClassNotFoundException cne) {
            throw new RuntimeException("Error: cannot find class referenced "
                    + " in .properties file. Make sure you use fully "
                    + "qualified name, and check your spelling!");
        }

        return obj;
    }
}
