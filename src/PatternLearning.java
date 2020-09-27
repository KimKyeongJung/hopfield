public class PatternLearning {
    
    //'ㄱ' 패턴
   private static final int PATTERN1[] = { 
		    1,  1,  1,  1,  1,     //* * * * *
		    1,  1,  1,  1,  1,     //* * * * *
		   -1, -1, -1,  1,  1,     //      * *
		   -1, -1, -1,  1,  1,     //      * *
		   -1, -1, -1,  1,  1      //      * *
   };

    //'ㄴ' 패턴
   private static final int PATTERN2[] = { 
		    1,  1, -1, -1, -1,     //* * 
		    1,  1, -1, -1, -1,     //* *
		    1,  1, -1, -1, -1,     //* *
		    1,  1,  1,  1,  1,     //* * * * *
		    1,  1,  1,  1,  1      //* * * * *
   };

    //'ㄷ' 패턴
   private static final int PATTERN3[] = { 
		   1,  1,  1,  1,  1,     //* * * * *
		   1,  1,  1,  1,  1,     //* * * * *
		   1,  1, -1, -1, -1,     //* *
		   1,  1,  1,  1,  1,     //* * * * *
		   1,  1,  1,  1,  1      //* * * * *
   };
   
 //'ㄹ' 패턴
   private static final int PATTERN4[] = { 
		   1,  1,  1,  1,  1,     //* * * * *
		  -1, -1, -1, -1,  1,     //        *
		   1,  1,  1,  1,  1,     //* * * * *
		   1, -1, -1, -1, -1,     //*
		   1,  1,  1,  1,  1      //* * * * *
   };
   
 //'ㅁ' 패턴
   private static final int PATTERN5[] = { 
		   1,  1,  1,  1,  1,     //* * * * *
		   1,  1,  1,  1,  1,     //* * * * *
		   1,  1, -1,  1,  1,     //* *   * *
		   1,  1,  1,  1,  1,     //* * * * *
		   1,  1,  1,  1,  1      //* * * * *
   };
   

   //a 입력 패턴
   private static final int a[] = { 
		   -1,  1,  1,  1,  1,     //  * * * *
		   -1,  1,  1,  1,  1,     //  * * * *
		   -1, -1, -1,  1,  1,     //      * *
		   -1, -1, -1,  1,  1,     //      * *
		   -1, -1, -1,  1,  1      //      * *
   };
   
   //b 입력 패턴
   private static final int b[] = { 
		    1, -1, -1, -1, -1,     //*  
		    1, -1, -1, -1, -1,     //* 
		    1,  1, -1, -1, -1,     //* *
		    1,  1,  1, -1, -1,     //* * *   
		    1,  1,  1,  1,  1      //* * * * *
  };
   
   //c 입력 패턴
   private static final int c[] = { 
		    1,  1,  1,  1,  1,     //* * * * *
		    1, -1,  1,  1, -1,     //*   * *  
		    1,  1, -1, -1, -1,     //* *
		    1, -1,  1,  1, -1,     //*   * * 
		    1,  1,  1,  1,  1      //* * * * *
  };
   
 //d 입력 패턴
   private static final int d[] = { 
		   -1,  1,  1,  1,  1,     //  * * * *
		   -1, -1, -1, -1,  1,     //        *
		    1, -1,  1,  1,  1,     //*   * * *
		    1, -1, -1, -1, -1,     //*       
		    1,  1,  1,  1, -1      //* * * *
  };
   
 //e 입력 패턴
   private static final int e[] = { 
		   1,  1,  1,  1,  1,     //* * * * *
		   1, -1,  1, -1,  1,     //*   *   *
		   1,  1, -1,  1,  1,     //* *   * *
		   1, -1,  1, -1,  1,     //*   *   *
		   1,  1,  1,  1,  1      //* * * * *
  };
   
   private static int S1[][] = new int[25][25];
   private static int S2[][] = new int[25][25];
   private static int S3[][] = new int[25][25];
   private static int S4[][] = new int[25][25];
   private static int S5[][] = new int[25][25];
   
   private static int W1[][] = new int[25][25]; 
   private static int W2[][] = new int[25][25];
   private static int W3[][] = new int[25][25];
   private static int W4[][] = new int[25][25];
   private static int W5[][] = new int[25][25];
   private static int Wsum[][] = new int[25][25];
   
   public PatternLearning() { //생성자
		 //항등행렬 I 정의
		   int I[][] = new int[25][25];
		   for(int i=0; i<I.length; i++) {
			   for(int j=0; j<I.length; j++) {
				   if(i==j){
					   I[i][j]=1;
				   }
				   else {
					   I[i][j]=0;
				   }
			   }
		   }

		 //'ㄱ', 'ㄴ', 'ㄷ', ‘ㄹ’, ‘ㅁ’ 패턴의 가중치를 구해 가중치들의 합 구하기
		   for(int i=0; i<25; i++) {
			   for(int j = 0; j<25; j++) {
				   S1[i][j]=PATTERN1[i]*PATTERN1[j]; // (S1)^T * (S1)
				   W1[i][j]=S1[i][j]-I[i][j];    // W1 = (S1)^T * (S1) - I
				   S2[i][j]=PATTERN2[i]*PATTERN2[j]; // (S2)^T * (S2) 
				   W2[i][j]=S2[i][j]-I[i][j];	// W2 = (S2)^T * (S2) - I
				   S3[i][j]=PATTERN3[i]*PATTERN3[j]; // (S3)^T * (S3)
				   W3[i][j]=S3[i][j]-I[i][j];	// W3 = (S3)^T * (S3) - I
				   S4[i][j]=PATTERN4[i]*PATTERN4[j]; // (S4)^T * (S4)
				   W4[i][j]=S4[i][j]-I[i][j];	// W4 = (S4)^T * (S4) - I
				   S5[i][j]=PATTERN5[i]*PATTERN5[j]; // (S5)^T * (S5)
				   W5[i][j]=S5[i][j]-I[i][j];	// W5 = (S5)^T * (S5) - I
				   Wsum[i][j]=W1[i][j]+W2[i][j]+W3[i][j]+W4[i][j]+W5[i][j]; 						//Wsum = W1,2,3,4,5의 합
			   }
		   }
		   
		   /** 가중치 합 확인 -> 주석 해제
		   for(int i=0; i<25; i++) {
			   for(int j = 0; j<25; j++) { 
				   System.out.print(Wsum[i][j]+" ");
				   }
			   System.out.println("");
			   }
		   System.out.println(""); */
	   }
   
   //하드리미터 함수 정의
   private int HardLimiter(int data) {	//매개변수가 음수이면 –1 양수이면 1 반환
	      return data < 0 ? -1 : 1; 
	   }
   
   public void PatternDraw(int ary[]) {
	   int temp[] = new int[25]; //초기 출력 * 출력층 첫 번째 뉴런의 가중치
	   int NET[] = new int[25]; //입력 가중합 NET
	   int sum[] = new int[25];//초기출력 * 출력층 첫 번째 뉴런의 가중치들의 합
	   
	   for(int i=0;i<25;i++) {	//NET 값 구하기
		   for(int j=0;j<25;j++) {
			   temp[j] = ary[j]*Wsum[j][i];
			   sum[i] += temp[j];
			   NET[i] = ary[i] + sum[i];
		   }
	   }
	   
	   int HL[] = new int[25];
	   for(int i=0;i<25;i++) {
		   HL[i] = HardLimiter(NET[i]);   //함수 매개변수에 NET값 넣어줌
	   } //하드리미터 함수 호출 후 HL 배열에 저장
	   
	   for(int i=0;i<25;i++) {	//1라인에 5개씩 배치
		   if(i!=0 && i%5==0)
		   {
			   System.out.println("");
		   }
		   System.out.print(HL[i]==1 ? "* " : "  ");
		 //결과 패턴의 가독성을 위해 "* ", "  " 사용
		   }
	   System.out.println("\n");
	   
   }	   

   public static void main(String[] args) {
	   PatternLearning pt = new PatternLearning();
	   
	   System.out.println("-----a-----\n");
	   pt.PatternDraw(a);
	   
	   System.out.println("-----b-----\n");
	   pt.PatternDraw(b);
	   
	   System.out.println("-----c-----\n");
	   pt.PatternDraw(c);
	   
	   System.out.println("-----d-----\n");
	   pt.PatternDraw(d);
	   
	   System.out.println("-----e-----\n");
	   pt.PatternDraw(e);
	   } 
   }
