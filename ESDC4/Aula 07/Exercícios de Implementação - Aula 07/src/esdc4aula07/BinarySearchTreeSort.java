/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esdc4aula07;

/**
 * Ordenação usando árvore binária de busca.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class BinarySearchTreeSort {

    public static <Type extends Comparable<Type>> void sort( Type[] array ) {

        //Criando Arvore
        BinarySearchTreeDupKeys SortTree = new BinarySearchTreeDupKeys();
        for(Type key : array){
            SortTree.put(key);
        }
        
        //Ordenando Array
        int i=0;
        for(Object Key : SortTree.traverse(TraversalTypes.INORDER)){
            array[i] = (Type)Key;
            i++;
        }
        
    }   
    
}