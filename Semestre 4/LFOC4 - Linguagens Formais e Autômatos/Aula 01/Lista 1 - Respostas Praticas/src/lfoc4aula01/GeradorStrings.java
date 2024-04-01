package lfoc4aula01;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Métodos para geração de strings de alfabetos.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class GeradorStrings {

    public static void main( String[] args ) {
        
        System.setOut( new PrintStream( new FileOutputStream(FileDescriptor.out), true, StandardCharsets.UTF_8 ) );
        System.setErr( new PrintStream( new FileOutputStream(FileDescriptor.err), true, StandardCharsets.UTF_8 ) );
        
        int k = 6;
        char[] a = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm' };
        testeGerarStringsK( k, a );
        testeGerarStringsAteK( k, a );
        
    }
    
    public static List<String> gerarStringsK( int k, char... a )
            throws IllegalArgumentException {
        
        if ( k < 0 ) {
            throw new IllegalArgumentException( "comprimento negativo" );
        }
        
        if ( a == null || a.length == 0 ) {
            throw new IllegalArgumentException( "alfabeto vazio" );
        }
        
        List<String> s = new ArrayList<>();
        
        if(k==0){
            s.add("");
        } else {            
            
            StringBuilder str = new StringBuilder();
            
            /* Criando a primeira String e Adicionando a Lista */
            for(int i=0; i<k; i++){ str.append(a[0]); }
            s.add(str.toString());
            
            /* Criando um Array que representa os simbolos do alfabeto como números, e atribuindo valor '0' a eles 
            (desta forma, torna-se possível utilizar operadores lógicos, mesmo que o alfabeto original não permita 
            (por exemplo, se o alfabeto fosse constituido por emotes) */
            int[] indexOfA = new int[k];
            for(int i=0; i<k; i++){ indexOfA[i] = 0; }
            
            
            while( s.size() < Math.pow(a.length, k) ){
                
                for(int i=0; i<k; i++){
                    
                    if(indexOfA[i] < a.length-1){
                        
                        indexOfA[i]++;
                        break;
                        
                    } else if (indexOfA[i] == a.length-1){ 
                        
                        indexOfA[i]=0; 
                        
                    }
                    
                }
                
                for(int i=0; i<k; i++){
                    str.setCharAt(i, a[indexOfA[i]]);
                }
                
                s.add(str.toString());
            }
        }

        Collections.sort(s);
        return s;
        
    }
    
    public static List<String> gerarStringsAteK( int k, char... a ) throws IllegalArgumentException {
        
        if ( k < 0 ) {
            throw new IllegalArgumentException( "comprimento negativo" );
        }
        
        if ( a == null || a.length == 0 ) {
            throw new IllegalArgumentException( "alfabeto vazio" );
        }
        
        List<String> s = new ArrayList<>();
        
        for(int i=0; i<=k; i++){
            
            s.addAll(gerarStringsK(i, a));
            
        }

        return s;
        
    }

    private static void testeGerarStringsK( int k, char... a ) throws IllegalArgumentException {
        
        for ( int i = 0; i <= k; i++ ) {
            
            if ( i == 0 ) {
                System.out.println( "\u03A3^0 = {\u03B5}" );
            } else {
                
                System.out.printf( "\u03A3^%d = {", i );
                boolean primeiro = true;

                for ( String s : gerarStringsK( i, a ) ) {
                    if ( !primeiro ) {
                        System.out.print( ", " );
                    }
                    System.out.print( s );
                    primeiro = false;
                }

                System.out.print( "}" );
                System.out.println();
                
            }
            
        }
        
    }
    
    private static void testeGerarStringsAteK( int k, char... a ) throws IllegalArgumentException {
        
        System.out.print( "\u03A3*  = {\u03B5, " );

        for ( String s : gerarStringsAteK( k, a ) ) {
            System.out.print( s );
            System.out.print( ", " );
        }

        System.out.print( "...}" );
        System.out.println();
        
    }
    
}
