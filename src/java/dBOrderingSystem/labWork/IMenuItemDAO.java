/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dBOrderingSystem.labWork;

import java.util.List;

/**
 *
 * @author Instlogin
 */
public interface IMenuItemDAO {

    List<MenuItem> getMenuItemList() throws Exception;
    void init() throws Exception ;
}
