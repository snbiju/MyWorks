package com.app.codes.facebook;

public class ProbabilityCalculator {

        public double getHitProbability(int R, int C, int[][] G) {
            // Write your code here
            double counter =0;

            for(int i=0;i<R;i++){
                for(int j=0;j<C;j++){
                    if(G[i][j]==1){
                        counter++;
                    }
                }
            }
             double prob=counter/(R*C);
            if(prob>=1){
                return 1;
            }else{
                return prob;
            }
        }



    public static void main(String[] args) {
            ProbabilityCalculator cal= new ProbabilityCalculator();
            int[][] G ={{0,0,1},{1,0,1}};
        System.out.println(cal.getHitProbability(2,3,G));


    }
}
