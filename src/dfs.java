//DEPTH FIRST SEARCH
public class dfs {
	private static boolean[] checked = new boolean[6];

	private final static int source = 0;

	public static void main(String[] args) {
		int graph[][] = new int[6][6];

		graph[0][0] = 0; //dizi ile graph oluþturuldu.
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
		
		for (int i = 0; i < 6; i++) {//baþlangýçta tüm nodelarýn durumu unexplored olarak iþaretlendi
			checked[i] = false;

		}
		System.out.println(source);
		depthFirstSearch(graph, source);//depth first search algoritmasý çaðrýldý
	}

	private static void depthFirstSearch(int[][] graph, int source) {

		checked[source] = true;//verilen node explored olarak iþaretlendi
		int j = 0;
		int[] child = new int[6]; //verilen node un childlarý bu dizi içerisine alýnýr
		for (int i = 0; i < 6; i++) {
			if (graph[source][i] == 1) {//eðer graph da aralarýndaki mesafe 1 ise i node u child node dur.
				child[j] = i;
				System.out.println(child[j] + "  child[j]");
				j++;

			}
		}

		for (int i = 0; i < child.length; i++) {//
			{
				if (checked[child[i]] == false) {//eðer graph da aralarýndaki mesafe 1 ise i node u child node dur.
					System.out.println(source + "--" + child[i]);//bunun için recursive fonksiyon kullanýlýr.
					depthFirstSearch(graph, child[i]);//böylece verilen node un öncelikle derinliðe bakýlmýþ  yani child nodelar önce ziyaret edilmiþ olur
				}
			}
		}

	}

}
