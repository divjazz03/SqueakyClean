/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package squeakyclean;

import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ASUS
 */
public class SqueakyClean {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(clean("my\u008fid"));
    }
    
    static String clean(String identifier){
        return toCamelCase(identifier.split(""))
                            .stream()
                            .filter(c -> !c.equals(""))
                            .map(c -> c.equals(" ") ?"_":c)
                            .map(c -> Character.isISOControl(c.charAt(0)) ? "CTRL" : c)
                            .map(c -> ((c.charAt(0) >= 'α' && c.charAt(0) <= 'ω') || (!Character.isAlphabetic(c.charAt(0)) && !c.equals("_")))? "": c)
                            .collect(Collectors.joining());
    }
    
    static List<String> toCamelCase(String[] list){
        int[] indices = IntStream.range(0, list.length).filter(i -> list[i].equals("-")).toArray();
        for (int i : indices) list[i+1]=list[i+1].toUpperCase();
        return Arrays.stream(list).filter(c -> !c.equals("-")).collect(Collectors.toList());
            
        
    }
    
}
