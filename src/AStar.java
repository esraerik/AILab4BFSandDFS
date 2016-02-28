import java.util.ArrayList;

public class AStar {

	static ArrayList<Integer> openList = new ArrayList<Integer>(6);
	static ArrayList<Integer> closedList = new ArrayList<Integer>(6);
	static int[] h1 = new int[6];
	static int[] f = new int[6];
	static int graph[][] = new int[6][6];
	static int goal = 5;

	public static void main(String[] args) {
		h1[0] = 4;// heuristic
		h1[1] = 2;
		h1[2] = 6;
		h1[3] = 2;
		h1[4] = 3;
		h1[5] = 0;

		openList.add(0);// ba�lang�� node openliste eklendi

		graph[0][0] = 0;// dizi ile graph olu�turuldu.
		graph[0][1] = 1;
		graph[0][2] = 0;
		graph[0][3] = 0;
		graph[0][4] = 0;
		graph[0][5] = 12;
		graph[1][0] = 0;
		graph[1][1] = 0;
		graph[1][2] = 3;
		graph[1][3] = 1;
		graph[1][4] = 0;
		graph[1][5] = 0;
		graph[2][0] = 0;
		graph[2][1] = 0;
		graph[2][2] = 0;
		graph[2][3] = 0;
		graph[2][4] = 3;
		graph[2][5] = 0;
		graph[3][0] = 0;
		graph[3][1] = 0;
		graph[3][2] = 0;
		graph[3][3] = 0;
		graph[3][4] = 1;
		graph[3][5] = 2;
		graph[4][0] = 0;
		graph[4][1] = 0;
		graph[4][2] = 0;
		graph[4][3] = 0;
		graph[4][4] = 0;
		graph[4][5] = 3;
		graph[5][0] = 0;
		graph[5][1] = 0;
		graph[5][2] = 0;
		graph[5][3] = 0;
		graph[5][4] = 0;
		graph[5][5] = 0;
		System.out.println("ba�lad�\n");
		aStar();
		for (int i = 0; i < closedList.size(); i++) {
			System.out.println(closedList.get(i)+"-->");
		}
		
	}

	public static void aStar() {
		int current;
		f[0] = 0 + h1[0];// start node un f i hesapland�
		while (openList.isEmpty()!=false) {
			current = compareF();
			System.out.println("current en k���k f"+current);
			openList.remove(current);// f i en k���k olan� se�tik ve open list
										// den kald�r�p closed list e ekledik.
			closedList.add(current);
			// �imdi bu current in sahip oldu�u kom�ular� bul
			for (int i = 0; i < closedList.size(); i++) {
				System.out.println("\nclosed list"+closedList.get(i));
			}
			
			ArrayList<Integer>komsu=new ArrayList<Integer>();
			komsu = komsuBul(current);
			if (komsu != null) {
				int durum = 0;
				for (int i = 0; i < closedList.size(); i++) {
					for (int j = 0; j <komsu.size() ; j++) {
						if (komsu.get(j) == closedList.get(i)) {
							System.out.println("Bu kom�u closed listte\n"+komsu.get(j));
							komsu.remove(j);
							continue;
						}
						
					}
				}
				int g=0;
				g=findG(current);
				for (int i = 0; i < komsu.size(); i++){
					for (int j = 0; j <openList.size() ; j++) {
						if (komsu.get(i) == openList.get(j)) {
							System.out.println("bu kom�u openlistte\n"+komsu.get(i));
							durum=1;
							break;
						}
					}
					if(durum==0){
						openList.add(komsu.get(i));
						f[openList.get(openList.size()-1)]=g+h1[openList.get(openList.size()-1)];
						}//e�er open list e ekli de�ilse open list e ekledik.
					
				}
				
				
			}
		}

	}

	private static int findG(int current) {
	int g=0;
	for (int i = 0; i < closedList.size(); i++) {
		for (int j = 0; j <current; j++) {
			g+=graph[closedList.get(i)][j];
		}
	}
	return g;
		
	}

	private static ArrayList<Integer> komsuBul(int current) {
		
	ArrayList<Integer>komsular=new ArrayList<Integer>();
		for (int i = 0; i < 6; i++) {

			if (graph[current][i] != 0) {
				komsular.add(i);
			}

		}
		return komsular;

	}

	private static int compareF() {
		int minNode = 0;
		for (int i = 0; i < openList.size(); i++) {
			if (f[openList.get(i)] < f[minNode])
				minNode = i;
		}
		return minNode;
	}

}