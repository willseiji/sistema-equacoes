
public class inicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dimMatriz = 4;
		double[][] matrizA = new double[dimMatriz][dimMatriz];
		double[] matrizB = new double[dimMatriz];
		double[] matrizX = new double[dimMatriz];
		
		matrizA[0][0]=2;
		matrizA[0][1]=3;
		matrizA[0][2]=5;
		matrizA[0][3]=6;
		
		matrizA[1][0]=4;
		matrizA[1][1]=2;
		matrizA[1][2]=1;
		matrizA[1][3]=1;
		
		matrizA[2][0]=5;
		matrizA[2][1]=1;
		matrizA[2][2]=2;
		matrizA[2][3]=3;
		
		matrizA[3][0]=6;
		matrizA[3][1]=1;
		matrizA[3][2]=3;
		matrizA[3][3]=2;
		
		matrizB[0]=2;
		matrizB[1]=4;
		matrizB[2]=6;
		matrizB[3]=10;
		
		SistemaEquacoes eqs = new SistemaEquacoes(matrizA,matrizB);
		matrizX=eqs.calcularSistema();
		for(int i=0;i<matrizX.length;i++)
			System.out.println(matrizX[i]);
			
		

	}

}
