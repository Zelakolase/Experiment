public class main {
	static int[] data = {1,9,5,4,8,9,10,45,48,6,5,156,546,89,156,21,546,56
			,6,5,14,145,156,48,15,15,89,02,45,12};
	static int ITER = 100000;
	public static void main(String[] args) {
		System.out.println("QS,MS");
		for(int i = 0;i<550;i++) {
			long F = System.nanoTime();
			for(int o = 0;o<ITER;o++) new QS(data).sort(); // Quick
			if (i>50) System.out.print((System.nanoTime()-F)/ITER + ",");
			F = System.nanoTime();
			for(int o = 0;o<ITER;o++) new MS(data).sort(); // Merge
			if (i>50) System.out.print((System.nanoTime()-F)/ITER + "\n");
		}
	}
}
