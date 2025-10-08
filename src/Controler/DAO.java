/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controler;

import java.util.List;

/**
 *
 * @author AB Computers
 */
interface DAO<Table> {

    public void ajouter(Table entite);

    public void modifier(Table entite);

    public void supprimer(Table entite);

    public void imprimer(Table entier);

    public void annuler(Table entier);

    public List<Table> list();

    public Table get(int id);
}
