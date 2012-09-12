package dBOrderingSystem.labWork;

import java.util.Date;

/**
 * This class is called an "Entity" class in the SOA Architecture. It represents
 * a table in the database. Instances of this class represent records in that
 * table.
 * 
 * @author instlogin
 */
public class MenuItem implements Comparable {
    private int id;
    private String name;
    

    public MenuItem() {
    }

    public MenuItem(int id, String lastName, String firstName, String email, Date hireDate) {
        this.id = id;
        this.name = lastName;
        }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MenuItem other = (MenuItem) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        return hash;
    }

    // Sort on LastName
    public int compareTo(Object obj) {
        MenuItem e = (MenuItem)obj;
        return this.getName().compareTo(e.getName());
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name;
    }

    
}
