import java.util.ArrayList;

//BREATH FIRST SEARCH 
public class bfs1 {

	private static boolean[] checked = new boolean[6];

	private final static int source = 0;// source de�i�keni ile ba�lang�� node
										// tutulur.Ba�lang�� node 0 olarak
										// belirlenmi�tir

	public static void main(String[] args) {
		int graph[][] = new int[6][6];

		graph[0][0] = 0;// dizi ile graph olu�turuldu.
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

		breathfirst(graph, source);// bfs fonksiyon �a�r�s�

	}

	private static void breathfirst(int[][] graph, int source) {

		for (int i = 0; i < 6; i++) {// ziyaret edilmemi� node lar false olarak
										// initiliaze edildi.
			checked[i] = false;
		}
		int child[] = new int[6];
		// for (int i = 0; i < 6; i++) {
		// child[i] = 0;
		// }
		ArrayList<Integer> parentsQueue = new ArrayList<Integer>();
		checked[source] = true;// source ziyaret edildi.

		parentsQueue.add(source);// source kuyru�a eklendi

		while (!parentsQueue.isEmpty()) {
			int j = 0;
			for (int i = 0; i < 6; i++) {
				child[i] = 0;
			}

			int parentVertex = parentsQueue.remove(0);// kuyruktan �ekilen
														// �nceden ziyart
														// edilmi� node
														// parentVertex
														// de�i�kenine al�nd�
			for (int i = 0; i < 6; i++) {
				if (graph[parentVertex][i] == 1) {// kuyruktan �ekilen node un
													// childlar� bulundu.
					child[j] = i;
					j++;
				}

			}
			//�nceden gidilmemi� olan childlar gidildi olarak i�aretlendi ve kuyru�a eklendi.
			for (int i = 0; i < child.length; i++) {
				if (!checked[child[i]]) {
					
					System.out.println(parentVertex + "--" + child[i]);
					
					checked[child[i]] = true;
					
					parentsQueue.add(child[i]);
				}
			}
		}
	}
}
