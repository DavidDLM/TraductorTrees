import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 
 */

/**
 * @author Mario de Leon
 *
 */
public class MainTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<String, String> tree = new TreeMap<String, String>();
		BinarySearchTree bst = new BinarySearchTree();
		
		String path = (new File("")).getAbsolutePath()+File.separator+"src"+File.separator+"diccionario.txt";
		String path2 = (new File("")).getAbsolutePath()+File.separator+"src"+File.separator+"texto.txt";
		
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	    
	    File archivo2 = null;
	    FileReader fr2 = null;
	    BufferedReader br2 = null;
	      
	      try {
	         // Apertura del fichero y creacion de BufferedReader para poder
	         // hacer una lectura comoda (disponer del metodo readLine()).
	         archivo = new File (path);
	         fr = new FileReader (archivo);
	         br = new BufferedReader(fr);
	         
	         archivo2 = new File (path2);
	         fr2 = new FileReader (archivo2);
	         br2 = new BufferedReader(fr2);
	         
	         
	         // Lectura del fichero
	         String linea;
	         String linea2;
	         while((linea=br.readLine())!=null)
	         {
	        	//System.out.println(linea);
	        	
	        	String[] partes = linea.split(",",2);
	        	if(partes.length >= 2) {
	        		String k = partes[0];
	        		k = k.replaceAll("\\p{P}","");
	        		k = k.replaceAll(" ","");
	        		String v = partes[1];
	        		v = v.replaceAll("\\p{P}","");
	        		v = v.replaceAll(" ","");
	        		
	        		//System.out.println(k);
	        		//System.out.println(v);
	        		//map.put(k, v); tree.addNodo()
	        		//Add k es en ingles 
	        		//Add v en espaniol
	        		
	        		//El diccionario se crea
	        		tree.put(k, v);
	        		bst.addNodo(k, v);	
	        	}else {
	        		System.out.println("");;
	        	}	
    	
	         } while ((linea2=br2.readLine())!=null) {

	        	 String delimeters = "[. ]";
	        	 String[] oracion = linea2.split(delimeters);	        	
	        	 
	        	 ArrayList<String> temp = new ArrayList<String>();
	        	 
	        	 for(int i = 0; i<oracion.length; i++) {
	        		 temp.add("*"+oracion[i]+"*");
	        		 if(tree.containsKey(oracion[i])){
	        			 //System.out.println(tree.get(oracion[i]));
	        			 temp.set(i, tree.get(oracion[i]));
	        			 
	        		 }
	        	 }
	        	 /**
	        	 for(String parts: temp)	        		 
	        		 System.out.println(parts);
	        		 */
	        	 String final_sentence = temp.toString().replace('[', '\n');
	        	 final_sentence = final_sentence.replace(']', ' ');
	        	 final_sentence = final_sentence.replace(',', ' ');
	        	 System.out.print(final_sentence+".");
	         }
	      }
	      catch(Exception e){
	         System.out.println("Archivo no existe");
	         
	         
	      }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }		
	}

}
