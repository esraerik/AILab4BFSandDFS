import java.util.ArrayList;
import java.util.Random;
//UNIFORM COST SEARCH
public class UniformCost {
	private static boolean[] checked = new boolean[6];

	private final static int source = 0;
	static int pathcost[][] = new int[6][6];
	static int child[] = new int[6];

	public static void main(String[] args) {
		int graph[][] = new int[6][6];

		graph[0][0] = 0;// dizi ile graph oluþturuldu.
		graph[0][1] = 1;
		graph[0][2] = 0;
		graph[0][3] = 0;
		graph[0][4] = 1;
		graph[0][5] = 0;
		graph[1][0] = 0;
		graph[1][1] = 0;
		graph[1][2] = 1;
		graph[1][3] = 1;
		graph[1][4] = 0;
		graph[1][5] = 0;
		graph[2][0] = 0;
		graph[2][1] = 1;
		graph[2][2] = 0;
		graph[2][3] = 1;
		graph[2][4] = 0;
		graph[2][5] = 0;
		graph[3][0] = 0;
		graph[3][1] = 1;
		graph[3][2] = 1;
		graph[3][3] = 0;
		graph[3][4] = 0;
		graph[3][5] = 0;
		graph[4][0] = 0;
		graph[4][1] = 0;
		graph[4][2] = 0;
		graph[4][3] = 0;
		graph[4][4] = 0;
		graph[4][5] = 1;
		graph[5][0] = 0;
		graph[5][1] = 0;
		graph[5][2] = 0;
		graph[5][3] = 0;
		graph[5][4] = 0;
		graph[5][5] = 0;
		Random rnd = new Random();

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				if (graph[i][j] == 1) {
					pathcost[i][j] = rnd.nextInt(21);// 0 ile 20 arasýnda random sayý üretilir
					System.out.println("patcost" + i + " " + j + "="
							+ pathcost[i][j]); // Bu random sayýar nodelarýn maliyetini oluþturur.
				} else {
					pathcost[i][j] = -1;//komþu olmayan nodelar arasýndaki maliyet -1 olarak belirlenmiþtir.
				}

			}
		}

		uniform(graph, source);
	}

	private static void uniform(int[][] graph, int source) {
		int parentVertex;
		for (int i = 0; i < 6; i++) {// ziyaret edilmemiþ node lar false olarak
										// initiliaze edildi.
			checked[i] = false;
		}
		
	
		ArrayList<Integer> parentsQueue = new ArrayList<Integer>();
		checked[source] = true;// source ziyaret edildi.

		parentsQueue.add(source);// source kuyruða eklendi
	
		while (!parentsQueue.isEmpty()) {
			int j = 0;
			for (int i = 0; i < 6; i++) {
				child[i] = 0;
			}

			parentVertex = parentsQueue.remove(0);// kuyruktan çekilen
													// önceden ziyart
													// edilmiþ node
													// parentVertex
													// deðiþkenine alýndý
		

			Boolean durum=findChild(graph, parentVertex);
			if(durum==false)
				break;
		
			
				int yeniVertex=compareChilds(parentVertex, child);
				if (!checked[yeniVertex]) {

					System.out.println(parentVertex + "--" + yeniVertex);

					checked[yeniVertex] = true;

					parentsQueue.add(yeniVertex);
					
					parentVertex=yeniVertex;
		}
	}}
		

	public static int compareChilds(int parentVertex, int[] child) {
		int min = 21;
		int index = 0;
		for (int i = 0; i < child.length; i++) {
			if (pathcost[parentVertex][child[i]] != -1
					&& pathcost[parentVertex][child[i]] <= min) {
				min = pathcost[parentVertex][child[i]];
				index = i;
			}

		}
		System.out.println("child" + child[index]);
		System.out.println("Child min path cost" + min);
		return child[index];
	}

	public static Boolean findChild(int[][] graph, int parentVertex) {
		int j = 0;
		for (int i = 0; i < 6; i++) {
			if (graph[parentVertex][i] == 1) {// kuyruktan çekilen node un
												// childlarý bulundu.
				child[j] = i;
				j++;
			}
		}
			if (child != null) {
				return true;
			} else {
				return false;
			}

		
	}
}
