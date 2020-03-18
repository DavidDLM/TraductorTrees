/**
 * @author Mario de Leon
 * @author Derek Banas
 * 
 *
 * Codigo del arbol binario y de un nodo codificado con
 * ayuda de BINARY TREE IN JAVA por Derek Banas:
 * http://www.newthinktank.com/2013/03/binary-tree-in-java/
 * 
 */
public class BinarySearchTree{
	
	Nodo raiz;
	
	public void addNodo(String ingles, String espaniol) {
		
		Nodo nodo = new Nodo(ingles,espaniol);
		
		if(raiz != null) {
			
			//Establecer la raiz
			Nodo esteNodo = raiz;
			//Padre del nodo
			Nodo padre;
			
			while (true) {
				//Se comienza desde la raiz				
				padre = esteNodo;
				//Agregar nodo (ya sea izq o der)
				if(ingles.compareTo(esteNodo.ingles) <= 0) {
					//Este nodo va a la izq
					esteNodo = esteNodo.hijoIzq;
					
					if(esteNodo == null) {
						padre.hijoIzq = nodo;
						return;
					}
				}else { //Nodo va en la derecha
					esteNodo = esteNodo.hijoDer;
					if(esteNodo == null) {
						padre.hijoDer = nodo;
						return;
					}
				}
			}
		}else { //Si no hay raiz, este se vuelve raiz
			raiz = nodo;
		}
	}
	
	public Nodo findNodo(String ingles) {
		//Se comienza desde arriba
		Nodo esteNodo = raiz;
		
		//Si no se encuentra se sigue buscando
		while(esteNodo.ingles != ingles) {
			//Izq
			if(ingles.compareTo(esteNodo.ingles)<0) {
				esteNodo = esteNodo.hijoIzq;
			}else {
				esteNodo = esteNodo.hijoDer;
			}
			//Si no hay nodo
			if(esteNodo==null) {
				return null;
			}
		}
		return esteNodo;
	}
	
	
	//Ordenamiento del arbol: inOrder, preOrder, postOrder
	
	public void inOrder(Nodo esteNodo) {
		if(esteNodo != null) {
			//Nodo izq
			inOrder(esteNodo.hijoIzq);
			//Nodo actual
			System.out.println(esteNodo);
			//Nodo der
			inOrder(esteNodo.hijoDer);
		}
	}
	
	public void preOrder(Nodo esteNodo) {
		if(esteNodo != null) {
			System.out.println(esteNodo);
			//Nodo izq
			inOrder(esteNodo.hijoIzq);			
			//Nodo der
			inOrder(esteNodo.hijoDer);
		}
	}
	
	public void postOrder(Nodo esteNodo) {
		if(esteNodo != null) {
			//Nodo izq
			inOrder(esteNodo.hijoIzq);			
			//Nodo der
			inOrder(esteNodo.hijoDer);
			System.out.println(esteNodo);
		}
	}	
}


class Nodo{
	String ingles;
	String espaniol;
	Nodo hijoIzq;
	Nodo hijoDer;
	
	public String getIngles() { return ingles; }
	public String getEspaniol() { return espaniol; }
	
	Nodo(String ingles, String espaniol){
		this.ingles = ingles;
		this.espaniol = espaniol;
	}
	
	public String toString() {
		return ingles + " es " + espaniol;
	}
}