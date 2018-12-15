
public class inicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dimMatriz = 2;
		double[][] matrizA = new double[dimMatriz][dimMatriz];
		double[] matrizB = new double[dimMatriz];
		double[] matrizX = new double[dimMatriz];
		
		matrizA[0][0]=2;
		matrizA[0][1]=3;
		matrizA[1][0]=4;
		matrizA[1][1]=2;
		
		matrizB[0]=2;
		matrizB[1]=4;
		
		SistemaEquacoes eqs = new SistemaEquacoes(matrizA,matrizB);	
		

	}

}
