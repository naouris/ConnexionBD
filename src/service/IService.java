/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

/**
 *
 * @author Elife-Sil-049
 */
public interface IService<T> {
    void ajouter(T t);
    void delete(int id);
    List<T> displayAll();
    T readById(int id);
    
}
