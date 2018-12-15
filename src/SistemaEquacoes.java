
public class SistemaEquacoes {
	private double[][] matrizA;
	private double[] matrizB;
	
	public SistemaEquacoes(double[][] matrizA, double[] matrizB) {
		this.matrizA=matrizA;
		this.matrizB=matrizB;
	}
	
	public double[] calcularSistema() {
		double[][] matrizInv = matrizInversa(matrizA);
		double[] matrizX = new double[matrizA.length];
		for(int i=0;i<matrizA.length;i++) {
			matrizX[i]=0;	
			for(int j=0;j<matrizA.length;j++) {
				matrizX[i]+=matrizInv[i][j]*matrizB[j];
			}
		}
		return matrizX;
	}
	
	public double[][] matrizInversa(double[][] matriz){
		double[][] matrizInv = new double[matriz.length][matriz.length];
		double[][] matrizCofat = matrizCofatores(matriz);
		double[][] matrizTrans = matrizTransposta(matrizCofat);
		double det = determinante(matriz);
		for(int i=0;i<matriz.length;i++)
			for(int j=0;j<matriz.length;j++)
				matrizInv[i][j]=1/det*matrizTrans[i][j];
		return matrizInv;
	}
	
	public double[][] matrizCofatores(double[][] matriz){
		double[][] matrizCofat = new double[matriz.length][matriz.length];
		for(int i=0;i<matriz.length;i++)
			for(int j=0;j<matriz.length;j++)
				matrizCofat[i][j]=Math.pow(-1, i+j)*determinante(matrizResultante(matriz,i,j));
		return matrizCofat;
	}
	
	public double[][] matrizResultante(double[][] matriz,int i, int j){
		double[][] matrizRes = new double[matriz.length-1][matriz.length-1];
		int linha=0;
		for(int k=0;k<matriz.length;k++) {
			if(k==i)
				continue;
			else {
				int coluna=0;
				for(int l=0;l<matriz.length;l++) {
					if(l==j)
						continue;
					else {
						matrizRes[linha][coluna]=matriz[k][l];
						coluna++;
					}
				}
				linha++;
			}
		}
		return matrizRes;
	}
	
	public double[][] matrizTransposta(double[][] matriz){
		double[][] matrizTrans = new double[matriz.length][matriz.length];
		for(int i=0;i<matriz.length;i++)
			for(int j=0;j<matriz[i].length;j++)
				matrizTrans[j][i] = matriz[i][j];
		return matrizTrans;
	}
	
	public double determinante(double[][] matriz) {
		if(matriz.length==1)
			return matriz[0][0];
		else if(matriz.length==2)
			return matriz[0][0]*matriz[1][1]-matriz[0][1]*matriz[1][0];
		else if(matriz.length==3)
			return matriz[0][0]*matriz[1][1]*matriz[2][2]+
					matriz[0][1]*matriz[1][2]*matriz[2][0]+
					matriz[1][0]*matriz[2][1]*matriz[0][2]-
					matriz[0][2]*matriz[1][1]*matriz[2][0]-
					matriz[0][0]*matriz[1][2]*matriz[2][1]-
					matriz[0][1]*matriz[1][0]*matriz[2][2];
		else
		{
			double det=0;
			for(int i=0;i<matriz.length;i++) {
				int j=0;
				double[][] matrizRes = matrizResultante(matriz,i,j);
				det+=matriz[i][j]*Math.pow(-1, i+j)*determinante(matrizRes);
			}
			return det;
			
		}
			
	}
	
	
	
}
